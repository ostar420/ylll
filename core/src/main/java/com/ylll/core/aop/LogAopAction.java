package com.ylll.core.aop;

import com.ylll.core.annotation.SystemLog;
import com.ylll.core.mybatis.model.Log;
import com.ylll.core.service.LogService;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ylll.core.util.Common;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * AOP注解方法实现日志管理 利用spring AOP 切面技术记录日志
 *
 * 定义切面类（这个是切面类和切入点整天合在一起的),这种情况是共享切入点情况;
 */
@Aspect
// 该注解标示该类为切面类
@Component
public class LogAopAction {
    //本地异常日志记录对象
    private static final Logger logger = LoggerFactory.getLogger(LogAopAction.class);
    @Autowired
    private LogService logService;
    
    //Controller层切点

    /**
     *
     */
        @Pointcut("@annotation(com.ylll.core.annotation.SystemLog)")
    public void controllerAspect() {
    }

    private Log getLog(JoinPoint point, String module, String action, String description, String actionTime) {
        String methodName = point.getSignature().getName();
        String className = point.getTarget().getClass().getSimpleName();
        String ip = null;
        String user = null;
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            ip = Common.toIpAddr(request);
        } catch (Exception e) {
            ip = "无法获取登录用户Ip";
        }
        try {
            // 登录名
            user = "test";
            if (Common.isEmpty(user)) {
                user = "无法获取登录用户信息！";
            }
        } catch (Exception ee) {
            user = "无法获取登录用户信息！";
        }
        
        Log log = new Log();
        log.setUsername(user);
        log.setModule(module);
        log.setMethods( className + "." + methodName);
        log.setUserip(ip);
        log.setAction(action);
        log.setDescription(description);
        log.setActiontime(actionTime);
        
        return log;

    }

    /**
     * 操作异常记录
     *
     * @param point
     * @param e
     */
    @AfterThrowing(pointcut = "controllerAspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint point, Throwable e) {

        Map<String, Object> map = null;

        try {
            map = getControllerMethodDescription(point);
            //map.put("description", "执行失败");

        } catch (Exception ee) {
            map = Collections.EMPTY_MAP;
        }
        Log log = getLog(point, map.get("module") + "", map.get("methods") + "", map.get("description") + "", "0");
        logger.info("=====异常通知开始=====");
        logger.info("请求用户:" + log.getUsername());
        logger.info("请求IP:" + log.getUserip());
        logger.info("请求类方法:" +  log.getMethods());
        logger.info("方法模型:" + log.getModule());
        logger.info("方法描述:" + log.getAction());
        //logger.info("错误描述:" + log.getDescription());
        logger.info("异常信息:{}", e.getMessage());
        logger.info("=====异常通知结束=====");
        
    }

    /**
     * 前置通知 用于拦截Controller层记录用户的操作
     *
     * @param point 切点
     * @return Object
     */
    @Around("controllerAspect()")
    public Object doController(ProceedingJoinPoint point) {
        Object result = null;

        Map<String, Object> map = null;
        Long start = 0L;
        Long end = 0L;
        Long time = 0L;

        // 当前用户
        try {
            map = getControllerMethodDescription(point);
            // 执行方法所消耗的时间
            start = System.currentTimeMillis();
            result = point.proceed();
            end = System.currentTimeMillis();
            time = end - start;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        Log log = getLog(point, map.get("module") + "", map.get("methods") + "", map.get("description") + "", time.toString());
       log.setOpertime(new Date());
        try {
            logService.save(log);
        } catch (Exception e) {
            logger.info("插入日志异常:{}", e.getMessage());
        }
        return result;
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public Map<String, Object> getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    SystemLog systemLog =   method.getAnnotation(SystemLog.class);
                    map.put("module",systemLog==null?"": systemLog.module());
                    map.put("methods", systemLog==null?"":systemLog.methods());
                    String de = systemLog==null?"":systemLog.description();
                    if (Common.isEmpty(de)) {
                        de = "执行成功!";
                    }
                    map.put("description", de);
                    break;
                }
            }
        }
        return map;
    }
}

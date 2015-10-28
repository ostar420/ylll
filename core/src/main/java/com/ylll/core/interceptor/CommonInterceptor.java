/**
 *
 */
package com.ylll.core.interceptor;

import com.ylll.core.annotation.ParamVali;
import com.ylll.core.model.ProjectPO;
import com.ylll.core.util.ParamUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author YL
 */
public class CommonInterceptor extends HandlerInterceptorAdapter {

    private final Logger log = LoggerFactory.getLogger(CommonInterceptor.class);
    /*
     * 利用正则映射到需要拦截的路径    
	 
     private String mappingURL;
    
     public void setMappingURL(String mappingURL) {    
     this.mappingURL = mappingURL;    
     }   
     */

    /**
     * 在业务处理器处理请求之前被调用 如果返回false 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
     * 如果返回true 执行下一个拦截器,直到所有的拦截器都执行完毕 再执行被拦截的Controller 然后进入拦截器链,
     * 从最后一个拦截器往回执行所有的postHandle() 接着再从最后一个拦截器往回执行所有的afterCompletion()
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws java.lang.Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        if ("GET".equalsIgnoreCase(request.getMethod())) {

        }
        //这里只进行了 序列号校验 也可以和session 混合校验
        try {

            ParamUtil.executeValiProjectInfo(request);
            log.debug("==============系统校验通过================");
        }
        catch (Exception e) {
            log.debug("==============系统校验不通过================");
            throw e;
        }
        
        //参数校验
        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            ParamVali paramVali = ((HandlerMethod) handler).getMethodAnnotation(ParamVali.class);
            if (paramVali != null) {
                try {
                    log.debug("==============执行参数校验================");
                    ParamUtil.executeValiPara(request, paramVali);
                    log.debug("==============参数校验正确================");

                }
                catch (Exception e) {
                    log.debug("==============参数有误================");
                    throw e;
                }
            }
        }

//        log.info("==============执行顺序: 1、preHandle================");
//        String requestUri = request.getRequestURI();
//        String contextPath = request.getContextPath();
//        String url = requestUri.substring(contextPath.length());
//
//        log.info("requestUri:" + requestUri);
//        log.info("contextPath:" + contextPath);
//        log.info("url:" + url);
//
//        String username = (String) request.getSession().getAttribute("user");
//        if (username == null) {
//        	//log.info("Interceptor：跳转到login页面！");
//            // throw new AccessDeniedException(" oh  no .");
//            //request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
//            return true;
//        } else {
//            return true;
//        }
        return true;
    }

    /**
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作 可在modelAndView中加入数据，比如当前时间
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws java.lang.Exception
     */
    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        //log.debug("==============执行顺序: 2、postHandle================");
    }

    /**
     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等
     *
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws java.lang.Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // log.debug("==============执行顺序: 3、afterCompletion================");
    }

}

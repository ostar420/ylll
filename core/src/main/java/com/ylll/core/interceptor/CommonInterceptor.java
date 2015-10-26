/**
 *
 */
package com.ylll.core.interceptor;

import com.ylll.core.annotation.ParamVali;
import com.ylll.core.mybatis.model.Country;
import com.ylll.core.util.ParamValiUtil;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommonInterceptor extends HandlerInterceptorAdapter {

    private final Logger log = LoggerFactory.getLogger(CommonInterceptor.class);
    public static final String LAST_PAGE = "com.alibaba.lastPage";
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
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        if ("GET".equalsIgnoreCase(request.getMethod())) {

        }
        
        List<Country> list = new ArrayList<>();
        ServletRequestDataBinder binder = new ServletRequestDataBinder(list);
        binder.bind(request);
        System.out.println(JSONArray.fromObject(list));
        
        
//        RequestBean<Country> bean = new SpringRequestToBean<Country>().requestToBean(request);
//        System.out.println(JSONObject.fromObject(bean));
        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {

            ParamVali paramVali = ((HandlerMethod) handler).getMethodAnnotation(ParamVali.class);
            
            if (paramVali != null) {
                log.debug("==============执行参数校验================");
                ParamValiUtil.execute(request, paramVali);
                log.debug("==============参数校验正确================");
            }

        }

        log.info("==============执行顺序: 1、preHandle================");
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestUri.substring(contextPath.length());

        log.info("requestUri:" + requestUri);
        log.info("contextPath:" + contextPath);
        log.info("url:" + url);

        String username = (String) request.getSession().getAttribute("user");
        if (username == null) {
        	//log.info("Interceptor：跳转到login页面！");
            // throw new AccessDeniedException(" oh  no .");
            //request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
            return true;
        } else {
            return true;
        }
    }

    /**
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作 可在modelAndView中加入数据，比如当前时间
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     */
    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        log.info("==============执行顺序: 2、postHandle================");
        if (modelAndView != null) {  //加入当前时间  
            modelAndView.addObject("var", "测试postHandle");
        }
    }

    /**
     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等
     *
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
     *
     * @param request
     * @param response
     * @param handler
     * @throws java.lang.Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        log.info("==============执行顺序: 3、afterCompletion================");
    }

}

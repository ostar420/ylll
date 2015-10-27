package com.ylll.core.util;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.ServletRequestDataBinder;

/**
 *
 * @author YL
 */
public class SpringRequestToBean {
    /**
     * 基于spring 封装请求数据
     * @param <T>
     * @param request
     * @param cla
     * @return
     * @throws Exception 
     */
    public static <T> T requestToBean(HttpServletRequest request,Class<T> cla) throws Exception{
        T  t = cla.getConstructor(new Class[] {}).newInstance(  
                new Object[] {}); 
        ServletRequestDataBinder binder = new ServletRequestDataBinder(t);
        binder.bind(request);
        return t;
    }
}

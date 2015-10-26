/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ylll.core.util;

import com.ylll.core.model.RequestBean;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.sf.json.JSONObject;
import org.springframework.web.bind.ServletRequestDataBinder;

/**
 *
 * @author YL
 * @param <T>
 */
public class SpringRequestToBean<T> {
    /**
     * 基于spring 封装请求数据
     * @param request
     * @return
     * @throws Exception 
     */
    public RequestBean<T> requestToBean(HttpServletRequest request) throws Exception{
        
        RequestBean<T> bean = new RequestBean<T>();
        ServletRequestDataBinder binder = new ServletRequestDataBinder(bean);
        binder.bind(request);
        return bean;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ylll.core.util;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author YL
 */
public class BaseControllerSupport {
    public static final Logger logger = LoggerFactory.getLogger(BaseControllerSupport.class);
    
    @Autowired
    private HttpServletRequest request;

    /**
     *
     * @param <T>
     * @param cla
     * @return
     * @throws Exception
     */
    public <T> T convertToBean(Class<T> cla) throws Exception {
        return convertToBean(request, cla);
    }

    /**
     *
     * @param <T>
     * @param cla
     * @return
     * @throws Exception
     */
    public <T> List<T> convertToBeanList(Class<T> cla) throws Exception {
        return convertToBeanList(request, cla);
    }

    /**
     *
     * @param <T>
     * @param request
     * @param cla
     * @return
     * @throws Exception
     */
    public <T> T convertToBean(HttpServletRequest request, Class<T> cla) throws Exception {
        String json = getRequestData(request);
        if (json == null || json.trim().equals("")) {
            return JsonToBean.getObjectByClass(cla);
            
        }
        return JsonToBean.convertToBean(json, cla);
    }

    /**
     *
     * @param <T>
     * @param request
     * @param cla
     * @return
     * @throws Exception
     */
    public <T> List<T> convertToBeanList(HttpServletRequest request, Class<T> cla) throws Exception {
        String json = getRequestData(request);
        if (json == null || json.trim().equals("")) {
            return new ArrayList<T>();
        }
        return JsonToBean.convertToBeanList(json, cla);
    }

    /**
     *
     * @param request
     * @return
     */
    public String getRequestData(HttpServletRequest request) {
        return ParamUtil.getDataStrFromRequest(request);
    }
    /**
     * 
     * @return 
     */
    public String getRequestData() {
        return getRequestData(request);
    }
    /**
     * 分页参数 获取页数 注意:这时data参数内放置的是对象 ,不能是数组 前台传入参数 data:{_page:1}
     *
     * @return
     */
    public int getPage() {
        return getPage(request);
    }

    /**
     * 分页参数 获取行数 注意:这时data参数内放置的是对象 ,不能是数组 前台传入参数 data:{_rows:10}
     *
     * @return
     */
    public int getRows() {
        return getRows(request);
    }

    /**
     * 分页参数 获取页数 注意:这时data参数内放置的是对象 ,不能是数组 前台传入参数 data:{_page:1}
     *
     * @param request
     * @return
     */
    public int getPage(HttpServletRequest request) {
        return ParamUtil.getPage(request);
    }

    /**
     * 分页参数 获取行数 注意:这时data参数内放置的是对象 ,不能是数组 前台传入参数 data:{_rows:10}
     *
     * @param request
     * @return
     */
    public int getRows(HttpServletRequest request) {
        return ParamUtil.getRows(request);
    }
    
}

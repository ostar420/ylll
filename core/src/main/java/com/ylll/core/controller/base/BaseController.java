/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ylll.core.controller.base;

import com.ylll.core.util.JsonToBean;
import com.ylll.core.util.ParamUtil;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author YL
 */
public class BaseController {

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
            return null;
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
            return null;
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
    
}

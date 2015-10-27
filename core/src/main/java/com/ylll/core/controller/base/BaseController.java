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

    public <T> T convertToBean(Class<T> cla) throws Exception {
        return convertToBean(request, cla);
    }

    public <T> List<T> convertToBeanList(Class<T> cla) throws Exception {
        return convertToBeanList(request, cla);
    }

    public <T> T convertToBean(HttpServletRequest request, Class<T> cla) throws Exception {
        String json = getRequestData(request);
        if (json == null || json.trim().equals("")) {
            return null;
        }
        return JsonToBean.convertToBean(json, cla);
    }

    public <T> List<T> convertToBeanList(HttpServletRequest request, Class<T> cla) throws Exception {
        String json = getRequestData(request);
        if (json == null || json.trim().equals("")) {
            return null;
        }
        return JsonToBean.convertToBeanList(json, cla);
    }

    public String getRequestData(HttpServletRequest request) {
        return ParamUtil.getDataStrFromRequest(request);
    }

}

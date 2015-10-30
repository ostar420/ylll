/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ylll.wx.controller;

import com.ylll.core.BeseSpringTestSupport;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

/**
 *
 * @author YL
 */
public class UserInfoControllerTest extends BeseSpringTestSupport {

    /**
     * Test of findPage method, of class UserInfoController.
     * @throws java.lang.Exception
     */
    private  static  final String baseUrl ="/user/";
    
    //@Test
    public void testFindPage() throws Exception {
        System.out.println("findPage");
        String data = "{\"name\":\"%3\",\"_page\":2,\"_rows\":10}";
        MvcResult result = basePerformMock(data, baseUrl+"findPage");
    }
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        String data = "{\"name\":\"ffs ff\",\"id\":\"3\"}";
        MvcResult result = basePerformMock(data, baseUrl+"add");
    }
    
    //@Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        String data = "{\"name\":\"fff\",\"id\":\"3\"}";
        MvcResult result = basePerformMock(data, baseUrl+"update");
    }
    //@Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        String data = "{\"name\":\"fff\",\"id\":\"3\"}";
        MvcResult result = basePerformMock(data, baseUrl+"delete");
    }
    //@Test
    public void findSingle() throws Exception {
        System.out.println("findSingle");
        String data = "{\"name\":\"fff\",\"id\":\"4\"}";
        MvcResult result = basePerformMock(data, baseUrl+"findSingle");
    }
}

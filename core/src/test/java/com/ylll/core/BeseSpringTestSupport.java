/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ylll.core;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Spring 基础测试类
 *
 * @author YL
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(locations = {"classpath:spring-application.xml", "classpath:spring-mvc.xml"})
public class BeseSpringTestSupport extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private WebApplicationContext wac;

    /**
     *
     */
    public MockMvc mockMvc;

    @Before  
    public void setUp() {  
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  
    }  

    @Test
    public void testSpringCof() {
    }
    public String convertArrToString(Object arr){
        return JSONArray.fromObject(arr).toString();
    } 
    public String convertObjToString(Object obj,int page,int rows){
       JSONObject jSONObject =  JSONObject.fromObject(obj);
       jSONObject.put("_page", page);
       jSONObject.put("_rows", rows);
        return jSONObject.toString();
    } 
    public String convertObjToString(Object obj){
        return JSONObject.fromObject(obj).toString();
    } 
    
    public  MvcResult basePerformMock(String data,String url) throws Exception{
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .param("project_version", project_version)
                .param("project_seq", project_seq)
                .param("data", data)
                )
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        return result;
    }
    
    public static final String project_version = "1.0";
   
    public static final String project_seq = "Nw5Yu5wfCl1MrE+yK/ClJQ==";
}

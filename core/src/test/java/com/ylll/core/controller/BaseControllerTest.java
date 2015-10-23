/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ylll.core.controller;



import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
/**
 *
 * @author YL
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration(locations = {"classpath:spring-application.xml","classpath:spring-mvc.xml" })
public class BaseControllerTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired  
    private WebApplicationContext wac;  
    public MockMvc mockMvc;  
    
    @Before  
    public void setUp() {  
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  
    }  
}

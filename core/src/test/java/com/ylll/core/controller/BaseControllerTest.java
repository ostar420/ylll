/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ylll.core.controller;



import net.sf.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
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
    @Test
    public void testMain(){
     MockMultipartHttpServletRequest request=new MockMultipartHttpServletRequest();
  request.addParameter("Article.title","title");
  request.addParameter("Article.summary","summary");
  request.addParameter("Article.text","text");
  request.addParameter("Article.published","on");
  Object a=new Object();
  ServletRequestDataBinder binder=new ServletRequestDataBinder(a);
  //binder.setDisallowedFields(new String[]{"published"});
  binder.bind(request);
  BindingResult result=binder.getBindingResult();
  
  System.out.println(JSONObject.fromObject(a));
//  assertEquals(result.getErrorCount(),0);
//  assertEquals(a.getTitle(),"title");
//  assertEquals(a.getSummary(),"summary");
//  assertEquals(a.getPublished(),"on");
    
    
    
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ylll.core.controller;



import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
/**
 *
 * @author YL
 */
@ContextConfiguration(locations = {"classpath:spring-mvc.xml",
         "classpath:spring-application.xml" })

public class BaseControllerTest extends AbstractTransactionalJUnit4SpringContextTests {
    
    @Test
    public void testMain(){
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ylll.core.controller.demo;

import com.ylll.core.controller.BaseControllerTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 *
 * @author YL
 */
public class CountryControllerTest extends BaseControllerTest{

    /**
     * Test of getList method, of class CountryController.
     */
    @Test
    public void testGetList() throws Exception {
        System.out.println("getList");
       
    }

    /**
     * Test of view method, of class CountryController.
     */
    @Test
    public void testView() throws Exception {
        System.out.println("view");
       
    }

    /**
     * Test of save method, of class CountryController.
     * @throws java.lang.Exception
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
         MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/save").param("countryname", "z").param("countrycode", "z"))  
            .andExpect(MockMvcResultMatchers.view().name("redirect:list"))  
            //.andExpect(MockMvcResultMatchers.model().attributeExists("allErrors"))  
                // setValidator(Validator validator)//：设置验证器
            .andDo(MockMvcResultHandlers.print())  
            .andReturn();  
      
         //Assert.assertNotNull(result.getModelAndView().getModel().get("allErrors"));  
       
    }

    /**
     * Test of batchInsert method, of class CountryController.
     */
    @Test
    public void testBatchInsert() {
        System.out.println("batchInsert");
        
    }

    /**
     * Test of delete method, of class CountryController.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        
    }
    
}

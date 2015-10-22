/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ylll.core.controller.demo;

import com.github.pagehelper.PageInfo;
import com.ylll.core.controller.BaseControllerTest;
import com.ylll.core.model.Country;
import com.ylll.core.service.CountryService;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

/**
 *
 * @author YL
 */
public class CountryControllerTest  extends BaseControllerTest{
    @Inject
    private CountryController countryController;
    
     @Test
    public void testSave() throws Exception {
        List<Country> list = new ArrayList<>();
        Country country = new Country();
        country.setCountryname("中国");
        country.setCountrycode("ZH");
        list.add(country);
        country.setCountryname("中国1");
        list.add(country);
        country.setCountryname("中国2");
        list.add(country);
        int result =  countryController.batchInsert(list);
        assertEquals(3, result);
    }
    /**
     * 
     * @throws Exception 
     */
//    @Test
//    public void testGetList() throws Exception {
//      
//        MockHttpServletRequest request = new MockHttpServletRequest();  
//        MockHttpServletResponse response = new MockHttpServletResponse();  
//        
//        Country country = new Country();
//        List<Country> countryList = countryService.selectByCountry(country, 1, 10);
//        PageInfo<Country>  pageinfo = new PageInfo<>(countryList);
//        //assertEquals(1, pageinfo.getFirstPage());
//       // assertEquals(10, pageinfo.getSize());
//        
//
//    }

    
    
}

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
    private CountryService countryService;
    
     @Test
    public void testSave() throws Exception {
        Country country = new Country();
        country.setCountryname("中国");
        country.setCountrycode("ZH");
        int result =  countryService.save(country);
        assertEquals(1, result);
    }
    /**
     * 
     * @throws Exception 
     */
    @Test
    public void testGetList() throws Exception {
      
        MockHttpServletRequest request = new MockHttpServletRequest();  
        MockHttpServletResponse response = new MockHttpServletResponse();  
        
        Country country = new Country();
        List<Country> countryList = countryService.selectByCountry(country, 1, 10);
        PageInfo<Country>  pageinfo = new PageInfo<>(countryList);
        //assertEquals(1, pageinfo.getFirstPage());
       // assertEquals(10, pageinfo.getSize());
        

    }

    
    
}

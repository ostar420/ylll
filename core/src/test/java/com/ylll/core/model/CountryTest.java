/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ylll.core.model;

import com.ylll.core.mybatis.model.CountryList;
import com.ylll.core.mybatis.model.Country;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author YL
 */
public class CountryTest  {
    private static Validator validator;

    public CountryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Country.
     */
    @Test
    public void testCountryVali() {
//        Country country  = new Country();
//        country.setCountryname("2");
//        country.setCountrycode("1");
//        Set<ConstraintViolation<Country>> constraintViolations =
//        validator.validateProperty(country, "countrycode");
//        System.out.println(constraintViolations.size());
//        
//        Iterator<ConstraintViolation<Country>> it =  constraintViolations.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next().getMessage());
//        }
        
//        Map<String,String> map = new HashMap<>();
//        map.put("countryname", "z");
//        
//        List<Country> list = new ArrayList<>();
//        Country country  = new Country();
//        country.setCountryname("2");
//        Country country1  = new Country();
//        country1.setCountrycode("1");
//        list.add(country);
//        list.add(country1);
//        CountryList clist = new CountryList();
//        clist.setList(list);
//        
//        
//        
//        String json = "{\"list\":[{\"countrycode\":\"\",\"countryname\":\"2\",\"id\":0},{\"countrycode\":\"1\",\"countryname\":\"\",\"id\":0}]}";
//        JSONObject obj = JSONObject.fromObject(json);
//        CountryList cli = (CountryList)JSONObject.toBean(obj, CountryList.class);
//         
//         List<Country> lists =cli.getList();
//         System.out.println("lists = " + lists.size());
//        System.out.println(JSONObject.fromObject(cli));
//        Set<ConstraintViolation<CountryList>> constraintViolations =
//       validator.validate(clist);
//         Iterator<ConstraintViolation<CountryList>> it =  constraintViolations.iterator();
//         while (it.hasNext()) {
//           System.out.println(it.next().getMessage());
//        }
       // assertEquals(2, constraintViolations.size());
       //assertEquals("may not be null", constraintViolations.iterator().next().getMessage());

       
    }

   
    
}

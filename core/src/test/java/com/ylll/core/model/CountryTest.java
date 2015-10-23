/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ylll.core.model;

import java.util.Iterator;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author YL
 */
public class CountryTest {
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
        Country country  = new Country();
        country.setCountryname("2");
        Set<ConstraintViolation<Country>> constraintViolations =
        validator.validate(country);
        System.out.println(constraintViolations.size());
        
        Iterator<ConstraintViolation<Country>> it =  constraintViolations.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().getMessage());
        }
        
       // assertEquals(2, constraintViolations.size());
       //assertEquals("may not be null", constraintViolations.iterator().next().getMessage());

       
    }

   
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ylll.core.model;

import com.ylll.core.mybatis.model.Country;
import com.ylll.core.mybatis.model.CountryList;
import com.ylll.core.util.JsonToBean;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
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
    public void testCountryVali() throws Exception {
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
//        
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
        CountryList clist = new CountryList();
//        clist.setList(list);
////        
////        
////        
//        String json = "{\"project_seq\":\"123\",\"project_version\":\"1.0\",\"data\":[{\"countrycode\":\"\",\"countryname\":\"2\",\"id\":0},{\"countrycode\":\"1\",\"countryname\":\"\",\"id\":0}]}";
//        JSONObject obj = JSONObject.fromObject(json);
//       JSONArray o  =  obj.getJSONArray("data");
//        
//       
//       RequestBeanTest cli = (RequestBeanTest)JSONObject.toBean(obj, RequestBeanTest.class);
//       cli.setData(list);
//          //CountryList cliCopy = copy(obj,CountryList.class);
//        System.out.println(JSONObject.fromObject(cli));
//        String jsonarr = "[{\"countrycode\":\"\",\"countryname\":\"2\",\"id\":0},{\"countrycode\":\"1\",\"countryname\":\"333\",\"id\":0}]";
//
//              List<Country> c = JsonToBean.convertToBeanList(jsonarr,Country.class);
//              
//              clist.setList(c);
//              
//        Set<ConstraintViolation<CountryList>> constraintViolations =
//        validator.validate(clist);
//         Iterator<ConstraintViolation<CountryList>> it =  constraintViolations.iterator();
//         while (it.hasNext()) {
//           System.out.println(it.next().getMessage());
//        }
       // assertEquals(2, constraintViolations.size());
       //assertEquals("may not be null", constraintViolations.iterator().next().getMessage());

       
    }
    
    
    public <T>T copy(JSONObject object,Class<T> cla) throws Exception {  
        T  t = cla.getConstructor(new Class[] {}).newInstance(  
                new Object[] {});
        Field[] fields = cla.getDeclaredFields();  
        for (Field field : fields) {  
            String name = field.getName();  
           Object  obj =   object.get(name);
           String firstLetter = name.substring(0, 1).toUpperCase();  
            String getMethodName = "get" + firstLetter + name.substring(1);  
            String setMethodName = "set" + firstLetter + name.substring(1); 
            Method getMethod = cla.getMethod(getMethodName,  
                    new Class[] {});  
            Method setMethod = cla.getMethod(setMethodName,  
                    new Class[] { field.getType() });  
            System.out.println("obj = " + obj);
                    
            setMethod.invoke(t, new Object[] { obj });  
        }
        
        
        return t;
    }

   /** 
     * 通过一个对象利用反射技术将其复制 
     *  
     * @param 参数object 
     * @return 复制的Object对象 
     * @throws Exception 
     */  
    public <T>T copy(Object object,Class<T> cla) throws Exception {  
        T  t = cla.getConstructor(new Class[] {}).newInstance(  
                new Object[] {});  
        Field[] fields = cla.getDeclaredFields();  
        for (Field field : fields) {  
            Class type = field.getType();
             System.out.println(type);  
            String name = field.getName();  
            String firstLetter = name.substring(0, 1).toUpperCase();  
            String getMethodName = "get" + firstLetter + name.substring(1);  
            String setMethodName = "set" + firstLetter + name.substring(1);  
            Method getMethod = cla.getMethod(getMethodName,  
                    new Class[] {});  
            Method setMethod = cla.getMethod(setMethodName,  
                    new Class[] { field.getType() });  
            Object value = getMethod.invoke(object, new Object[] {});  
             System.out.println( value.getClass());  
            System.out.println(value);  
            setMethod.invoke(t, new Object[] { value });  
        }  
        return t;  
    }  
    
}

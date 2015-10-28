package com.ylll.core.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author YL
 */
public class JsonToBean {
    
    private static final Logger logger = LoggerFactory.getLogger(JsonToBean.class);
    /**
     * 
     * @param json
     * @return
     * @throws Exception 
     */
    public static JSONObject convertToJSONObject(String json) throws Exception {
        logger.debug("request :{}",json);
        return JSONObject.fromObject(json);
    }
    /**
     * 
     * @param json
     * @return
     * @throws Exception 
     */
    public static JSONArray convertToJSONArray(String json) throws Exception {
        logger.debug("request :{}",json);
        return JSONArray.fromObject(json);
    }
    /**
     * 
     * @param <T>
     * @param json
     * @param cla
     * @return
     * @throws Exception 
     */
    public static <T> List<T> convertToBeanList(String json, Class<T> cla) throws Exception {
        return convertToBeanList(convertToJSONArray(json), cla);
    }
    /**
     * 
     * @param <T>
     * @param json
     * @param cla
     * @return
     * @throws Exception 
     */
    public static <T> List<T> convertToBeanList(JSONArray json, Class<T> cla) throws Exception {
        List<T> list = new ArrayList<>();
        if (json == null) {
            return list;
        }
        for (int i = 0; i < json.size(); i++) {
            list.add(convertToBean(json.getJSONObject(i), cla));
        }
        
        logger.debug("beanarr :{}",JSONArray.fromObject(list).toString());
        return list;
    }
    /**
     * 
     * @param <T>
     * @param json
     * @param cla
     * @return
     * @throws Exception 
     */
    public static <T> T convertToBean(String json, Class<T> cla) throws Exception {
        return convertToBean(convertToJSONObject(json), cla);
    }
    /**
     * 
     * @param <T>
     * @param json
     * @param cla
     * @return
     * @throws Exception 
     */
    public static <T> T convertToBean(JSONObject json, Class<T> cla) throws Exception {
        T t = getObjectByClass(cla);
       Set<Object> set =  json.keySet();
       if(set!=null && set.size()>0){
           for (Object obj : set) {
               String propertyName = String.valueOf(obj); 
               if(isCheckBeanExitsPropertyName(cla,propertyName)){
                   Object propertyValue = json.get(obj);
                   setProperties(t,propertyName,propertyValue);
               }
           }
       }
        logger.debug("beanobj :{}",JSONObject.fromObject(t).toString());
        return t;
    }
    
    private  static boolean isCheckBeanExitsPropertyName(Class<?> clazz,String propertyName){	
		boolean retValue = false;
		try {
			Field field =  clazz.getDeclaredField(propertyName);			
			if(null != field){
				retValue = true;
			}
		} catch (NoSuchFieldException e) {
                        if(!propertyName.equalsIgnoreCase(ParamUtil.PAGE_PARAM) &&!propertyName.equalsIgnoreCase(ParamUtil.ROWS_PARAM) )
			logger.debug("类: " + clazz.getSimpleName()+",不存在属性名: "+propertyName+" ,详细错误信息: "+e.getMessage());		
		}
		return retValue;
		
    }
   /**
    * 
    * @param <T>
    * @param clazz
    * @return
    * @throws Exception 
    */
    public static <T> T getObjectByClass(Class<T> clazz) throws Exception {
        try {
            T t = clazz.getConstructor(new Class[]{}).newInstance(new Object[]{});
            return t;

        }
        catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new Exception(" instance class error:" + e.getMessage());
        }
    }
 /**  
     * 设置字段值      
     * @param object          实例对象  
     * @param propertyName 属性名  
     * @param value        新的字段值  
     * @throws java.beans.IntrospectionException  
     * @throws java.lang.IllegalAccessException  
     * @throws java.lang.reflect.InvocationTargetException  
     */   
    public static void setProperties(Object object, String propertyName,Object value) throws IntrospectionException,   
            IllegalAccessException, InvocationTargetException {   
        PropertyDescriptor pd = new PropertyDescriptor(propertyName,object.getClass());   
        Method methodSet = pd.getWriteMethod();   
        methodSet.invoke(object,value);   
    }     
  
}

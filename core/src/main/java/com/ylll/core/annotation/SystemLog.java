package com.ylll.core.annotation;  
  
import java.lang.annotation.*;  
  
/** 
 *自定义注解 拦截Controller 
 */  
  
@Target({ElementType.PARAMETER, ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented  
public  @interface SystemLog {  
  
	String module()  default "";  //模块名称 用户管理
	String methods()  default "";  //新增用户
        String description()  default "";  //
  
  
}  
  

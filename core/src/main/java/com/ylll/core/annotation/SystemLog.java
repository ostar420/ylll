package com.ylll.core.annotation;  
  
import java.lang.annotation.*;  
  
/** 
 *自定义注解 拦截Controller 
 */  
  
@Target({ElementType.PARAMETER, ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented  
public  @interface SystemLog {  
  
    /**
     *
     * @return
     */
    String module()  default "";  //模块名称 用户管理

    /**
     *
     * @return
     */
    String methods()  default "";  //新增用户

    /**
     *
     * @return
     */
    String description()  default "";  //
  
  
}  
  

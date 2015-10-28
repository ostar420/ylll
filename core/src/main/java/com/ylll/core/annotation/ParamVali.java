package com.ylll.core.annotation;  
  
import java.lang.annotation.*;  
  
/** 
 *自定义注解 拦截Controller 
 */  
  
@Target({ElementType.PARAMETER, ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented  
public  @interface ParamVali {  
    
    /**
     *
     * @return
     */
    Class bean(); 
    /**
     * 是否集合
     * @return 
     */
    boolean isList() default false;
    
    /**
     *校验参数,默认全部校验
     * @return
     */
    String[] params()  default {};  
    

    /**
     *描述
     * @return
     */
    String description()  default "";  //
  
  
}  
  

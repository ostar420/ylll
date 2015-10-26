package com.ylll.core.annotation;  
  
import com.ylll.core.util.ParamValiUtil;
import java.lang.annotation.*;  
  
/** 
 *自定义注解 拦截Controller 
 */  
  
@Target({ElementType.PARAMETER, ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented  
public  @interface ParamVali {  
    
    Class bean() ; 
    
    /**
     *校验参数,默认全部校验
     * @return
     */
    String[] params()  default {};  
    
    /**
     *校验方法
     * ParamValiUtil.BEAN_TYPE等
     * @return
     */
    String valiType()  default ParamValiUtil.BEAN_TYPE;  

    /**
     *
     * @return
     */
    String description()  default "";  //
  
  
}  
  

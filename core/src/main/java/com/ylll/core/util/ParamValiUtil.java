package com.ylll.core.util;

import com.ylll.core.annotation.ParamVali;
import com.ylll.core.conf.Service;
import com.ylll.core.exception.ParameterException;
import java.util.Iterator;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *校验处理类
 */
public class ParamValiUtil {
    public static final String BEAN_TYPE = "BEAN";
    public static final String SINGLE_TYPE = "SINGLE";
    public static final String JSON_TYPE = "JSON";
    public static final String LIST_TYPE = "LIST";
    
    private static Validator validator= null;
    static{
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    public static void execute(HttpServletRequest request, ParamVali paramVali) {
        
       String type =  paramVali.valiType();
       Class bean =   paramVali.bean();
       String[] params = paramVali.params();
        switch (type) {
            case BEAN_TYPE:
                Set<ConstraintViolation<Object>> constraintViolations = null;
                try {
                  if(params!=null && params.length!=0){//vali all params
                   for(int i = 0;i<params.length;i++){
                       if(i==0){
                           constraintViolations = validator.validateProperty(RequestToBean.getBeanToRequest(request, bean), params[i]);
                           continue;
                       }
                        constraintViolations.addAll(validator.validateProperty(RequestToBean.getBeanToRequest(request, bean), params[i]));
                   }
                    
                } else {
                    //vali all params
                    constraintViolations =  validator.validate( RequestToBean.getBeanToRequest(request, bean));
                 }
                }
                catch (Exception e) {
                    throw new ParameterException(Service.getMessageExceptionParameter());
                }
                
                if(constraintViolations!=null){
                    StringBuilder sb = new StringBuilder();
                    Iterator<ConstraintViolation<Object>> it =  constraintViolations.iterator();
                    while (it.hasNext()) {
                        sb.append(it.next().getMessage()).append(";");
                    }
                    if(sb.length()>0){
                         throw new ParameterException(sb.toString());
                    }
                }
                
                
                break;
            case SINGLE_TYPE:
                break;
            case JSON_TYPE:
                break;
        }
       
       
        
    }
    
    
}

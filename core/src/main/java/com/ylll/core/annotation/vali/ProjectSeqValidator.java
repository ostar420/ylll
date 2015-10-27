/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ylll.core.annotation.vali;

import com.ylll.core.util.ProjectSeqUtil;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author YL
 */
public class ProjectSeqValidator implements ConstraintValidator<ProjectSeq,String>{

    @Override
    public void initialize(ProjectSeq constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return ProjectSeqUtil.sign(value);
    }
    
}

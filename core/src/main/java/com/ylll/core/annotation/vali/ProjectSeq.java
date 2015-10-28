package com.ylll.core.annotation.vali;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

/**
 * 自定义 密钥校验
 * @author YL
 */
@Target( { METHOD, FIELD, ANNOTATION_TYPE })  
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProjectSeqValidator.class)
@Documented
public @interface ProjectSeq {

    /**
     *
     * @return
     */
    String message() default "{ylll.project.seq.error}";

    /**
     *
     * @return
     */
    Class<?>[] groups() default {};

    /**
     *
     * @return
     */
    Class<? extends Payload>[] payload() default {};
}

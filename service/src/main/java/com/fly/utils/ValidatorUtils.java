package com.fly.utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @Author : liufei on 2018/3/29
 */
public class ValidatorUtils {
    private static Validator validator;

    static {

        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public static void validateEntity(Object o) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(o);
        if (!constraintViolations.isEmpty()) {
            StringBuilder returnStr = new StringBuilder();
            for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
                returnStr.append(constraintViolation.getMessage()).append("<br>");
            }
            throw new RuntimeException(returnStr.toString());
        }
    }
}

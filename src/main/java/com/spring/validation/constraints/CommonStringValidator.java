package com.spring.validation.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CommonStringValidator implements ConstraintValidator<CommonString, String> {

    int maxLength;
    REGEX[] regex;

    @Override
    public void initialize(CommonString constraintAnnotation) {
        maxLength = constraintAnnotation.length();
        regex = constraintAnnotation.regex();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        String value = s == null ? "" : s;
        
        boolean lengthCheck = value.length() <= maxLength;
        
        boolean regexCheck = true;
        for (REGEX reg : regex) {
            regexCheck = regexCheck && value.matches(reg.regexPattern);
        }

        constraintValidatorContext.disableDefaultConstraintViolation();
        if (!lengthCheck) {
            constraintValidatorContext.buildConstraintViolationWithTemplate(
                    "{string.length.invalid.message}"
            ).addConstraintViolation();
        }
        if (!regexCheck) {
            constraintValidatorContext.buildConstraintViolationWithTemplate(
                    "{string.regex.invalid.message}"
            ).addConstraintViolation();
        }
        return lengthCheck && regexCheck;
    }
}

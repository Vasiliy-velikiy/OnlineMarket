package com.moskalev.validation.annotaton;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 24.02.22
 * Validator for phoneNumber
 */
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    /**
     * pass data in annotation
     */
    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    /**
     * @param value -phone number
     * @param constraintValidatorContext-context where makes validation
     * @return valid or not valid
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return value == null || value.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
    }
}

package com.moskalev.validation.annotaton;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 24.02.22
 * Annotation for phoneNumber
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneNumberValidator.class)
@Documented
public @interface PhoneNumber {

    /**
     * Show this message if phone number not valid
     */
    String message() default "This phone number not valid";

    /**
     * method for metaInformation
     */
    Class<?>[] groups() default {};

    /**
     * method for metaInformation
     */
    Class<? extends Payload>[] payload() default {};
}

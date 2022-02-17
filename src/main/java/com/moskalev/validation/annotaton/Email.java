package com.moskalev.validation.annotaton;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Documented
public @interface Email {
    String message()default "This email not valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {}; //metainformation
}

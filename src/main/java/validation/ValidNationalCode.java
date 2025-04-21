package validation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NationalCodeValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidNationalCode {
    String message() default "Invalid national code";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

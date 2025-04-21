package validation;

import com.spring.airline.Enums.Country;
import com.spring.airline.Exceptions.InvalidPhoneNumberException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Field;


public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, Object> {

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        try {
            Class<?> clazz = obj.getClass();

            Field phoneField = clazz.getDeclaredField("phoneNumber");
            Field countryField = clazz.getDeclaredField("country");

            phoneField.setAccessible(true);
            countryField.setAccessible(true);

            String phone = (String) phoneField.get(obj);
            Country country = (Country) countryField.get(obj);

            if (phone == null || country == null) return false;

            boolean isValid = switch (country) {
                case IRAN -> phone.matches("^09\\d{9}$");
                case USA -> phone.matches("^\\+1\\d{10}$");
                case GERMANY -> phone.matches("^\\+49\\d{10,14}$");
                case FRANCE -> phone.matches("^\\+33\\d{9}$");
                case INDIA -> phone.matches("^\\+91\\d{10}$");
                default -> false;
            };

            if (!isValid) {
                throw new InvalidPhoneNumberException("The phone number is not valid for : " + country);
            }

            return true;

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.getCause();
            return false;
        }
    }
}


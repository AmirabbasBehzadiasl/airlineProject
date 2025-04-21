package validation;


import com.spring.airline.Enums.Country;
import com.spring.airline.Exceptions.InvalidNationalCodeException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Field;

public class NationalCodeValidator implements ConstraintValidator<ValidNationalCode, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) return true;

        try {
            Class<?> clazz = value.getClass();

            Field codeField = clazz.getDeclaredField("nationalCode");
            Field countryField = clazz.getDeclaredField("Nationality");

            codeField.setAccessible(true);
            countryField.setAccessible(true);

            String code = (String) codeField.get(value);
            Country country = (Country) countryField.get(value);

            if (code == null || country == null) return false;

            boolean isValid = switch (country) {
                case IRAN -> code.matches("\\d{10}");
//                        && isValidIranCode(code);
                case USA -> code.matches("\\d{3}-\\d{2}-\\d{4}");
                case GERMANY -> code.matches("\\d{11}");
                case FRANCE -> code.matches("\\d{15}");
                case INDIA -> code.matches("\\d{12}");
                default -> false;
            };
            if (!isValid) {
                throw new InvalidNationalCodeException("The nationalCode is not valid for country " + country);
            }
            return true;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.getCause();
            return false;
        }
    }

//    private boolean isValidIranCode(String code) {
//        int check = Integer.parseInt(code.substring(9));
//        int sum = 0;
//        for (int i = 0; i < 9; i++) {
//            sum += Integer.parseInt(code.substring(i, i + 1)) * (10 - i);
//        }
//        int rem = sum % 11;
//        return (rem < 2 && check == rem) || (rem >= 2 && check == 11 - rem);
//    }
}

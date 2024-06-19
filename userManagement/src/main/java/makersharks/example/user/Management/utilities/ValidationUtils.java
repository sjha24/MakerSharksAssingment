package makersharks.example.user.Management.utilities;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.springframework.stereotype.Component;


@Component
public class ValidationUtils {
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public <T> void validate(T object) {
        var violations = validator.validate(object);
        if (!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
    }

}

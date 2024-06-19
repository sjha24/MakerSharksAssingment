package makersharks.example.user.Management.dtos;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Data
public class LoginRequest {
    @NotEmpty(message = "User name should not be null or empty")
    private String userName;
    @NotEmpty(message = "Password should not be null or empty")
    private String password;
}

package makersharks.example.user.Management.dtos;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Data
public class UserDto {
    @NotEmpty(message = "User name should not be empty")
    private String name;
    @NotEmpty(message = "email should not be empty")
    private String email;
    @NotEmpty(message="password should not be empty")
    private String password;
}

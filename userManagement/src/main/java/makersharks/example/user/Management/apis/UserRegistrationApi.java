package makersharks.example.user.Management.apis;
import lombok.RequiredArgsConstructor;
import makersharks.example.user.Management.dtos.UserDto;
import makersharks.example.user.Management.service.UserService;
import makersharks.example.user.Management.utilities.ApiOutput;
import makersharks.example.user.Management.utilities.ValidationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.rmi.AlreadyBoundException;
import java.rmi.ServerException;



@Service
@RequiredArgsConstructor
public class UserRegistrationApi {
    private final UserService userService;
    private final ValidationUtils validationUtils;

    public ApiOutput<?> register(UserDto userDto) {
        try {
            validate(userDto);
            return new ApiOutput<>(HttpStatus.OK.value(), "User Registration Successful", userService.register(userDto));
        }catch (Exception e){
            return new ApiOutput<>(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
    }
    public void validate(UserDto userDto) throws ServerException, AlreadyBoundException {
        validationUtils.validate(userDto);;

//        if(userService.findByEmail(userDto.getEmail()) != null){
//            throw new AlreadyBoundException("This Email ID is Already Register");
//        }
    }
}

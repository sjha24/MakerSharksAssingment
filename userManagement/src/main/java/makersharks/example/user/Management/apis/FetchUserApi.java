package makersharks.example.user.Management.apis;
import lombok.RequiredArgsConstructor;
import makersharks.example.user.Management.service.UserService;
import makersharks.example.user.Management.utilities.ApiOutput;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class FetchUserApi {
    private final UserService userService;
    public ApiOutput<?> fetch(String name) {
        try {
            return new ApiOutput<>(HttpStatus.OK.value(), "",userService.fetch(name));
        }catch (Exception e){
            return new ApiOutput<>(HttpStatus.NO_CONTENT.value(),e.getMessage() );
        }
    }
}

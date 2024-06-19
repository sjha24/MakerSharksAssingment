package makersharks.example.user.Management.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import makersharks.example.user.Management.apis.FetchUserApi;
import makersharks.example.user.Management.apis.UserRegistrationApi;
import makersharks.example.user.Management.dtos.UserDto;
import makersharks.example.user.Management.utilities.ApiOutput;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Tag(name="User Management", description="User registration and fetch APIs")
public class UserController {

    private final UserRegistrationApi userRegistration;
    private final FetchUserApi fetchUser;

    @Operation(summary = "Users can register by providing a username, email, and password")
    @ApiResponse(responseCode = "200", description = "Registration Successfull")
    @PostMapping("/register")
    public ApiOutput<?> register(@RequestBody UserDto userDto){
        return userRegistration.register(userDto);
    }

    @Operation(summary = "User can Fetch Other user details by name")
    @ApiResponse(responseCode = "401", description = "Not Authorized !!")
    @GetMapping("/fetch")
    public ApiOutput<?> fetch(@RequestParam String name){
        return fetchUser.fetch(name);
    }
}

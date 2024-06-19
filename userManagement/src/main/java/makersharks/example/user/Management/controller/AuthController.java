package makersharks.example.user.Management.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import makersharks.example.user.Management.apis.LoginApi;
import makersharks.example.user.Management.dtos.LoginRequest;
import makersharks.example.user.Management.utilities.ApiOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.rmi.ServerException;


@RestController
@RequestMapping("/api/auth")
@Tag(name="Authentication Management", description="managing User Login")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private LoginApi loginApi;

    @Operation(summary = "View a list of available APIs")
    @ApiResponse(responseCode = "200", description = "Login Successfull")
    @ApiResponse(responseCode = "401", description = "Not Authorized !!")
    @PostMapping("/login")
    public ApiOutput<?> login(@RequestBody LoginRequest loginRequest) throws ServerException {
        return loginApi.login(loginRequest);
    }
}
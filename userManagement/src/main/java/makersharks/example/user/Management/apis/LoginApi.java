package makersharks.example.user.Management.apis;
import makersharks.example.user.Management.dtos.LoginRequest;
import makersharks.example.user.Management.service.JwtService;
import makersharks.example.user.Management.service.UserService;
import makersharks.example.user.Management.utilities.ApiOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.rmi.ServerException;


@Service
public class LoginApi {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager manager;

    public ApiOutput<?> login(LoginRequest loginRequest) throws ServerException {
        Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),loginRequest.getPassword()));
        if(authentication.isAuthenticated()) {
            String token = jwtService.generateToken(loginRequest.getUserName());
            return new ApiOutput<>(HttpStatus.OK.value(), "",token);
        }
        throw new ServerException("Invalid User Request");
    }
}

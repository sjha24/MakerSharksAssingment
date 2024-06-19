package makersharks.example.user.Management.service;
import lombok.RequiredArgsConstructor;
import makersharks.example.user.Management.dtos.UserDto;
import makersharks.example.user.Management.dtos.UserResponse;
import makersharks.example.user.Management.entities.User;
import makersharks.example.user.Management.repository.UserRepository;

import makersharks.example.user.Management.utilities.ObjectMapperUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.rmi.ServerException;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String register(UserDto userDto) throws ServerException {
        var user = ObjectMapperUtil.map(userDto, User.class);
        var password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        userRepository.save(user);
        return "User Register Successful";
    }

    public UserResponse fetch(String name) throws ServerException {
        var user = findByName(name);
        if(user != null){
            return ObjectMapperUtil.map(user,UserResponse.class);
        }
        throw new ServerException(name+" Not found");
    }

    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    public User findByEmail(String email) throws ServerException {
         return userRepository.findByEmail(email)
                .orElseThrow(()->new ServerException("User Not Found"));
    }
}

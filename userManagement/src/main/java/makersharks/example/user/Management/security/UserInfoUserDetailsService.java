package makersharks.example.user.Management.security;
import makersharks.example.user.Management.entities.User;
import makersharks.example.user.Management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.rmi.ServerException;
import java.util.Optional;


@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        Optional<User> user = userRepository.findByEmail(username);
        try {
            return user.map(UserInfoUserDetails::new)
                    .orElseThrow(()->new ServerException("User not found "+username));
        } catch (ServerException e) {
            throw new RuntimeException(e);
        }
    }
}

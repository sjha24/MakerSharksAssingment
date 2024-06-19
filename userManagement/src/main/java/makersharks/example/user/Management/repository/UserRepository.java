package makersharks.example.user.Management.repository;
import makersharks.example.user.Management.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);

    Optional<User> findByEmail(String email);
}

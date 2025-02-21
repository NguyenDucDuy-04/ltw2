package repositories;

import forminfor.com.example.forminfor.UserDemo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDemo, Integer> {
    UserDemo save(UserDemo user);
    UserDemo findUserById(int id);
    void deleteUser(int id);
    List<UserDemo> findAll();
}

package services;
import forminfor.com.example.forminfor.UserDemo;
import org.springframework.stereotype.Service;
import repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    public UserRepository repository;
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserDemo add(UserDemo user) {
        return this.repository.save(user);
    }

    public List<UserDemo> getAll() {
        return this.repository.findAll();
    }

    public UserDemo getById(int id) {
        return this.repository.findUserById(id);
    }

    public void delete(int id) {
         this.repository.deleteUser(id);
    }
}

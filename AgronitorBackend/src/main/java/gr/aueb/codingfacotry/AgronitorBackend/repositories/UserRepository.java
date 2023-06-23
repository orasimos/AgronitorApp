package gr.aueb.codingfacotry.AgronitorBackend.repositories;

import gr.aueb.codingfacotry.AgronitorBackend.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
    User insert(String username, String password, String email);
    List<User> findAll();
    long delete(String username);

}

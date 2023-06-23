package gr.aueb.codingfacotry.AgronitorBackend.services;

import gr.aueb.codingfacotry.AgronitorBackend.models.Greenhouse;
import gr.aueb.codingfacotry.AgronitorBackend.models.User;
import gr.aueb.codingfacotry.AgronitorBackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
//        Perform validations and error handling
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            throw new RuntimeException("Username is taken");
        }

        return userRepository.save(user);
    }

    public User loginUser(String username, String password) {
//        Preform validations and error handling
        User user = userRepository.findByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid username or password");
        }

        return user;
    }

    public User getUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return null;
    }

    public Greenhouse createGreenhouse(String username, String greenhouseName) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            Greenhouse greenhouse = new Greenhouse();
            greenhouse.setGreenhouseName(greenhouseName);

            user.getGreenhouseList().add(greenhouse);
            userRepository.save(user);
            return greenhouse;
        }
        return null;
    }

    public Greenhouse updateGreenhouse(String username, String oldName, String newName) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            for (Greenhouse greenhouse : user.getGreenhouseList()) {
                if (greenhouse.getGreenhouseName().equals(oldName)) {
                    greenhouse.setGreenhouseName(newName);

                    userRepository.save(user);
                    return greenhouse;
                }
            }
        }
        return null;
    }

    public boolean deleteGreenhouse(String username, String greenhouseName) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            List<Greenhouse> greenhouseList = user.getGreenhouseList();
            for (int i = 0; i < greenhouseList.size(); i++) {
                if (greenhouseList.get(i).getGreenhouseName().equals(greenhouseName)) {
                    greenhouseList.remove(i);
                    userRepository.save(user);
                    return true;
                }
            }
        }
        return false;
    }

    public Greenhouse getGreenhouse(String username, String greenhouseName) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            for (Greenhouse greenhouse : user.getGreenhouseList()) {
                if (greenhouse.getGreenhouseName().equals(greenhouseName)) {
                    return greenhouse;
                }
            }
        }
        return null;
    }
}

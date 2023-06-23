package gr.aueb.codingfacotry.AgronitorBackend.controllers;

import gr.aueb.codingfacotry.AgronitorBackend.models.Greenhouse;
import gr.aueb.codingfacotry.AgronitorBackend.models.User;
import gr.aueb.codingfacotry.AgronitorBackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestParam String username,
                             @RequestParam String password,
                             @RequestParam String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public User loginUser(@RequestParam String username, @RequestParam String password) {
        return userService.loginUser(username, password);
    }

    @GetMapping("/users")
    public User getUser(@RequestParam String username) {
        return userService.getUser(username);
    }

    @PostMapping("/{username}/greenhouses")
    public Greenhouse creatGreenhouse(@PathVariable String username, @RequestParam String greenhouseName) {
        return userService.createGreenhouse(username, greenhouseName);
    }

    @GetMapping("/{username}/greenhouses/{greenhouseName}")
    public Greenhouse getGreenhouse(@PathVariable String username, @PathVariable String greenhouseName) {
        return userService.getGreenhouse(username, greenhouseName);
    }

    @PutMapping("/{username}/greenhouses/{oldName}")
    public Greenhouse updateGreenhouse(@PathVariable String username,
                                       @PathVariable String oldName, @RequestParam String newName) {
        return userService.updateGreenhouse(username, oldName, newName);
    }

    @DeleteMapping("/{username}/greenhouses/{greenhouseName}")
    public boolean deleteGreenhouse(@PathVariable String username, @PathVariable String greenhouseName) {
        return userService.deleteGreenhouse(username, greenhouseName);
    }
}

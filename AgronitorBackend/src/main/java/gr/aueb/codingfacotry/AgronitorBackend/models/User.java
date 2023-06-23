package gr.aueb.codingfacotry.AgronitorBackend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String email;
    private List<Greenhouse> greenhouseList;

    public User() {}

    public User(String id, String username, String password, String email, List<Greenhouse> greenhouseList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.greenhouseList = greenhouseList;
    }

    //    Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<Greenhouse> getGreenhouseList() {
        return greenhouseList;
    }
    public void setGreenhouseList(List<Greenhouse> greenhouseList) {
        this.greenhouseList = greenhouseList;
    }
}

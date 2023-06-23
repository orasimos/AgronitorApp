package gr.aueb.cf.agronitor.models;

import org.json.JSONObject;

import java.util.ArrayList;

public class User extends JSONObject {
    private Long id;
    private String username;
    private String email;
    private String password;
    private ArrayList<Greenhouse> greenhouseArrayList;

//    Constructor
    public User(String username, String email, String password) {

        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

//    Getters and Setters
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public ArrayList<Greenhouse> getGreenhouseArrayList() {
        return greenhouseArrayList;
    }
    public void setGreenhouseArrayList(ArrayList<Greenhouse> greenhouseArrayList) {
        this.greenhouseArrayList = greenhouseArrayList;
    }


}

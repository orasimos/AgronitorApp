package gr.aueb.cf.agronitor.models;

import org.json.JSONObject;

import java.util.ArrayList;

public class Greenhouse {

    private Long id;
    private String greenhouseName;
    private Long userId;

    public Greenhouse(String greenhouseName) {
        this.greenhouseName = greenhouseName;
    }

//    Constructor
    public Greenhouse(String greenhouseName, Long userId) {
        this.greenhouseName = greenhouseName;
        this.userId = userId;
    }

//    Getters and Setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getGreenhouseName() {
        return greenhouseName;
    }
    public void setGreenhouseName(String greenhouseName) {
        this.greenhouseName = greenhouseName;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

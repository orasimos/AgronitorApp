package gr.aueb.cf.agronitor.apiclient.greenhouses;

public class GreenhouseResponse {
    private String id;
    private String greenhouseName;
    private String userId;

    public GreenhouseResponse(String id, String greenhouseName, String userId) {
        this.id = id;
        this.greenhouseName = greenhouseName;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGreenhouseName() {
        return greenhouseName;
    }

    public void setGreenhouseName(String greenhouseName) {
        this.greenhouseName = greenhouseName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

package gr.aueb.cf.agronitor.apiclient.greenhouses;

public class AddGreenhouseResponse {
    private String id;
    private String greenhouseName;
    private String userId;

    public AddGreenhouseResponse(String id, String greenhouseName, String userId) {
        this.id = id;
        this.greenhouseName = greenhouseName;
        this.userId = userId;
    }
}

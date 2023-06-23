package gr.aueb.cf.agronitor.models;

import java.util.Date;

public class Temperature {
    private Long id;
    private Date timestamp;
    private String value;
    private Long greenhouseId;

    public Temperature(Long id, Date timestamp, String value, Long greenhouseId) {
        this.id = id;
        this.timestamp = timestamp;
        this.value = value;
        this.greenhouseId = greenhouseId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getGreenhouseId() {
        return greenhouseId;
    }

    public void setGreenhouseId(Long greenhouseId) {
        this.greenhouseId = greenhouseId;
    }
}

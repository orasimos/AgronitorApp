package gr.aueb.codingfacotry.AgronitorBackend.models;

import java.util.Date;

public class Humidity {
    private Date timestamp;
    private String value;

    public Humidity() {
    }

    public Humidity(Date timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    //    Getters and Setters
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
}

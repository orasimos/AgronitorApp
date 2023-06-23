package gr.aueb.codingfacotry.AgronitorBackend.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Temperature {
    private Date timestamp;
    private String value;

    public Temperature() {}

    public Temperature(Date timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
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
}

package gr.aueb.cf.agronitor.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "humidities")
public class Humidity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "timestamp")
    private Date timestamp;

    @Column(name = "value")
    private String value;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_greenhouse", referencedColumnName = "id")
    private Greenhouse greenhouse;

    public Humidity(Date timestamp, String value, Long greenhouseId) {
        this.timestamp = timestamp;
        this.value = value;
        this.greenhouse = new Greenhouse();
        this.greenhouse.setId(greenhouseId);
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
    public Greenhouse getGreenhouse() {
        return greenhouse;
    }
    public void setGreenhouse(Greenhouse greenhouse) {
        this.greenhouse = greenhouse;
    }
}
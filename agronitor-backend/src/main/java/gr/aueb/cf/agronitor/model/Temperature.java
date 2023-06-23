package gr.aueb.cf.agronitor.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "temperatures")
public class Temperature {

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

    public Temperature(Long id, Date timestamp, String value, Greenhouse greenhouse) {
        this.id = id;
        this.timestamp = timestamp;
        this.value = value;
        this.greenhouse = greenhouse;
    }

    public Temperature(Date timestamp, String value, Greenhouse greenhouse) {
        this.timestamp = timestamp;
        this.value = value;
        this.greenhouse = greenhouse;
    }
}

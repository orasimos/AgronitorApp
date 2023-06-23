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

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_greenhouse", referencedColumnName = "id")
    private Greenhouse greenhouse;

}
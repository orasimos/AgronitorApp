package gr.aueb.cf.agronitor.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "soil_hydrations")
public class SoilHydration {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "timestamp")
    private Date timestamp;

    @Column(name = "value")
    private String value;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_greenhouse", referencedColumnName = "id")
    private Greenhouse greenhouse;
}
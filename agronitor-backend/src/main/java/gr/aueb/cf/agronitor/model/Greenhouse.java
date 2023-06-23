package gr.aueb.cf.agronitor.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Table(name = "greenhouses")
public class Greenhouse {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "greenhouse_name", length = 50, nullable = false)
    private String greenhouseName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "id")
    private List<Temperature> temperatureList;

//    Overloaded constructors
    public Greenhouse(Long id, String greenhouseName, User user) {
        this.id = id;
        this.greenhouseName = greenhouseName;
        this.user = user;
    }

    public Greenhouse(Long id, String greenhouseName) {
        this.id = id;
        this.greenhouseName = greenhouseName;
    }

    public Greenhouse(String greenhouseName, Long userId) {
        this.greenhouseName = greenhouseName;
        this.user = new User();
        this.user.setId(userId);
    }

    public Greenhouse(String greenhouseName, User user) {
        this.greenhouseName = greenhouseName;
        this.user = user;
        user.getGreenhouseList().add(this);
    }

//    Convenient Method
    public void addTemperature(Temperature temperature) {
        this.temperatureList.add(temperature);
        temperature.setGreenhouse(this);
    }
}

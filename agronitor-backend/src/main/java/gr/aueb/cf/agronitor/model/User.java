package gr.aueb.cf.agronitor.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true, length = 50, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Greenhouse> greenhouseList = new ArrayList<>();

//   Overloaded Constructors
    public User(Long id, String username, String email, String password/*, List<Greenhouse> greenhouseList*/) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
//        this.greenhouseList = greenhouseList;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

//    Convenient Method
    public void addGreenhouse(Greenhouse greenhouse) {
        this.greenhouseList.add(greenhouse);
        greenhouse.setUser(this);
    }
}

package gr.aueb.cf.agronitor.dto;

import gr.aueb.cf.agronitor.model.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.List;


@Data
@NoArgsConstructor
public class GreenhouseDTO {

    private Long id;

    @Size(min = 1, message = "Greenhouse name must have at least ${min} character")
    private String greenhouseName;
    private User user;
    private Long userId;

    public GreenhouseDTO(String greenhouseName, Long userId) {
        this.greenhouseName = greenhouseName;
        this.userId = userId;
    }

    public GreenhouseDTO(Long id, String greenhouseName, Long userId) {
        this.id = id;
        this.greenhouseName = greenhouseName;
        this.userId = userId;
    }
}

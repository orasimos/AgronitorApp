package gr.aueb.cf.agronitor.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoggedInUserDTO {
    private Long id;
    private String username;

    public LoggedInUserDTO(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}

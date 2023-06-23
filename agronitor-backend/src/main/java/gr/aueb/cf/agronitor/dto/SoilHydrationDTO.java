package gr.aueb.cf.agronitor.dto;

import gr.aueb.cf.agronitor.model.Greenhouse;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class SoilHydrationDTO {

    private Long id;
    private Date timestamp;
    private String value;
    private Greenhouse greenhouse;

    public SoilHydrationDTO(Long id, Date timestamp, String value, Greenhouse greenhouse) {
        this.id = id;
        this.timestamp = timestamp;
        this.value = value;
        this.greenhouse = greenhouse;
    }
}

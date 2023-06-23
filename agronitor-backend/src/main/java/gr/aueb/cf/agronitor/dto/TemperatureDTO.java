package gr.aueb.cf.agronitor.dto;

import gr.aueb.cf.agronitor.model.Greenhouse;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class TemperatureDTO {

    private Long id;
    private Date timestamp;
    private String value;
    private Long greenhouseId;
    private Greenhouse greenhouse;

    public TemperatureDTO(Long id, Date timestamp, String value, Greenhouse greenhouse) {
        this.id = id;
        this.timestamp = timestamp;
        this.value = value;
        this.greenhouse = greenhouse;
    }

    public TemperatureDTO(Long id, Date timestamp, String value, Long greenhouseId) {
        this.id = id;
        this.timestamp = timestamp;
        this.value = value;
        this.greenhouseId = greenhouseId;
    }
}

package gr.aueb.cf.agronitor.dto;

public class MeasurementsDTO {
    private String currentTemp;
    private String currentHum;
    private String currentHydr;
    private String currentUV;
    private String minTemp;
    private String maxTemp;
    private String minHum;
    private String maxHum;
    private String minHydr;
    private String maxHydr;
    private String minUV;
    private String maxUV;
    private String greenhouseId;

    public MeasurementsDTO(String currentTemp, String currentHum, String currentHydr, String currentUV, String minTemp,
                           String maxTemp, String minHum, String maxHum, String minHydr, String maxHydr, String minUV,
                           String maxUV, String greenhouseId) {
        this.currentTemp = currentTemp;
        this.currentHum = currentHum;
        this.currentHydr = currentHydr;
        this.currentUV = currentUV;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.minHum = minHum;
        this.maxHum = maxHum;
        this.minHydr = minHydr;
        this.maxHydr = maxHydr;
        this.minUV = minUV;
        this.maxUV = maxUV;
        this.greenhouseId = greenhouseId;
    }

    public String getGreenhouseId() {
        return greenhouseId;
    }
    public void setGreenhouseId(String greenhouseId) {
        this.greenhouseId = greenhouseId;
    }
}

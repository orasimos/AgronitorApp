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

    public String getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(String currentTemp) {
        this.currentTemp = currentTemp;
    }

    public String getCurrentHum() {
        return currentHum;
    }

    public void setCurrentHum(String currentHum) {
        this.currentHum = currentHum;
    }

    public String getCurrentHydr() {
        return currentHydr;
    }

    public void setCurrentHydr(String currentHydr) {
        this.currentHydr = currentHydr;
    }

    public String getCurrentUV() {
        return currentUV;
    }

    public void setCurrentUV(String currentUV) {
        this.currentUV = currentUV;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getMinHum() {
        return minHum;
    }

    public void setMinHum(String minHum) {
        this.minHum = minHum;
    }

    public String getMaxHum() {
        return maxHum;
    }

    public void setMaxHum(String maxHum) {
        this.maxHum = maxHum;
    }

    public String getMinHydr() {
        return minHydr;
    }

    public void setMinHydr(String minHydr) {
        this.minHydr = minHydr;
    }

    public String getMaxHydr() {
        return maxHydr;
    }

    public void setMaxHydr(String maxHydr) {
        this.maxHydr = maxHydr;
    }

    public String getMinUV() {
        return minUV;
    }

    public void setMinUV(String minUV) {
        this.minUV = minUV;
    }

    public String getMaxUV() {
        return maxUV;
    }

    public void setMaxUV(String maxUV) {
        this.maxUV = maxUV;
    }

    public String getGreenhouseId() {
        return greenhouseId;
    }

    public void setGreenhouseId(String greenhouseId) {
        this.greenhouseId = greenhouseId;
    }
}

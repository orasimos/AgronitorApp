package gr.aueb.codingfacotry.AgronitorBackend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "greenhouses")
public class Greenhouse {
    private String greenhouseName;
    private List<Temperature> temperatures;
    private List<Humidity> humidities;
    private List<SoilHydration> soil_hydration;
    private List<UVRadiation> uv_radiation;

    public Greenhouse() {}

    public Greenhouse(String greenhouseName, List<Temperature> temperatures, List<Humidity> humidities, List<SoilHydration> soil_hydration, List<UVRadiation> uv_radiation) {
        this.greenhouseName = greenhouseName;
        this.temperatures = temperatures;
        this.humidities = humidities;
        this.soil_hydration = soil_hydration;
        this.uv_radiation = uv_radiation;
    }

    //    Getters and Setters
    public String getGreenhouseName() {
        return greenhouseName;
    }
    public void setGreenhouseName(String greenhouseName) {
        this.greenhouseName = greenhouseName;
    }
    public List<Temperature> getTemperatures() {
        return temperatures;
    }
    public void setTemperatures(List<Temperature> temperatures) {
        this.temperatures = temperatures;
    }
    public List<Humidity> getHumidities() {
        return humidities;
    }
    public void setHumidities(List<Humidity> humidities) {
        this.humidities = humidities;
    }
    public List<SoilHydration> getSoil_hydration() {
        return soil_hydration;
    }
    public void setSoil_hydration(List<SoilHydration> soil_hydration) {
        this.soil_hydration = soil_hydration;
    }
    public List<UVRadiation> getUv_radiation() {
        return uv_radiation;
    }
    public void setUv_radiation(List<UVRadiation> uv_radiation) {
        this.uv_radiation = uv_radiation;
    }
}

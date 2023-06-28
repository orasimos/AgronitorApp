package gr.aueb.cf.agronitor.updater;

import gr.aueb.cf.agronitor.model.*;
import gr.aueb.cf.agronitor.repository.*;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MeasurementsUpdater {

//    private ScheduledExecutorService scheduler;
    private final GreenhouseRepository greenhouseRepository;
    private final TemperatureRepository temperatureRepository;
    private final HumidityRepository humidityRepository;
    private final SoilHydrationRepository soilHydrationRepository;
    private final UVRadiationRepository uvRadiationRepository;

    public MeasurementsUpdater(GreenhouseRepository greenhouseRepository,
                               TemperatureRepository temperatureRepository,
                               HumidityRepository humidityRepository,
                               SoilHydrationRepository soilHydrationRepository,
                               UVRadiationRepository uvRadiationRepository) {
        this.greenhouseRepository = greenhouseRepository;
        this.temperatureRepository = temperatureRepository;
        this.humidityRepository = humidityRepository;
        this.soilHydrationRepository = soilHydrationRepository;
        this.uvRadiationRepository = uvRadiationRepository;
//        scheduler = Executors.newSingleThreadScheduledExecutor();
    }

//    public void startUpdatingMeasurements() {
//    }
//
//    public void stopUpdatingMeasurements() {
//        scheduler.shutdown();
//    }

    public void updateGreenhouseMeasurements() {
        List<Greenhouse> greenhouseList = greenhouseRepository.findAll();

        for (Greenhouse greenhouse : greenhouseList) {
            String tempValue = generateTemperatureValue();
            String humValue = generateHumidityValue();
            String hydrValue = generateSoilHydrationValue();
            String uvValue = generateUVRadiationValue();
            Date timeStamp = new Date();

            Temperature temperature = new Temperature();
            temperature.setValue(tempValue);
            temperature.setTimestamp(timeStamp);
            temperature.setGreenhouse(greenhouse);
            temperatureRepository.save(temperature);

            Humidity humidity = new Humidity();
            humidity.setValue(humValue);
            humidity.setTimestamp(timeStamp);
            humidity.setGreenhouse(greenhouse);
            humidityRepository.save(humidity);

            SoilHydration soilHydration = new SoilHydration();
            soilHydration.setValue(hydrValue);
            soilHydration.setTimestamp(timeStamp);
            soilHydration.setGreenhouse(greenhouse);
            soilHydrationRepository.save(soilHydration);

            UVRadiation uvRadiation = new UVRadiation();
            uvRadiation.setValue(uvValue);
            uvRadiation.setTimestamp(timeStamp);
            uvRadiation.setGreenhouse(greenhouse);
            uvRadiationRepository.save(uvRadiation);
        }
    }

    private String generateTemperatureValue() {
        double min = 20.0;
        double max = 40.0;
        double randomValue = min + Math.random() * (max - min);
        return String.valueOf(randomValue);
    }

    private String generateHumidityValue() {
        double min = 0.0;
        double max = 100.0;
        double randomValue = min + Math.random() * (max - min);
        return String.valueOf(randomValue);
    }

    private String generateSoilHydrationValue() {
        double min = 0.0;
        double max = 100.0;
        double randomValue = min + Math.random() * (max - min);
        return String.valueOf(randomValue);
    }

    private String generateUVRadiationValue() {
        double min = 0.0;
        double max = 100.0;
        double randomValue = min + Math.random() * (max - min);
        return String.valueOf(randomValue);
    }
}

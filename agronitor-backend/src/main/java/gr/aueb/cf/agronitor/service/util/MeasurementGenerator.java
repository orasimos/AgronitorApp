package gr.aueb.cf.agronitor.service.util;

import java.util.Random;

public class MeasurementGenerator {

    private static final double TEMPERATURE_MIN = 20.0;
    private static final double TEMPERATURE_MAX = 30.0;
    private static final double HUMIDITY_MIN = 40.0;
    private static final double HUMIDITY_MAX = 60.0;
    private static final double SOIL_HYDRATION_MIN = 0.2;
    private static final double SOIL_HYDRATION_MAX = 0.8;
    private static final double UV_RADIATION_MIN = 0.0;
    private static final double UV_RADIATION_MAX = 10.0;

    public static String generateRandomTemperature() {
        Random random = new Random();
        double temperature = TEMPERATURE_MIN + (TEMPERATURE_MAX - TEMPERATURE_MIN) * random.nextDouble();
        return String.format("%.2f", temperature);
    }

    public static String generateRandomHumidity() {
        Random random = new Random();
        double humidity = HUMIDITY_MIN + (HUMIDITY_MAX - HUMIDITY_MIN) * random.nextDouble();
        return String.format("%.2f", humidity);
    }

    public static String generateRandomSoilHydration() {
        Random random = new Random();
        double soilHydration = SOIL_HYDRATION_MIN + (SOIL_HYDRATION_MAX - SOIL_HYDRATION_MIN) * random.nextDouble();
        return String.format("%.2f", soilHydration);
    }

    public static String generateRandomUVRadiation() {
        Random random = new Random();
        double uvRadiation = UV_RADIATION_MIN + (UV_RADIATION_MAX - UV_RADIATION_MIN) * random.nextDouble();
        return String.format("%.2f", uvRadiation);
    }
}

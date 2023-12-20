package org.example.sensors.soil_sensor;

import java.util.Locale;

public class SensorJsonFactory {

    public static String createSoilDataJson(String sensorType, String sensorId, String sensorLocation,
                                            String timestamp, double soilHumidityValue,
                                            double nitrogenValue, double phosphorusValue, double potassiumValue) {
        return String.format(Locale.ROOT,
                "{\"sensorType\": \"%s\", \"sensorId\": \"%s\", \"sensorLocation\": \"%s\", " +
                        "\"timestamp\": \"%s\", \"soilHumidityValue\": %.1f, " +
                        "\"nitrogenValue\": %.2f, \"phosphorusValue\": %.2f, \"potassiumValue\": %.2f}",
                sensorType, sensorId, sensorLocation, timestamp, soilHumidityValue,
                nitrogenValue, phosphorusValue, potassiumValue);
    }
}

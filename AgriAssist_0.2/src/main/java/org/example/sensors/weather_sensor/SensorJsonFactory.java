package org.example.sensors.weather_sensor;

import java.util.Locale;

public class SensorJsonFactory {

    public static String createWeatherDataJson(String sensorType, String sensorId, String sensorLocation,
                                               String timestamp, double humidityValue, double temperatureValue,
                                               double windSpeedValue, String windDirection, int uvIndex) {
        return String.format(Locale.ROOT, // Ensure consistent use of the dot as the decimal separator
                "{\"sensorType\": \"%s\", \"sensorId\": \"%s\", \"sensorLocation\": \"%s\", " +
                        "\"timestamp\": \"%s\", \"humidityValue\": %.1f, \"temperatureValue\": %.1f, " +
                        "\"windSpeedValue\": %.1f, \"windDirection\": \"%s\", \"uvIndex\": %d}",
                sensorType, sensorId, sensorLocation, timestamp, humidityValue,
                temperatureValue, windSpeedValue, windDirection, uvIndex);
    }
}
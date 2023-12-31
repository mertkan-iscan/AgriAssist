package org.example.sensors.sensor1;

public class SensorJsonFactory {

    static String createWeatherDataJson(double temperature, double humidity) {
        // Simple JSON creation
        return String.format("{\"temperature\": %.1f, \"humidity\": %.1f}", temperature, humidity);
    }
}

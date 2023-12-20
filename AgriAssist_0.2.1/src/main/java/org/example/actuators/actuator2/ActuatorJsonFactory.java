package org.example.actuators.actuator2;

public class ActuatorJsonFactory {

    static String createWeatherDataJson(double temperature, double humidity) {
        // Simple JSON creation
        return String.format("{\"temperature\": %.1f, \"humidity\": %.1f}", temperature, humidity);
    }
}

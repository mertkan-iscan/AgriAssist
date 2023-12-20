package org.example.actuators.actuator1;

public class ActuatorJsonFactory {

    static String createWeatherDataJson(double temperature, double humidity) {
        // Simple JSON creation
        return String.format("{\"temperature\": %.1f, \"humidity\": %.1f}", temperature, humidity);
    }
}

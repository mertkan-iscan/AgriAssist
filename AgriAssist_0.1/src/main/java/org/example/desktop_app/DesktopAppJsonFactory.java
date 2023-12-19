package org.example.desktop_app;

public class DesktopAppJsonFactory {

    static String createWeatherDataJson(double temperature, double humidity) {
        // Simple JSON creation
        return String.format("{\"temperature\": %.1f, \"humidity\": %.1f}", temperature, humidity);
    }
}

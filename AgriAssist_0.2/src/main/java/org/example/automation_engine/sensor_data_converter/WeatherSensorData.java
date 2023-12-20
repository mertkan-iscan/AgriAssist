package org.example.automation_engine.sensor_data_converter;

public class WeatherSensorData extends SensorData {
    private double humidityValue;
    private double temperatureValue;
    private double windSpeedValue;
    private String windDirection;
    private int uvIndex;

    // Constructor
    public WeatherSensorData() {
        super();
    }

    // Getters and Setters specific to WeatherSensorData

    public double getHumidityValue() {
        return humidityValue;
    }

    public double getTemperatureValue() {
        return temperatureValue;
    }

    public double getWindSpeedValue() {
        return windSpeedValue;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public int getUvIndex() {
        return uvIndex;
    }

    // ...
}

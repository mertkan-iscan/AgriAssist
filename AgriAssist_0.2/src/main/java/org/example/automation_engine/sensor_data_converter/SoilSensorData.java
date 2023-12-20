package org.example.automation_engine.sensor_data_converter;

public class SoilSensorData extends SensorData {
    private double soilHumidityValue;
    private double nitrogenValue;
    private double phosphorusValue;
    private double potassiumValue;

    // Add more minerals as needed

    // Constructor
    public SoilSensorData() {
        super();
    }

    // Getters and Setters specific to SoilSensorData

    public double getSoilHumidityValue() {
        return soilHumidityValue;
    }

    public double getNitrogenValue() {
        return nitrogenValue;
    }

    public double getPhosphorusValue() {
        return phosphorusValue;
    }

    public double getPotassiumValue() {
        return potassiumValue;
    }

    // ...
}

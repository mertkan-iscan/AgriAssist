package org.example.automation_engine.sensor_data_converter;

public abstract class SensorData {
    protected String sensorType;
    protected String sensorId;
    protected String sensorLocation;
    protected String timestamp;

    // Constructor
    public SensorData() {}

    // Getters and setters for the shared fields

    public String getSensorType() {
        return sensorType;
    }

    public String getSensorId() {
        return sensorId;
    }

    public String getSensorLocation() {
        return sensorLocation;
    }

    public String getTimestamp() {
        return timestamp;
    }

    // ...
}

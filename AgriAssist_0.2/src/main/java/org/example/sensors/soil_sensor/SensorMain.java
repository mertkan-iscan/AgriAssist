package org.example.sensors.soil_sensor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SensorMain {

    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        SensorTcpSender sensorClient = new SensorTcpSender("localhost", 12345); // Replace "localhost" with the server's IP address



        Runnable sendTask = () -> {

            // Simulate weather sensor data generation


            String weatherData = SensorJsonFactory.createSoilDataJson(
                    "Soil Sensor", "SoilSensor123", "Greenhouse 1", "2023-12-15T10:00:00Z",
                    32.5, 10.0, 5.0, 15.0
            );

            // Send the weather data
            sensorClient.sendWeatherData(weatherData);
        };

        // Schedule the task to run every 10 sec
        executor.scheduleAtFixedRate(sendTask, 0, 10, TimeUnit.SECONDS);
    }
}

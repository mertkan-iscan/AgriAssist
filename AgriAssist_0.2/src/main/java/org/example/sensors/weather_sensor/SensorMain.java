package org.example.sensors.weather_sensor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SensorMain {

    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        SensorTcpSender sensorClient = new SensorTcpSender("field1", "localhost", 12345); // Replace "localhost" with the server's IP address



        Runnable sendTask = () -> {

            // Simulate weather sensor data generation


            String weatherData = SensorJsonFactory.createWeatherDataJson(
                    "Weather Sensor", "WeatherSensor456", "field1",
                    "2023-12-15T14:00:00Z", 60.0, 24.0, 15.0, "NE", 5);

            // Send the weather data
            sensorClient.sendWeatherData(weatherData);
        };

        // Schedule the task to run every 10 sec
        executor.scheduleAtFixedRate(sendTask, 0, 10, TimeUnit.SECONDS);
    }
}

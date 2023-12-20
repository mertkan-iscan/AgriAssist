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



            //arbitrary data just for testing purposes
            double temperature = 30.2;
            double humidity = 60;


            String weatherData = SensorJsonFactory.createWeatherDataJson(temperature, humidity);

            // Send the weather data
            sensorClient.sendWeatherData(weatherData);
        };

        // Schedule the task to run every 10 sec
        executor.scheduleAtFixedRate(sendTask, 0, 10, TimeUnit.SECONDS);
    }
}

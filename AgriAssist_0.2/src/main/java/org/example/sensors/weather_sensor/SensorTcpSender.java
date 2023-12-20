package org.example.sensors.weather_sensor;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


public class SensorTcpSender {
    private final String sensorLocation;
    private final String serverAddress;
    private final int serverPort;

    public SensorTcpSender(String sensorLocation, String serverAddress, int serverPort) {
        this.sensorLocation = sensorLocation;
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    public void sendWeatherData(String data) {
        try (Socket socket = new Socket(serverAddress, serverPort);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            out.println(data);
            System.out.println("Weather data sent: " + data);

        } catch (IOException e) {
            System.out.println("Error while connecting to server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

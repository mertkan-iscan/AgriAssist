package org.example.sensors.sensor2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


public class SensorTcpSender {
    private final String serverAddress;
    private final int serverPort;

    public SensorTcpSender(String serverAddress, int serverPort) {
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

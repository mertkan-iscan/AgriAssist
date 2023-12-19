package org.example.actuators.actuator1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ActuatorClient {
    private final String serverAddress;
    private final int serverPort;
    private final String actuatorId; // Actuator ID

    public ActuatorClient(String serverAddress, int serverPort, String actuatorId) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        this.actuatorId = actuatorId;
    }

    public void listenForCommands() {
        try (Socket socket = new Socket(serverAddress, serverPort);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            // Send the actuator ID to the server
            out.println(actuatorId);
            System.out.println("Actuator ID sent: " + actuatorId);

            // Keep listening for messages
            while (true) {
                String command = in.readLine();
                if (command != null) {
                    System.out.println("Received command: " + command);
                    // Process the command here
                }
            }

        } catch (IOException e) {
            System.out.println("Error connecting to AE server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

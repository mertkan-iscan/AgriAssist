package org.example.automation_engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class AEServer {
    private final int sensorPort = 12345;     // Port for sensor data
    private final int commandPort = 54321;    // Port for commands from Desktop App
    private final int actuatorPort = 32154;

    private final ExecutorService clientHandlerPool = Executors.newCachedThreadPool();
    private final ConcurrentHashMap<String, Socket> actuatorConnections = new ConcurrentHashMap<>();

    public void startServer() {
        // Start sensor data receiver thread
        new Thread(() -> startSensorDataReceiver(sensorPort)).start();

        // Start app command receiver thread
        new Thread(() -> startAppCommandReceiver(commandPort)).start();

        // Start Actuator thread
        new Thread(() -> startActuatorConnection(actuatorPort)).start();
    }

    private void startSensorDataReceiver(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Automation Engine is listening port " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    System.out.println("Sensor connected: " + clientSocket.getInetAddress());

                    // Read data sent by the client
                    String data = in.readLine();
                    System.out.println("Received data: " + data);
                    //Start Logical operations

                } catch (IOException e) {
                    System.out.println("Exception caught when trying to listen on port " + port + " or listening for a connection");
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Could not listen on port " + port);
            System.out.println(e.getMessage());
        }
    }

    private void startAppCommandReceiver(int port) {
        // Logic to handle commands from Desktop App
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Automation Engine is listening port " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    System.out.println("Desktop connected: " + clientSocket.getInetAddress());

                    // Read data sent by the client
                    String data = in.readLine();
                    System.out.println("Received data: " + data);
                    //Start Logical operations

                } catch (IOException e) {
                    System.out.println("Exception caught when trying to listen on port " + port + " or listening for a connection");
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Could not listen on port " + port);
            System.out.println(e.getMessage());
        }
    }

    private void startActuatorConnection(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Actuator connection listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                clientHandlerPool.submit(() -> handleActuatorClient(clientSocket));
            }
        } catch (IOException e) {
            System.out.println("Could not listen on port " + port);
            e.printStackTrace();
        }
    }

    private void handleActuatorClient(Socket clientSocket) {
        String actuatorId = null;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            actuatorId = in.readLine();
            if (actuatorId != null) {
                actuatorConnections.put(actuatorId, clientSocket);
                System.out.println("Actuator registered with ID: " + actuatorId);

                // Keep the connection open for further communication
                while (!clientSocket.isClosed()) {
                    // Implement logic to keep the connection alive, process incoming messages, etc.
                }
            }
        } catch (IOException e) {
            System.out.println("Error handling actuator connection: " + e.getMessage());
        } finally {
            actuatorConnections.remove(actuatorId); // Clean up the map entry if the connection is closed
            System.out.println("Actuator connection closed for ID: " + actuatorId);
        }
    }

    public void sendMessageToActuator(String actuatorId, String message) {
        Socket actuatorSocket = actuatorConnections.get(actuatorId);
        if (actuatorSocket != null && !actuatorSocket.isClosed()) {
            try {
                PrintWriter out = new PrintWriter(actuatorSocket.getOutputStream(), true);
                out.println(message);
                System.out.println("Message sent to actuator ID " + actuatorId + ": " + message);
            } catch (IOException e) {
                System.out.println("Error sending message to actuator ID " + actuatorId + ": " + e.getMessage());
            }
        } else {
            System.out.println("No connected actuator found with ID: " + actuatorId + " or socket is closed.");
        }
    }
}

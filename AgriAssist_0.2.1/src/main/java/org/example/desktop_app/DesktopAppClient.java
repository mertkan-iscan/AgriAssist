package org.example.desktop_app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class DesktopAppClient {
    private final String serverAddress;
    private final int serverPort;

    private volatile boolean keepRunning = true; // Flag to control the running of the client

    public DesktopAppClient(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    public void start() {
        try (Socket socket = new Socket(serverAddress, serverPort);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Connected to AE server.");

            // Thread to listen for messages from the server
            Thread listenerThread = new Thread(() -> {
                try {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("Server: " + inputLine);
                    }
                } catch (Exception e) {
                    System.out.println("Error reading from server: " + e.getMessage());
                }
                keepRunning = false; // Stop the client when the server disconnects
            });
            listenerThread.start();

            // User input handling in a separate thread
            new Thread(() -> {
                try (Scanner scanner = new Scanner(System.in)) {
                    while (keepRunning) {
                        System.out.print("You: ");
                        String userInput = scanner.nextLine();
                        if ("exit".equalsIgnoreCase(userInput)) {
                            break;
                        }
                        out.println(userInput);
                    }
                }
                keepRunning = false; // Stop the client on user request
            }).start();

            // Keep the main thread running until the listener thread stops
            try {
                listenerThread.join();
            } catch (InterruptedException e) {
                System.out.println("Client was interrupted: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Error connecting to AE server: " + e.getMessage());
        }
    }
}

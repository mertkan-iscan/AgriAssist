package org.example.desktop_app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class DesktopAppClient {
    private final String serverAddress;
    private final int serverPort;

    public DesktopAppClient(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    public void start() {
        try (Socket socket = new Socket(serverAddress, serverPort);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to AE server. Enter 'exit' to quit.");

            // Start a thread to listen for messages from the server
            Thread listenerThread = new Thread(() -> {
                try {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("Server: " + inputLine);
                    }
                } catch (Exception e) {
                    System.out.println("Error reading from server: " + e.getMessage());
                }
            });
            listenerThread.start();

            // Send data to the server
            while (true) {
                System.out.print("You: ");
                String userInput = scanner.nextLine();
                if ("exit".equalsIgnoreCase(userInput)) {
                    break;
                }
                out.println(userInput);
            }
        } catch (Exception e) {
            System.out.println("Error connecting to AE server: " + e.getMessage());
        }
    }
}

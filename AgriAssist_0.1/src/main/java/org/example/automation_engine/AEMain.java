package org.example.automation_engine;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class AEMain {

    public static void main(String[] args) {
        AEServer aeServer = new AEServer();
        aeServer.startServer();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("Enter actuator ID and message (Format: ID message): ");
                String[] input = reader.readLine().split(" ", 2);
                if (input.length == 2) {
                    String actuatorId = input[0];
                    String message = input[1];
                    aeServer.sendMessageToActuator(actuatorId, message);
                } else {
                    System.out.println("Invalid input format.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading from console: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

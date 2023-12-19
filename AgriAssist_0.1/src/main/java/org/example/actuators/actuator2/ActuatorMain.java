package org.example.actuators.actuator2;


public class ActuatorMain {

    public static void main(String[] args) {
        ActuatorClient client = new ActuatorClient("localhost",32154,"2"); // AE server IP and port
        client.listenForCommands();
    }
}

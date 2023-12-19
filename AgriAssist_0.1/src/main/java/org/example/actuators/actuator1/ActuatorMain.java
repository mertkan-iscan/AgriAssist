package org.example.actuators.actuator1;


public class ActuatorMain {

    public static void main(String[] args) {
        ActuatorClient client = new ActuatorClient("localhost",32154,"1"); // AE server IP and port
        client.listenForCommands();
    }
}

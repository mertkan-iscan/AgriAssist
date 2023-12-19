package org.example.desktop_app;

public class DesktopApp {
    private String aeAddress;
    private int aePort;

    public DesktopApp(String aeAddress, int aePort) {
        this.aeAddress = aeAddress;
        this.aePort = aePort;
    }

    public void sendCommandToAE(String commandJson) {
        // Send commands to AE (like start/stop actuator, update behavior)
    }

    public void displaySensorData() {
        // Receive sensor data from AE and display it (possibly in graphical form)
    }
}
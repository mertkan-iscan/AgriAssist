package org.example.desktop_app;

public class DesktopAppMain {
    public static void main(String[] args) {
        DesktopAppClient client = new DesktopAppClient("localhost", 54321);
        client.start();
    }
}

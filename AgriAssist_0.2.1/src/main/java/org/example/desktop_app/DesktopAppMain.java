package org.example.desktop_app;

import javax.swing.*;

public class DesktopAppMain {
    public static void main(String[] args) {
        DesktopAppClient client = new DesktopAppClient("localhost", 54321);
        new Thread(client::start).start();


        SwingUtilities.invokeLater(() -> {
            DesktopAppGui app = new DesktopAppGui();
            app.initUI();
        });

    }
}

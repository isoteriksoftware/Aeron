package com.isoterik.aeron.aeron;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.*;
import java.util.Enumeration;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        Button btnHost = new Button("Host Connection");
        Button btnJoin = new Button("Join Connection");

        HBox btnBar = new HBox(20);
        btnBar.setAlignment(Pos.CENTER);
        btnBar.getChildren().add(btnHost);
        btnBar.getChildren().add(btnJoin);

        Scene scene = new Scene(btnBar, 300, 200);
        stage.setScene(scene);
        stage.setTitle("Aeron");
        stage.show();

        btnHost.setOnAction(evt -> {
            new HostHandler().show();
        });
    }

    public static void main(String[] args) throws UnknownHostException, SocketException {
        launch(args);

//        System.out.println("Host addr: " + InetAddress.getLocalHost().getHostAddress());  // often returns "127.0.0.1"
//        Enumeration<NetworkInterface> n = NetworkInterface.getNetworkInterfaces();
//        while (n.hasMoreElements()) {
//            NetworkInterface e = n.nextElement();
//            System.out.println("Interface: " + e.getName());
//            Enumeration<InetAddress> a = e.getInetAddresses();
//            while (a.hasMoreElements()) {
//                InetAddress addr = a.nextElement();
//                System.out.println("  " + addr.getHostAddress());
//            }
//        }
    }
}















package com.isoterik.aeron.aeron;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.net.*;
import java.util.*;

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
            new HostDialog().showAndWait();
        });
    }

    private static class HostDialog extends Dialog<String> {
        private Map<String, String> hosts = new HashMap<>();

        public HostDialog() {
            DialogPane pane = getDialogPane();
            ComboBox<String> comboBox = null;

            try {
                comboBox = new ComboBox<>(FXCollections.observableList(getAvailableHosts()));
            } catch (SocketException e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to get available network interfaces!");
                alert.show();
                close();
            }

            if (comboBox != null) {
                HBox box = new HBox();
                box.getChildren().add(comboBox);
                pane.setContent(box);
            }

            setWidth(300);
            setHeight(300);
            Window window = pane.getScene().getWindow();
            window.setOnCloseRequest(event -> window.hide());
        }

        private List<String> getAvailableHosts() throws SocketException {
            List<String> result = new ArrayList<>();

            Enumeration<NetworkInterface> n = NetworkInterface.getNetworkInterfaces();
            while (n.hasMoreElements()) {
                NetworkInterface e = n.nextElement();
                String _interface = e.getName();

                Enumeration<InetAddress> a = e.getInetAddresses();
                while (a.hasMoreElements()) {
                    InetAddress address = a.nextElement();
                    String temp = String.format("%s (%s)", address.getHostAddress(), _interface);
                    result.add(temp);
                    hosts.put(temp, address.getHostAddress());
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        launch(args);


    }
}















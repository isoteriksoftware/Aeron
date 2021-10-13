package com.isoterik.aeron.aeron;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HostHandler extends Stage {
    public HostHandler() {
        setTitle("Aeron Host");

        Scene scene = new Scene(new BorderPane(), 500, 500);
        setX(200);
        setY(200);
        setScene(scene);
    }
}

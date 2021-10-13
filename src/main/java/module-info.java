module com.isoterik.aeron.aeron {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.isoterik.aeron.aeron to javafx.fxml;
    exports com.isoterik.aeron.aeron;
}
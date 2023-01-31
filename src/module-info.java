module application.MainApp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens application to javafx.fxml;
    exports application;
    exports controller;
    opens controller to javafx.fxml;
}
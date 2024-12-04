module com.project.dental{
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;


    exports com.project.dental to javafx.graphics;  // Export to javafx.graphics

    opens com.project.dental to javafx.fxml;  // If using FXML, you may also need to open the package



    opens com.project.dental.Patient to javafx.fxml;
    opens com.project.dental.Doctor to javafx.fxml;
    opens com.project.dental.Receptionist to javafx.fxml;
    opens com.project.dental.Clinic to javafx.fxml;
    opens com.project.dental.Settings to javafx.fxml;
    exports com.project.dental.Patient;
    exports com.project.dental.Clinic;
    exports com.project.dental.Settings;
    exports com.project.dental.Doctor;
    exports com.project.dental.Receptionist;

}

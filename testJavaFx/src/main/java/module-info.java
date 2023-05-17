module com.example.testjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
   //requires validatorfx;

    opens com.example.testjavafx to javafx.fxml;
    exports com.example.testjavafx;
}
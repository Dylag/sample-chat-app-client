module com.example.testjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    exports com.example.chatClient.sceneControllers;
    opens com.example.chatClient.sceneControllers to javafx.fxml;

    exports com.example.chatClient.globals;
    opens com.example.chatClient.globals to javafx.fxml;
    exports com.example.chatClient;
    opens com.example.chatClient to javafx.fxml;
}
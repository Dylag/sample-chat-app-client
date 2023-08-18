package com.example.testjavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeController {

    @FXML
    Button btn_registration;

    @FXML
    Button btn_login;

    public void close()
    {
        javafx.application.Platform.exit();
    }
    public void registration() throws IOException
    {
        Stage stage = (Stage) btn_registration.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("RegistrationScene.fxml"))));
    }

    public void auth() throws IOException
    {
        Stage stage = (Stage) btn_login.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("AuthScene.fxml"))));
    }
}

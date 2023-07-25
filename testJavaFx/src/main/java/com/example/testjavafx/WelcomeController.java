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
        ServerConnector.out.println("reg");
        Stage stage = (Stage) btn_registration.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("RegistrationScene.fxml"))));
    }

    public void auth() throws IOException
    {
        ServerConnector.out.println("log");
        Stage stage = (Stage) btn_login.getScene().getWindow();
        System.out.println(1);
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("AuthScene.fxml"))));
        System.out.println(2);
    }
}

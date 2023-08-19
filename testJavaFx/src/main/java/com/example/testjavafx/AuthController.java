package com.example.testjavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AuthController {

    @FXML
    TextField tf_username;

    @FXML
    PasswordField pf_password;

    @FXML
    public void initialize(){
        ServerConnector.out.println("log");
    }

    @FXML
    public void auth() throws IOException
    {
        String username = tf_username.getText();
        String password = pf_password.getText();


        ServerConnector.out.println(username + "|" + password);
        String response = ServerConnector.in.readLine();
        System.out.println(response);
        if(response.equals("yes")) {
            User.name = username;
            System.out.println("logged");
            Stage stage = (Stage) tf_username.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ChatScene.fxml"))));
        } else
            showError("Some error");
    }

    public void back() throws IOException
    {
        ServerConnector.out.println("|back");

        Stage stage = (Stage) tf_username.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("WelcomeScene.fxml"))));
    }

    private void showError(String message)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Sample Chat App");
        alert.setHeaderText(message);
        alert.showAndWait();
    }
}

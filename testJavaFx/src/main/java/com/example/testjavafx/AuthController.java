package com.example.testjavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class AuthController {

    @FXML
    TextArea ta_username;

    @FXML
    PasswordField pf_password;

    @FXML
    public void auth() throws IOException
    {
        String username = ta_username.getText();
        String password = pf_password.getText();


        ServerConnector.out.println(username);
        String response = ServerConnector.in.readLine();

        if(response.equals("Unknown username")) {
            showError(response);
            return;
        }

        ServerConnector.out.println(password);

        response = ServerConnector.in.readLine();

        if (response.equals("yes"))
        {
            User.name = username;

            Stage stage = (Stage) ta_username.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ChatScene.fxml"))));
        } else
            showError(response);
    }

    public void back() throws IOException
    {
        ServerConnector.out.println("|back");

        Stage stage = (Stage) ta_username.getScene().getWindow();
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

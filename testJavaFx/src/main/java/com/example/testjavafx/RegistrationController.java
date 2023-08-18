package com.example.testjavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationController {

    @FXML
    public TextArea ta_username;
    @FXML
    public PasswordField pf_password;

    @FXML
    public void initialize(){
        ServerConnector.out.println("reg");
    }

    @FXML
    public void registration() throws IOException {
        String username = ta_username.getText();
        String password = pf_password.getText();

        ServerConnector.out.println(username + "|" + password);
        String response = ServerConnector.in.readLine();
        if(response.equals("no"))
            showError();
        else
        {
            User.name = username;
            Stage stage = (Stage) ta_username.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ChatScene.fxml"))));
        }

    }

    @FXML
    public void back() throws IOException
    {
        ServerConnector.out.println("|back");

        Stage stage = (Stage) ta_username.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("WelcomeScene.fxml"))));
    }

    private void showError()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Sample Chat App");
        alert.setHeaderText("That username was already taken!");
        alert.showAndWait();
    }
}

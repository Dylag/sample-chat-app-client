package com.example.chatClient.sceneControllers;

import com.example.chatClient.globals.MessageReceiver;
import com.example.chatClient.globals.ServerConnector;
import com.example.chatClient.globals.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class ChatController {



    @FXML
    TextField tf_message;

    @FXML
    TextArea ta_chat;

    Thread messageReceiver;

    @FXML
    public void initialize()
    {
        messageReceiver = new Thread(new MessageReceiver(ta_chat));
        System.out.println("launching messageReceiver");
        messageReceiver.start();
    }
    @FXML
    protected void sendMessage()
    {
        ServerConnector.out.println(String.format("%s: %s", User.name, tf_message.getText()));
        tf_message.setText("");
    }

    @FXML
    protected void goBack() throws IOException {
        ServerConnector.out.println("|back");
        Stage stage = (Stage) ta_chat.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("WelcomeScene.fxml"))));
    }

    @FXML
    protected void close(){
        System.out.println("closing...");
        javafx.application.Platform.exit();
    }
}
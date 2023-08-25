package com.example.chatClient.sceneControllers;

import com.example.chatClient.globals.MessageReceiver;
import com.example.chatClient.globals.ServerConnector;
import com.example.chatClient.globals.User;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


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
}
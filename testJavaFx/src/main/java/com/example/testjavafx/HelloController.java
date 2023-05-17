package com.example.testjavafx;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;


public class HelloController {
    String serverIP = "";
    int serverPort = 0;
    static String nickname = "noname";
    BufferedReader in;
    PrintWriter out;

    Socket socket;

    Thread messageReceiver;
    @FXML
    TextField serverPortTextField;
    @FXML
    TextField serverIPTextField;

    @FXML
    TextField messageTextField;

    @FXML
    TextArea chatArea;

    @FXML
    TextField nicknameField;

    @FXML
    protected void onConnectToServerClick()
    {
        serverIP = serverIPTextField.getText();
        serverPort = Integer.parseInt(serverPortTextField.getText());
        chatArea.appendText("Connecting to server...\n");
        try
        {
            socket = new Socket(InetAddress.getByName(serverIP), serverPort);

            chatArea.appendText("Successfully connected to server: " + socket + "\n");

            in= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);

            messageReceiver = new Thread(new MessageReceiver(socket,chatArea));
            messageReceiver.start();
            out.println("hello, server, im " + nickname);
        }
        catch (Exception ex)
        {
            chatArea.appendText(ex.toString());
        }

    }

    @FXML
    protected void sendMessage()
    {
        out.println(String.format("%s: %s",nickname,messageTextField.getText()));
        messageTextField.setText("");
    }

    @FXML
    protected  void setNickname()
    {
        nickname = nicknameField.getText();
    }

}
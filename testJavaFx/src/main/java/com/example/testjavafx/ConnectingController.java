package com.example.testjavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class ConnectingController {
    public static boolean connectingState = false;

    static  Stage mainStage;
    @FXML
    public TextArea ta_ip;
    @FXML
    public TextArea ta_port;
    @FXML
    protected void close()
    {
        try{
            ServerConnector.socket.close();
        } catch (Exception ex) {}

        javafx.application.Platform.exit();
    }

    @FXML
    protected void connect() throws IOException
    {
        mainStage = (Stage) ta_ip.getScene().getWindow();

        String ip = ta_ip.getText();
        int port = Integer.parseInt(ta_port.getText());
        Thread serverConnector = new Thread(new ServerConnector(ip,port));
        serverConnector.start();

        connectingState = true;

        mainStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("WelcomeScene.fxml"))));
        System.out.println(String.format("Connected to server: %s$%d",ip,port));
    }
}

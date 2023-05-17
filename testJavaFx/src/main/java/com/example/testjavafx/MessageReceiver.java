package com.example.testjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.BuilderFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MessageReceiver implements Runnable{
    BufferedReader in;
    Socket socket;
    TextArea chatArea;
    MessageReceiver(Socket _socket, TextArea _chatArea)
    {
        chatArea = _chatArea;
        socket = _socket;
        try{
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch (Exception ex){}

        //println("Message receiver created!");
    }

    public void run()
    {
        System.out.println("running message receiver");
        //println("message receiver is running!");
        while(true)
        {
            System.out.println("waiting for message ");
            String message = "nothing";
            try {
                message = in.readLine();
            }catch (Exception ex){
                System.out.println(ex);
            }
            System.out.println(message);
            //idk why but program falls without this
            try{Thread.sleep(1);}catch (Exception ex){}
            println(message);
            System.out.println(message + " printed to chatArea");
        }
    }

    public void println(String s)
    {
        chatArea.appendText(s + "\n");
    }


}

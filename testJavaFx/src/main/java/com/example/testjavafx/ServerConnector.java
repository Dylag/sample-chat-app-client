package com.example.testjavafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ServerConnector implements Runnable{

    String ip;
    int port;

    static Socket socket;
    static  BufferedReader in;
    static PrintWriter out;
    ServerConnector(String _ip, int _port )
    {
        ip = _ip;
        port = _port;
    }

    public void run()
    {
        try{
            System.out.println(String.format("Connecting to server: %s$%d",ip,port));

            socket = new Socket(InetAddress.getByName(ip),port);

            in= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);

            System.out.println(in.readLine());
            out.println("hello from " + InetAddress.getLocalHost());
        } catch (Exception ex){
            System.out.println(ex);
        }
    }
}

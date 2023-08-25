package com.example.chatClient.globals;

import javafx.scene.control.TextArea;

public class MessageReceiver implements Runnable{

    TextArea ta_chat;

    public MessageReceiver(TextArea _ta_chat)
    {
        ta_chat = _ta_chat;
    }


    public void run()
    {
       System.out.println("message receiver is running!");


        while(true)
        {
            try {
                String message = ServerConnector.in.readLine();
                System.out.println(message);
                ta_chat.appendText(message + "\n");
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }




//        while(true)
//        {
//            System.out.println("waiting for message ");
//            String message = "nothing";
//            try {
//                message = in.readLine();
//            }catch (Exception ex){
//                System.out.println(ex);
//            }
//            System.out.println(message);
//            //idk why but program falls without this
//            try{Thread.sleep(1);}catch (Exception ex){}
//            println(message);
//            System.out.println(message + " printed to chatArea");
//        }
    }
}

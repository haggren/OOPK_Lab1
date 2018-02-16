/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puppg;

import java.io.*;


/**
 *
 * @author hugo
 */
public class Model {
    
    private Client client;
    private Server server;
    private PrintWriter outputStream;
    private File messageFile;
    
    public Model(String address,int port, int userType){
        //om man är server
        if (userType == 0){
            Thread thr1 = new Thread(new Runnable(){
                @Override
                public void run() {
                    new Server(address,port);
                }
                
            });
            thr1.start();
            
        }
        client = new Client(address,port);
//        createFile();
//        Thread thr2 = new Thread(new Runnable(){
//                @Override
//                public void run() {
//                    receiveMessage();
//                }
//                
//            });
//        thr2.start();
    }
    
    public void sendMessage(String s){
        try {
            client.send(s);
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Couldn't send message.");
        }
    }
    public String receiveMessage(){
        System.out.println("received");
        String s =  client.receive();
        //addToFile(createLogString(s));
        return s;
    }
    
    private void createFile(){
        try{
            outputStream = new PrintWriter("log.xml");
        }
        catch(Exception e){
             System.out.println("Error: " + e.toString());
        }
        
        
    }   
    private void addToFile(String input){
        outputStream.println(input + "trying to addtofile");
        outputStream.flush();
    }
    
    private String createLogString(String text){
        
        String outputs = "<message><text>" + text + "</text></message>";
        System.out.println("Made a logstring");
        
        return outputs;
    }
}

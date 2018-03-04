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
    
    private int userType;
    private Client client;
    private Server server;
    private PrintWriter outputStream;
    private File messageFile;
    
    public Model(String address,int port, int u){
        userType = u;
        //om man är server
        if (userType == 0){
            server = new Server(address,port);
            
        }else{
            client = new Client(address,port);
        }

    }
    
    public void sendMessage(String s){
        if (userType == 0){
             try {
                server.send(s);
            } catch (UnsupportedEncodingException ex) {
                System.out.println("Couldn't send message.");
            }
        }else {
            try {
                client.send(s);
            } catch (UnsupportedEncodingException ex) {
                System.out.println("Couldn't send message.");
            }
        }
       
    }
    public String receiveMessage(){
        System.out.println("4. received");
        String s;
        if (userType == 0){
            s = server.receive();
        }else{
        s =  client.receive();
        //addToFile(createLogString(s));
        
        }
        return s;
    }
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puppg;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author hugo
 */
public class Server {
    
    private ServerSocket serverSocket;
    private List<Socket> clientList;
    


    public Server(String address, int port){

	// Starta serverns socket
	try {
	    serverSocket = new ServerSocket(port);
	} catch (IOException e) {
	    System.out.println("Could not listen on port: " + port);
	    System.exit(-1);
	}
        
        clientList = new ArrayList();
	
	// Lyssna efter klienter.
        // Varje gÃ¥ng en klient ansluter atartas en
	// ny tråd av typen 'ChatThread', som sedan
	// behandlar resten av kommunikationen
	// EkotrÃ¥darna tar klientsocketen som argument
	// fÃ¶r att veta vem som har anslutit sig
	while(true){
	    Socket clientSocket = null;
	    try {
		clientSocket = serverSocket.accept();
                clientList.add(clientSocket);
	    } catch (IOException e) {
		System.out.println("Accept failed: " + port);
		System.exit(-1);
	    }
	    Thread thr = new ChatThread(clientSocket);
	    thr.start();
	}
    }
}
class ChatThread extends Thread{
     // Socket, lämnas via konstruktorn
    private Socket clientSocket = null;

    // Strömmar får att läsa/skriva till klienten
    private PrintWriter out;
    private BufferedReader in;

    // Meddelandet som konverteras och skickas till alla clienter
    private String echo;

    // Konstruktorn sparar socketen lokalt
    public ChatThread(Socket sock){
	clientSocket = sock;
    }

    public void run(){

	// Vi kÃ¶r tills vi Ã¤r klara
	boolean done = false;

	// Anslut läs- och skrivströmmarna
	try{
	    out = new PrintWriter(clientSocket.getOutputStream(), true);
	}catch(IOException e){
	    System.out.println("getOutputStream failed: " + e);
	    System.exit(1);
	}
	try{
	    in = new BufferedReader(new InputStreamReader(
	            clientSocket.getInputStream()));
	}catch(IOException e){
	    System.out.println("getInputStream failed: " + e);
	    System.exit(1);
	}

	// Kommer vi hit gick anslutningen bra.
	// Vi skriver ut IP-nummret från klienten
	System.out.println("Connection Established: " 
			   + clientSocket.getInetAddress());

	// Här läser vi in klientens budskap
	// och konverterar det till versaler
	// Om klienten kopplar ner gör vi det också,
	// och avslutar tråden
	while(!done){
	    try{
		echo = in.readLine();
		if(echo==null){
		    System.out.println("Client disconnect!");
		    done = true;
		}else{
		    System.out.println("Recieved: (" 
                            + clientSocket.getInetAddress() 
                            + ") " + echo);
		    out.println(echo.toUpperCase());
		}
	    }catch(IOException e){
		System.out.println("readLine failed: " + e);
		System.exit(1);
	    }
	}

	try{
	    in.close();
	    out.close();
	    clientSocket.close();
	}catch(IOException e){}
    }
    public void sendToAll(){
        
    }
    
}
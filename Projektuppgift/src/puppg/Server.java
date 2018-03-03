/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puppg;

/**
 *
 * @author hugo
 */
import java.io.*;
import java.net.*;

public class Server{

    // StrÃ¶mmar fÃ¶r att lÃ¤sa/skriva
    private PrintWriter out;
    private BufferedReader in;
    private BufferedReader stdIn;
    // texten som lÃ¤ses in/skickas tillbaka
    private String echo;

    // Sockets till uppkopplingen
    private ServerSocket serverSocket;
    private Socket clientSocket = null;



    public Server(String address, int port){

	// Koppla upp serverns socket
	try {
	    serverSocket = new ServerSocket(port);
	} catch (IOException e) {
	    System.out.println("Could not listen on port: " + port);
	    System.exit(-1);
	}
	
	// Lyssna efter en klient
	try {
	    clientSocket = serverSocket.accept();
	} catch (IOException e) {
	    System.out.println("Accept failed: " + port);
	    System.exit(-1);
	}

	// Anslut till klienten
	try{
	    out = new PrintWriter(
				  clientSocket.getOutputStream(), true);
            out.flush();
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

	// Kommer vi hit har det gÃ¥tt bra
	// Vi skriver ut IP-adressen till klienten
	System.out.println("Connection Established: " 
			   + clientSocket.getInetAddress());

	// LÃ¤s frÃ¥n klienten och skicka tillbaka 
	// medelandet i versaler tills klienten
	// kopplar ner
//	while(true){
//	    try{
//		echo = in.readLine();
//		if(echo==null){
//		    System.out.println("Client disconnect!");
//		    System.exit(1);
//		}
//		System.out.println("Recieved: " + echo);
//		out.println(echo.toUpperCase());
//	    }catch(IOException e){
//		System.out.println("readLine failed: " + e);
//		System.exit(1);
//	    }
//	}
    }
    
     public void send(String text) throws UnsupportedEncodingException{
        
         System.out.println("SERVER TEXT "+ text);
        
        String userInput;
        
         System.out.println(text);

        BufferedReader textIn = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(text.getBytes("UTF-8"))));
      
                                   
	// LÃ¤s in frÃ¥n terminalen och skicka till servern:
        try{
        
	if ((userInput = textIn.readLine()) != null) {
            System.out.println(userInput);
            System.out.println(text);
            out.flush();
	    out.println(userInput);
            out.flush();
            
            }
        }
        catch(Exception e){ 
            System.out.println("oh shit son sum tin wong");
        }
    }
    public String receive(){
        String s = null;
        System.out.println("5. server receive");
        try{
                System.out.println("6. We in here");
                s = in.readLine();
                System.out.println("7. now we out here");
                //System.out.println(in.readLine());

        }catch(Exception e){
            System.out.println(e);}
        
        return s;
        
    }
}
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puppg;

import java.io.*;
import java.net.*;


/**
 *
 * @author hugo
 */
public class Client {
    
    // Strömmar för att läsa från/skriva till servern
    private PrintWriter out = null;
    private BufferedReader in = null;
    public Socket clientSocket = null;
    
    public Client(String address, int port){
        // Socket som ansluter till servern
        
     

	// Ström för att läsa från sendField
//	BufferedReader stdIn;
//	String userInput;


        // Måste vara ett input
	

	// Anslut till server:
        try {
            clientSocket = new Socket(address, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.flush();
            in = new BufferedReader(new InputStreamReader(
                                        clientSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host.\n" + e);
            System.exit(1);
        } catch (IOException e) {
            System.out.println("sumtinwong");
            System.err.println("Couldn't get I/O for "
                               + "the connection to host.\n" + e);
            System.exit(1);
        }

	// Kommer vi hit har anslutningen gått bra
	System.out.println("Connection successful!");

	// Anslut stdIn till terminalen
//	stdIn = new BufferedReader(new InputStreamReader(System.in));
                                   
	// LÃ¤s in frÃ¥n terminalen och skicka till servern:
//        try{
//	while ((userInput = stdIn.readLine()) != null) {
//	    out.println(userInput);
//	    System.out.println("echo: " + in.readLine());
//            }
//        }
//        catch(Exception e){
//            System.out.println("oh shit son sum tin wong");
//        }

	// Hit kommer vi troligtvis aldrig,
	// men så här stänger man alla inblandade strömmar
//	out.close();
//	in.close();
//	stdIn.close();
//	clientSocket.close();
    }
    
    public void send(String text) throws UnsupportedEncodingException{
        
        
        System.out.println("CLIENT TEXT "+text);
        String userInput;
        

        BufferedReader textIn = new BufferedReader(new InputStreamReader(
                new ByteArrayInputStream(text.getBytes("UTF-8"))));
      
                                   
        try{
	if ((userInput = textIn.readLine()) != null) {
            out.flush();
	    out.println(userInput);
            System.out.println("CLIENT MESSAGE SENT LMAO");
            out.flush();
            }
        }
        catch(Exception e){
            System.out.println("oh shit son sum tin wong");
        }
    }
    public String receive(){
        
        String s = null;
        System.out.println("client receive");
        try{
                s = in.readLine();
                //System.out.println(in.readLine());

        }catch(Exception e){
            System.out.println(e);}
        
        return s;
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puppg;

import java.awt.Color;
import java.io.*;
import java.nio.charset.StandardCharsets;
import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


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
    private SAXParserFactory saxFactory = SAXParserFactory.newInstance();
    private SAXParser parser;
    
    public Model(String address,int port, int u){
        userType = u;
        //om man är server
        if (userType == 0){
            server = new Server(address,port);
            
        }else{
            client = new Client(address,port);
        }
        try{
            this.parser = saxFactory.newSAXParser();
        }
        catch(Exception ex){
            System.out.println("fuck fuck fuck fuck");
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
    public Message receiveMessage(){
        System.out.println("4. received");
        String s;
        if (userType == 0){
            s = server.receive();
        }else{
        s =  client.receive();
        //addToFile(createLogString(s));
        
        }
        try{
        return handleInputMessage(s);
        }catch(Exception ex){
            Message ret =new Message("något problem, disconnecto","MAX");
            ret.setDisconnect();
            return ret;
        }
    }
    
    public Message handleInputMessage(String messageString) throws Exception {
        /*
        Parsear ett inkommet string och gör om de till ett message helt enkelt.
        För att kunna göra detta så måste vi
        använda en parser, vi använder parsern SAXParser denna kan läsas mer om 
        i dennes dokumentation. För att använda
        en SAXParser så måste vi ha en Handler åt parsern, denna handler är en 
        inre klass och en kan läsa mer om den
        nedan. Parsern parsar heller inte strängar direkt, så vi måst konvertera
        från sträng till en InputStream.
        */
        MyParceHandler myHandler = new MyParceHandler();
        InputStream stream = 
                new ByteArrayInputStream(
                        messageString.getBytes(StandardCharsets.UTF_8.name()));

        try {
            this.useParser(stream, myHandler); /*För att använda parsern krävs
            en handler och en inputström.*/
        } catch (Exception e) {
            System.out.println("OOOOps");
            return null;
        }
        

        return myHandler.getMessage();
    }
    
        private void useParser(InputStream stream, DefaultHandler handler) {
        try {
            parser.parse(stream, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
        
        private SAXParser getParser() {
        try {
            return saxFactory.newSAXParser();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}


class MyParceHandler extends DefaultHandler {

        /*
        Denna klass är en klass som vi måste ha för att kunna använda en
        SAXParser. Klassen har ett jobb, vilket är att
        läsa igenom en sträng och spara den information som vi måste ha för
        att skapa ett medelande. Sedan har denna klass
        också en metod som kan hämta medelandet som vi parsat fram.
         */

        private String messageSender;
        private Color color = Color.BLACK;
        private String text;
        private boolean haveSetName = false;
        private boolean haveSetColor = false;
        private boolean isEncrypted = false;
        private String type;
        private boolean messageContainsFileRequest = false;
        //private FileRequest fileRequest;
        private boolean messageContainsFileResponse = false;
       // private FileResponse fileResponse;
        private boolean messageContainsConnectRequest = false;
       // private EncryptionFactory encryptionFactory = new EncryptionFactory();

        private boolean messageIsDisconnect = false;

        @Override
        public void startElement(String uri, String localName, 
                String qName, Attributes attributes) {
            /*
            Denna metod bestämmer vad vi ska göra när vi stöter på en starttag.
            Eftersom vi vill kunna hantera en mängd
            olika taggar på olika unika sätt så har vi valt att splitta upp 
            detta jobb i ett flertal mindre metoder.
             */

            this.handleStartTag(qName, attributes);

        }

        @Override
        public void endElement(String uri, String localName,
                String qName) throws SAXException {
            /*
            Denna klass bestämmer vad som ska hända när vi stöter på en sluttag.
            Notera att vi inte gör något, detta kommer
            sig av att vi inte är intresserade av sluttaggar i denna chattapp.
             */
            
        }

        @Override
        public void characters(
                char ch[], int start, int length) throws SAXException {


                text = new String(ch, start, length);
            
        }

        public Message getMessage() {
            /*
            if (messageContainsConnectRequest) {
                Message ret = new Message(messageSender, text);
                ret.setConnectRequest();
                return ret;
            } else*/ if (messageIsDisconnect) {
                Message ret = new Message(text,messageSender);
                ret.setDisconnect();
                return ret;
            }
            /*
            if (messageContainsFileRequest) {
                return new Message(messageSender, text, fileRequest);
            } else if (messageContainsFileResponse) {
                return new Message(messageSender, text, fileResponse);
            
            } */else return new Message(text,messageSender,color);
        }

        private void handleStartTag(String tagName, Attributes attributes) {
            /*
            Denna metod känner igen alla taggar som vi kan hantera, och kan
            skicka en tag till rätt hanterare. Till
            exempel om vi får en text-tagg så skickar vi det till text-taggs
            hanteraren.
             */

            if (tagName.equalsIgnoreCase("message")) {
                System.out.println("SVENS PARSER FUNKAR JÄÄÄÄÄÄTTEEEEBRAAAA!");
                this.handleMessageTag(attributes);
            }

            if (tagName.equalsIgnoreCase("text")) {
                this.handleTextTag(attributes);
            }

            if (tagName.equalsIgnoreCase("disconnect")) {
                System.out.print("disc tag detected");
                this.messageIsDisconnect = true;
            }
/*
            if (tagName.equalsIgnoreCase("encrypted")) {
                this.handleEncryptedTag(attributes);
            }

            if (tagName.equalsIgnoreCase("filerequest")) {
                this.handleFileRequestTag(attributes);
            }

            if (tagName.equalsIgnoreCase("fileresponse")) {
                this.handleFileResponseTag(attributes);
            }

            if (tagName.equalsIgnoreCase("request")) {
                this.handleRequestTag(attributes);
            }*/
        }

        private void handleTextTag(Attributes attributes) {
            /*
            Hanterar en texttagg genom att plocka det relevanta attributet och
            spara det. Eftersom att färgen skickas
            som en Hex-kod så måste vi först konvertera Hex till den vanliga
            Color klassen.
             */

            color = createColorFromHex(attributes.getValue("color"));
            haveSetColor = true;
        }
/*
        private void handleEncryptedTag(Attributes attributes) {


            isEncrypted = true;
            type = attributes.getValue("type");
            key = DatatypeConverter.parseHexBinary(attributes.getValue("key"));
        }*/

        private void handleMessageTag(Attributes attributes) {
            /*
            Hanterar meddelande-taggar.
             */

            messageSender = attributes.getValue("sender");
            haveSetName = true;
        }
/*
        private void handleFileRequestTag(Attributes attributes) {

            String fileName = attributes.getValue("name");
            int fileSize = Integer.valueOf(attributes.getValue("size"));

            fileRequest = new FileRequest(fileName, fileSize);
            messageContainsFileRequest = true;
        }

        private void handleFileResponseTag(Attributes attributes) {


            boolean acceptedFileRequest = 
                    attributes.getValue("reply").equalsIgnoreCase("yes");

            int port = Integer.valueOf(attributes.getValue("port"));

            fileResponse = new FileResponse(acceptedFileRequest, port);
            messageContainsFileResponse = true;
        }*/
        private void handleRequestTag(Attributes attributes) {
            /*
            Hanterar request taggar.
             */

            messageContainsConnectRequest = true;
        }

        private Color createColorFromHex(String hexColor) {
            /*
            Konverterar en färg från hex-kod till en färg representerad av
            Javas Color-klass.
             */

            int r, g, b;
            r = Integer.valueOf(hexColor.substring(1, 3), 16);
            g = Integer.valueOf(hexColor.substring(3, 5), 16);
            b = Integer.valueOf(hexColor.substring(5, 7), 16);

            return new Color(r, g, b);
        }

        public String toText(String hex) {
            try {
                byte[] bytes = DatatypeConverter.parseHexBinary(hex);
                return new String(bytes, StandardCharsets.UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    


       
    }

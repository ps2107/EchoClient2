package SimpleChat;
import java.net.*;
import java.io.*;
import java.io.PrintWriter.*;

public class EchoClient {
    private String address;
    private int port;

    public EchoClient(String address, int port){
        this.address = address;
        this.port = port;
    }

    public void run(){
        // networking code goes here..
        try(Socket socket = new Socket(address,port)){
            //create boolean argument so that print write constructor flushes automatically
            PrintWriter sendTo = new PrintWriter(
                    socket.getOutputStream(), true);
            BufferedReader readFrom = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            BufferedReader cmd = new BufferedReader(
                    new InputStreamReader( System.in));
            //read text from the user
        String userInput = cmd.readLine();
        String response;
        //while there is some user input, do the following...
        while (userInput != null){
            //send user input to the server
            sendTo.println(userInput);
            //read text from server
            response = readFrom.readLine();
            //print text from server back to the user
            System.out.println(response);
            userInput = cmd.readLine();
        }
        //if the server isn't running, there will be an exception. you have to handle it in advance, otherwise the program will crash
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

    }

}

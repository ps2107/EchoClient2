package SimpleChat;
import java.net.*;
import java.io.*;
public class Main {

    public static void main(String[] args) {
        // write your code here
        EchoClient server = new EchoClient("localhost", 7777);
        server.run();


    }
}

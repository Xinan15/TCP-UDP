import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception { // Exception handling is required for Socket class
        
        // 1. Create a new instance of the Socket class
        Socket socket = new Socket("localhost", 9999);
        System.out.println("Client is connected to the server successfully!");
    }
}
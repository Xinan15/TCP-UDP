import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws Exception { // Exception handling is required for ServerSocket class
        // 1. Create a new instance of the ServerSocket class
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Server is successfully started and running on port 9999, waiting for incoming connections...");

        // 2. Wait for client incoming connections
        serverSocket.accept(); // this method is a blocking method, it will wait until a client connects to the server
        System.out.println("Client connected to the server successfully!");
    }
}

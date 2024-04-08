
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception { // Exception handling is required for ServerSocket class
        // 1. Create a new instance of the ServerSocket class
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Server is successfully started and running on port 9999.");
        System.out.println("Waiting for the client to connect...");

        // 2. Wait for client incoming connections
        Socket socket = serverSocket.accept();
        // this method is a blocking method, it will wait until a client connects to the server
        System.out.println("Client connected to the server successfully!");

        // 3. Receive data from the client
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String content = bufferedReader.readLine();

        System.out.println("Data received from the client: " + content);

        // 4. Send data to the client
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("Hello from the server!");

        bufferedWriter.newLine();
        bufferedWriter.flush();

    }
}

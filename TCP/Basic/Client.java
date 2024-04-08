
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception { // Exception handling is required for Socket class
        
        // 1. Create a new instance of the Socket class
        Socket socket = new Socket("localhost", 9999);
        System.out.println("Client is connected to the server successfully!");

        // 2. Send data to the server
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("Hello from the client!");

        bufferedWriter.newLine();   // To ensure that the server can read the data correctly using readLine() method

        bufferedWriter.flush();     // Flush the data to the server, cannot be omitted

        // bufferedWriter.close();  // To close the stream, but it will also close the socket, so it is not recommended here
        // Only close the socket when you are done with the entire socket connection.

        // 3. Client receives data from the server
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String content = bufferedReader.readLine();

        System.out.println("Data received from the server: " + content);
        
    }
}
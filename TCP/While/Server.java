package While;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Server is successfully started, waiting for the client to connect...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected to the server successfully!");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            
            // 1. Receive data from the client
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String content = br.readLine();

            System.out.println("Data received from the client: " + content);

            // 2. Send data to the client
            OutputStream os = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            bw.write(scanner.nextLine());

            bw.newLine();
            bw.flush();
        }
    }
}

package Multistream;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("Server is successfully started, waiting for the client to connect...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected to the server successfully!");

        // To receive and send data continuously
        // 1. initialise a stream to receive data
        ReceThread rt = new ReceThread(socket);
        rt.start();

        // 2. initialise a stream to send data
        SendThread st = new SendThread(socket);
        st.start();
    }
}

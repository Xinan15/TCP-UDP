package Multistream;

import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8888);
        System.out.println("Client is connected to the server successfully!");

        // To receive and send data continuously
        // 1. initialise a stream to receive data
        ReceThread rt = new ReceThread(socket);
        rt.start();

        // 2. initialise a stream to send data
        SendThread st = new SendThread(socket);
        st.start();
    }
}
package UDP.Basic;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws Exception {
        // Send a message to the server

        // 1. postman - DatagramSocket
        DatagramSocket ds = new DatagramSocket(8888);

        byte[] bs = "Hello, from the client!".getBytes(); // In UDP, data is transmitted in a sequence of bytes

        // 2. parcel - DatagramPacket
        DatagramPacket dp = new DatagramPacket(bs, bs.length, InetAddress.getByName("localhost"), 9999);

        // 3. send the parcel
        ds.send(dp);

        // 4. receive a message from the server
        byte[] bytes = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(bytes,1024);
        ds.receive(dp2);
        String content = new String(dp2.getData(), 0, dp2.getLength());
        System.out.println("Message received from the server: " + content);

    }

}

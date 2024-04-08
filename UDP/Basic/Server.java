package UDP.Basic;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) throws Exception {

        // Receive a message from the client

        // 1. postman - DatagramSocket
        DatagramSocket ds = new DatagramSocket(9999);

        // 2. parcel - DatagramPacket - to receive the message
        byte[] bs1 = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bs1, bs1.length);

        // 3. receive the parcel
        ds.receive(dp);

        // 4. open the parcel - message is in the form of bytes
        String s = new String(dp.getData(), 0, dp.getLength()); // create a string from the bytes
        System.out.println("Message received from the client: " + s);

        // 5. send a message back to the client
        byte[] bs2 = "Hi, from the server!".getBytes();
        DatagramPacket dp2 = new DatagramPacket(bs2, bs2.length, InetAddress.getByName("localhost"), 8888);
        ds.send(dp2);

    }

}

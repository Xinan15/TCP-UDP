package UDP.Multi;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("Please enter the port number: "); // to create multiple clients
        Scanner sc = new Scanner(System.in);
        int port = Integer.parseInt(sc.nextLine());
        DatagramSocket ds = new DatagramSocket(port);

        // send a message to the server to inform that a new client has joined the chat room
        byte[] bs = "A new client has joined the chat room".getBytes();
        DatagramPacket dp = new DatagramPacket(bs, bs.length, InetAddress.getByName("localhost"), 9999);
        ds.send(dp);

        new SendThread(ds).start();
        new ReceThread(ds).start();
    }

}

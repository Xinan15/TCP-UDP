package While;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 9999);
        System.out.println("Client is connected to the server successfully!");

        Scanner scanner = new Scanner(System.in);
        while (true) {

            // 1. Send message to the server
            OutputStream os = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

            bw.write(scanner.nextLine());

            bw.newLine();
            bw.flush();

            // 2. Receive message from the server
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String content = br.readLine();
            System.out.println("Data received from the server: " + content);
        }
    }
}
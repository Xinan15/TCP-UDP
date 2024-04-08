package Multistream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceThread extends Thread {

    private Socket s;

    public ReceThread(Socket s) {
        this.s = s;
    }

    @Override // run method is required to be overridden in the Thread class
    public void run() {
        // receive data continuously
        while (true) {
            try {
                InputStream is = s.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String content = br.readLine();
                System.out.println("Data received: " + content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

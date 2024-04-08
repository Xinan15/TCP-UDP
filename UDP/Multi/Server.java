package UDP.Multi;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(9999);

        // create a list to store all the clients
        // every hashmap in the list is a client
        // includes IP and port
        List<HashMap<String, String>> clientList = new ArrayList<>();

        while (true) {
            // create a thread to receive data
            byte[] bytes = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bytes, 1024);
            ds.receive(dp);

            String ip = dp.getAddress().getHostAddress();
            String port = String.valueOf(dp.getPort());
            boolean flag = true;

            // check if the client is already in the list
            for (HashMap<String, String> map : clientList) {
                if (map.get("ip").equals(ip) && map.get("port").equals(port)) {
                    flag = false; // if the client is already in the list, set flag to false
                    break;
                }
            }

            if (flag) {
                HashMap<String, String> map = new HashMap<>();
                map.put("ip", ip);
                map.put("port", port);
                clientList.add(map);
            }

            // do not send message to the client who sent the message
            for (HashMap<String, String> map : clientList) {
                if (map.get("ip").equals(ip) && map.get("port").equals(port)) {
                    continue;
                } else {
                    DatagramPacket dp2 = new DatagramPacket(bytes, 0, dp.getLength(),
                            InetAddress.getByName(map.get("ip")), Integer.parseInt(map.get("port")));
                    ds.send(dp2);
                }
            }

            System.out.println(new String());

        }

    }
}

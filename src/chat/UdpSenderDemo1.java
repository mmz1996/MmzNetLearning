package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @Classname UdpSenderDemo1
 * @Description TODO
 * @Date 2020/12/2 17:11
 * @Created by mmz
 */
public class UdpSenderDemo1 {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(8888);
            while(true){
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String data = reader.readLine();
                System.out.println(data.length());
                byte[] datas = data.getBytes();
                System.out.println(datas.length);
                DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",6666));
                socket.send(packet);

                if(data.equals("bye")){
                    break;
                }
            }


            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

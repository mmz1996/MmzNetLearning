package chat;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Classname UdpReceiceDemo1
 * @Description TODO
 * @Date 2020/12/2 17:11
 * @Created by mmz
 */
public class UdpReceiceDemo1 {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(6666);

            while (true){
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container,0,container.length);
                socket.receive(packet); // 阻塞接收包裹
                byte[] data = packet.getData();
                System.out.println(data.length);
                String string = new String(data, 0, packet.getLength());

                System.out.println(string);
                System.out.println(string.length());

                if (string.equals("bye")){
                    break;
                }

            }
            socket.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package udp;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Classname UdpServerDemo1
 * @Description TODO
 * @Date 2020/12/2 17:03
 * @Created by mmz
 */
public class UdpServerDemo1 {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9090);
            // 接受数据
            byte[] bytes = new byte[1024];

            DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);

            socket.receive(datagramPacket);
            System.out.println(datagramPacket.getAddress().getHostAddress());
            System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

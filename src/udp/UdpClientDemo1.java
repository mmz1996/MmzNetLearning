package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @Classname UdpClientDemo1
 * @Description TODO
 * @Date 2020/12/2 16:59
 * @Created by mmz
 */
// 不需要连接服务器
public class UdpClientDemo1 {
    public static void main(String[] args) {
        // 1.建立一个socket
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            // 2.发送包
            String message = "你好";
            // 3.发送的人
            InetAddress localhost = InetAddress.getByName("localhost");
            int port = 9090;
            // 参数：数据长度，起始，发送给谁
            DatagramPacket datagramPacket = new DatagramPacket(message.getBytes(),0,message.getBytes().length,localhost,port);
            datagramSocket.send(datagramPacket);

            // 4.关闭流
            datagramSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

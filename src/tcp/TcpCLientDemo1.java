package tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Classname tcp.TpcCLientDemo1
 * @Description TODO
 * @Date 2020/12/2 15:49
 * @Created by mmz
 */
// 客户端
public class TcpCLientDemo1 {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            // 1.要知道服务器的地址
            InetAddress inetAddresses = InetAddress.getByName("127.0.01");
            // 2.端口号
            int port = 9999;
            // 3.创建一个socket通信
            socket = new Socket(inetAddresses,port);
            System.out.println("连接服务器成功");
            // 4.发送消息 IO流
            outputStream = socket.getOutputStream();
            outputStream.write("你好，mmz".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


}

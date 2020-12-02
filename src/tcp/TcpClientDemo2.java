package tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Classname TcpClientDemo02
 * @Description TODO
 * @Date 2020/12/2 16:15
 * @Created by mmz
 */
// 客户端
public class TcpClientDemo2 {
    public static void main(String[] args) {

        try {
            // 1.创建一个socket连接
            Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
            // 2.创建一个输出流
            OutputStream outputStream = socket.getOutputStream();

            // 3.读取文件流
            FileInputStream fileInputStream = new FileInputStream(new File("hengfu.jpg"));
            // 4.写出文件流
            byte[] bytes = new byte[1024];
            int len;
            while((len=fileInputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,len);
            }

            // 通知服务器结束了
            socket.shutdownOutput();

            InputStream inputStream = socket.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            byte[] bytes1 = new byte[1024];
            int len1;
            while((len1 = inputStream.read(bytes1)) != -1){
                byteArrayOutputStream.write(bytes1,0,len1);
            }

            System.out.println(byteArrayOutputStream.toString());

            byteArrayOutputStream.close();
            inputStream.close();
            fileInputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

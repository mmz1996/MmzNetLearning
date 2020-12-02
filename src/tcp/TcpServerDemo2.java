package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Classname TcpServerDemo2
 * @Description TODO
 * @Date 2020/12/2 16:20
 * @Created by mmz
 */

// 服务器
public class TcpServerDemo2 {
    public static void main(String[] args) {
        try {
            // 1.创建服务
            ServerSocket serverSocket = new ServerSocket(9000);
            // 2.监听客户端的连接
            Socket accept = serverSocket.accept();
            // 3.获取输入流
            InputStream inputStream = accept.getInputStream();
            // 4.文件输出
            FileOutputStream fileOutputStream = new FileOutputStream(new File("receive.jpg"));

            byte[] bytes = new byte[1024];
            int len;
            while((len =inputStream.read(bytes)) != -1){
                fileOutputStream.write(bytes,0,len);
            }

            // 通知客户端，我服务器这边已经完成了流的获取
            OutputStream outputStream = accept.getOutputStream();
            outputStream.write("我接受完毕了".getBytes());
            // 5.关闭资源
            fileOutputStream.close();
            inputStream.close();
            accept.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

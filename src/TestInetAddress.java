import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Classname TestInetAddress
 * @Description TODO
 * @Date 2020/12/2 15:16
 * @Created by mmz
 */
public class TestInetAddress {
    public static void main(String[] args) {
        try {
            // 得到本机的这个地址类
            InetAddress inetAddress1 =  InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddress1);

            // 得到百度ip地址类
            InetAddress inetAddress2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress2);

            // 得到本机的ip地址类
            InetAddress inetAddress3 = InetAddress.getLocalHost();
            System.out.println(inetAddress3);

            // 分隔符
            System.out.println("____________________________________");

            System.out.println(inetAddress2.getAddress());
            System.out.println(inetAddress2.getCanonicalHostName());
            System.out.println(inetAddress2.getClass());
            System.out.println(inetAddress2.getHostAddress());
            System.out.println(inetAddress2.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

import client.RPCClient;
import interface_.Server;
import interface_.helloService;
import server.HelloServiceImpl;
import server.ServiceCenter;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author xy
 * @date 2018/04/09 22:53
 */
public class RPCTest {


    public static void main(String[] args) throws IOException {

        new Thread(new Runnable() {
            public void run() {
                try {
                    Server serviceServer = new ServiceCenter(8088);
                    serviceServer.register(helloService.class, HelloServiceImpl.class);
                    serviceServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        helloService service = RPCClient.getRemoteProxyObj(helloService.class, new InetSocketAddress("localhost", 8088));
        System.out.println(service.sayHi("test"));
    }
}

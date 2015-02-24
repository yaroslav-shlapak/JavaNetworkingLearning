package tcpclientserver;

import java.io.IOException;

/**
 * Created by y.shlapak on Feb 04, 2015.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String hostName = "192.168.0.103";
        int port = 1234;
        Server server = new Server(port);

        while(true) {
            server.receive();
            System.out.println(server.getLightControlJson().getLightLevel());
            System.out.println(server.getLightControlJson().isLightEnabled());
        }

    }
}

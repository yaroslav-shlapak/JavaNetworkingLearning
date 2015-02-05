package tcpclientserver;

import java.io.IOException;

/**
 * Created by y.shlapak on Feb 04, 2015.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String hostName = "localhost";
        int port = 4444;
        Client client = new Client(hostName, port);
        Server server = new Server(port);

    }
}

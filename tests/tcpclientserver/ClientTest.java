package tcpclientserver;

import org.junit.Before;

public class ClientTest {
    String hostName;
    int port;
    Client client;
    Server server;
    LightControlJson lightControlJson;


    @org.junit.Test
    public void testSend() throws Exception {

    }

    @org.junit.Test
    public void testReceive() throws Exception {

    }

    @Before
    public void setUp() throws Exception {
        String hostName = "localhost";
        int port = 4444;
        Client client = new Client(hostName, port);
        Server server = new Server(port);

        lightControlJson = new LightControlJson(true, 20);

    }
}
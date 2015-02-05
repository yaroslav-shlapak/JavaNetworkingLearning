package tcpclientserver;

import junit.framework.Assert;
import org.junit.Before;

public class ClientServerTest {
    String hostName;
    int port;
    Client client;
    Server server;
    LightControlJson lightControlJson;

    boolean defBool1 = true;
    boolean defBool2 = false;

    int defInt1 = 20;
    int defInt2 = 50;


    @org.junit.Test
    public void testSend() throws Exception {
        client.send(lightControlJson);
        Assert.assertEquals(server.receive(), lightControlJson);
    }

    @org.junit.Test
    public void testReceive() throws Exception {
        lightControlJson = new LightControlJson(defBool2, defInt2);
        server.send(lightControlJson);
        Assert.assertEquals(client.receive(), lightControlJson);
    }

    @Before
    public void setUp() throws Exception {
        String hostName = "localhost";
        int port = 4444;
        client = new Client(hostName, port);
        server = new Server(port);

        lightControlJson = new LightControlJson(defBool1, defInt1);
    }
}
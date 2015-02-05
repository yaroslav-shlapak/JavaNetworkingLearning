package tcpclientserver;

import java.io.IOException;

/**
 * Created by y.shlapak on Feb 04, 2015.
 */
public class Main {


    public static void main(String[] args) throws IOException {
        boolean defBool1 = true;
        boolean defBool2 = false;

        int defInt1 = 20;
        int defInt2 = 50;

        String hostName = "localhost";
        int port = 4444;
        Client client = new Client(hostName, port);
        Server server = new Server(port);

        LightControlJson lightControlJson = new LightControlJson(defBool1, defInt1);

        while(true) {
            client.send(lightControlJson);
            lightControlJson = server.receive();
            lightControlJson.setLightLevel(lightControlJson.getLightLevel() + 1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(lightControlJson.getLightLevel());
        }

    }
}

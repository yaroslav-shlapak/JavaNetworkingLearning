package tcpclientserver;

/**
 * Created by y.shlapak on Jan 26, 2015.
 */

import com.google.gson.Gson;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws IOException {


        final String hostName = "localhost";
        final int portNumber = 4446;
        final SocketAddress address = new InetSocketAddress(hostName, portNumber);
        Thread thread = new Thread() {
            @Override
            public void run() {


                try (
                        Socket socket = new Socket();
                        DataInputStream fromServer = new DataInputStream(socket.getInputStream());
                        DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
                ) {
                    String toServerString, fromServerString;
                    socket.connect(address);

                    LightControlJson lightControlJson = new LightControlJson(true, 20);
                    Gson json = new Gson();
                    toServerString = json.toJson(lightControlJson);
                    toServer.writeUTF(toServerString);

                    socket.close();

                } catch (UnknownHostException e) {
                    System.err.println("Don't know about host " + hostName);
                    System.exit(1);
                } catch (IOException e) {
                    System.err.println("Couldn't get I/O for the connection to " +
                            hostName);
                    System.exit(1);
                }
            }
        };
        thread.start();

    }
}

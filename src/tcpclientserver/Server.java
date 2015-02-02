package tcpclientserver;

/**
 * Created by y.shlapak on Jan 26, 2015.
 */

import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        final int portNumber = 4446;
        Thread thread = new Thread() {
            @Override
            public void run() {
                try (
                        ServerSocket serverSocket = new ServerSocket(portNumber);
                        Socket clientSocket = serverSocket.accept();
                        DataInputStream fromClient = new DataInputStream(clientSocket.getInputStream());
                        DataOutputStream toClient = new DataOutputStream(clientSocket.getOutputStream());
                ) {

                    String toClientString, fromClientString;
                    fromClientString = fromClient.readUTF();
                    Gson json = new Gson();
                    LightControlJson lightControlJson = json.fromJson(fromClientString, LightControlJson.class);

                    System.out.println(lightControlJson.getLightLevel());
                    System.out.println(lightControlJson.isLightEnabled());


                } catch (IOException e) {
                    System.out.println("Exception caught when trying to listen on port "
                            + portNumber + " or listening for a connection");
                    System.out.println(e.getMessage());
                }
            }
        };
        thread.start();
    }
}

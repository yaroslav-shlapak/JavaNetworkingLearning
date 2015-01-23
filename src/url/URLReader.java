package url;

/**
 * Created by y.shlapak on Jan 23, 2015.
 */
import java.net.*;
import java.io.*;

public class URLReader {
    public static void main(String[] args) throws Exception {

        URL oracle = new URL("http://www.oracle.com/");
        URL google = new URL("http://www.google.com/");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(google.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}
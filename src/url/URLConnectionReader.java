package url;

/**
 * Created by y.shlapak on Jan 23, 2015.
 */
import java.net.*;
import java.io.*;

public class URLConnectionReader {
    public static void main(String[] args) throws Exception {

/*        try {
            URL myURL = new URL("http://example.com/");
            URLConnection myURLConnection = myURL.openConnection();
            myURLConnection.connect();
        }
        catch (MalformedURLException e) {
            // new URL() failed
            // ...
        }
        catch (IOException e) {
            // openConnection() failed
            // ...
        }*/

        URL oracle = new URL("http://www.oracle.com/");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}

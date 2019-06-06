import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.Socket;
import java.net.URL;

/**
 * @author Bartosz Kupajski
 */
public class Main {
    public static void main(String[] args) throws IOException {

        String host = "www.stackoverflow.com";
        URL url = new URL("https://www.stackoverflow.com");
        HttpsURLConnection.getDefaultHostnameVerifier();
        int port = 80;


        String path = "/questions/56443073/how-to-create-an-authentication-system-with-spring-security";
        Socket clientSocket = new Socket(url.getHost(),port);


        PrintWriter request = new PrintWriter(clientSocket.getOutputStream(),
                true);

        request.print("GET " +  path + " HTTP/1.1\r\n"); // "+path+"
        //request.print("Host: " + host + "\r\n");
        request.print("User-Agent: Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36\r\n");
        request.print("Connection: close\r\n");
        request.print("cache-control: no-cache\r\n");
        request.print("\r\n");
        request.flush();

        BufferedReader response = new BufferedReader(new InputStreamReader(
                clientSocket.getInputStream()));



        String responseLine;
        while ((responseLine = response.readLine()) != null) {
            System.out.println(responseLine);
        }


        response.close();
        request.close();
        clientSocket.close();
    }

}

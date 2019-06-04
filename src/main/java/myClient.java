import java.io.*;
import java.net.*;

/**
 * @author Bartosz Kupajski
 */
public class myClient {


    public static void main(String[] args) throws  IOException {

        Socket s = new Socket("localhost", 4999);
        PrintWriter pr = new PrintWriter(s.getOutputStream());

        pr.println("is it working");
        pr.flush();


    }
}



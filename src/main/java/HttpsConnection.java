import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Bartosz Kupajski
 */
public class HttpsConnection {
    public static void main(String[] args) throws IOException {


        final String USER_AGENT = "Mozilla/5.0";
        URL url = new URL("https://stackoverflow.com");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);


        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        StringBuffer response = new StringBuffer();

        String responseLine;
        while ((responseLine = in.readLine()) != null) {
            System.out.println(responseLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

//        Map<String, String> parameters = new HashMap<>();
//        parameters.put("param1", "val");
//
//
//
//        con.setDoOutput(true);
//        DataOutputStream out = new DataOutputStream(con.getOutputStream());
//        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
//        out.flush();
//        out.close();


    }


}

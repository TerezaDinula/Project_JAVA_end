package Controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class InputController<result> {

    private final String baseUrl;
    private Object result;

    public InputController(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void getMovieByName(String name) throws IOException {
        try {
            name = name.replace(" ", "_");
            URL url = null;
            try {
                url = new URL(baseUrl + "/search.php?s=" + name);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } return result;
    }

}
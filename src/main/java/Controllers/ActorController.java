package Controllers;

import Models.ActorModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ActorController {
    private final String baseUrl;

    public ActorController(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Object getActorIds() {
        LocalDate now = LocalDate.now();
        String month = String.valueOf(now.getMonth().getValue());
        String day = String.valueOf(now.getDayOfMonth());

        try {
            String url = baseUrl + "/actors/list-born-today?month=" + month + "&day=" + day;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("x-rapidapi-key", "47fd2465e7mshb6c4fcd9dc8b0cbp1d9085jsn36730bf01db9")
                    .header("x-rapidapi-host", "imdb8.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("HttpResponseCode: " + response.statusCode());
            } else {
                JSONParser parser = new JSONParser();
                JSONArray data = (JSONArray) parser.parse(response.body());

                List<ActorModel> actorsList = new ArrayList<>();
                for (Object value : data) {
                    ActorModel a = new ActorModel(value.toString().substring(6, 15));
                    actorsList.add(a);
                    a.setName(getName(a.getId()));
                }
                return actorsList;
            }
        } catch (IOException | InterruptedException | ParseException e) {
            e.printStackTrace();
        } catch (NullPointerException ignored) {
        }
        return null;
    }

    public String getName(String id) {
        if (id != null) {
            try {
                String url = baseUrl + "/actors/get-bio?nconst=" + id;

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .header("x-rapidapi-key", "47fd2465e7mshb6c4fcd9dc8b0cbp1d9085jsn36730bf01db9")
                        .header("x-rapidapi-host", "imdb8.p.rapidapi.com")
                        .method("GET", HttpRequest.BodyPublishers.noBody())
                        .build();
                HttpResponse<String> response = HttpClient.newHttpClient()
                        .send(request, HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() != 200) {
                    throw new RuntimeException("HttpResponseCode: " + response.statusCode());
                } else {

                    JSONParser parser = new JSONParser();
                    JSONObject data = (JSONObject) parser.parse(response.body());
                    return (String) data.get("name");
                }
            } catch (IOException | ParseException | InterruptedException e) {
                e.printStackTrace();
            } catch (NullPointerException ignored) {
            }
        }
        return null;
    }
}
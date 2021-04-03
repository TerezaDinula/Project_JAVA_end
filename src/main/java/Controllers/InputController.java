package Controllers;

import Models.MovieModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class InputController {

    private final String baseUrl;

    public InputController(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    private MovieModel getMovie(String title) {
        try {
            title = title.replace(" ", "_");
            String url = baseUrl + "/title/find?q=" + title;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("x-rapidapi-key", "90850d46cfmsha7a4832e12849e0p1aedb3jsnd59a9a34670b")
                    .header("x-rapidapi-host", "imdb8.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("HttpResponseCode: " + response.statusCode());
            } else {

                JSONParser parser = new JSONParser();
                JSONObject data = (JSONObject) parser.parse(response.body());
                JSONArray movies = (JSONArray) data.get("results");

                List<MovieModel> result = new ArrayList<>();
                for (Object object : movies) {
                    JSONObject movie = (JSONObject) object;

                    for (int i = 0; i < movies.size(); i++) {
                        result.add(new MovieModel(movie.get("title").toString(), movie.get("id").toString()));
                    }
                }
                System.out.println("Result:" + result.toString());
                return result.get(0);
            }
        } catch (IOException | InterruptedException | ParseException e) {
            e.printStackTrace();
        } catch (NullPointerException ignored) {
        }
        return null;
    }

    public MovieModel getRating(String title) {
        MovieModel movie = getMovie(title);
        String id = movie.getId(); //Q to Arturs: What to do with exception if there is no movie?
        String movieTitle = movie.getTitle();

        if (id != null) {
            id = id.substring(7, 16);
            try {
                String url = baseUrl + "/title/get-ratings?tconst=" + id;

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .header("x-rapidapi-key", "90850d46cfmsha7a4832e12849e0p1aedb3jsnd59a9a34670b")
                        .header("x-rapidapi-host", "imdb8.p.rapidapi.com")
                        .method("GET", HttpRequest.BodyPublishers.noBody())
                        .build();
                HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() != 200) {
                    throw new RuntimeException("HttpResponseCode: " + response.statusCode());
                } else {

                    JSONParser parser = new JSONParser();
                    JSONObject data = (JSONObject) parser.parse(response.body());
                    double rating = (double) data.get("rating");

                    return new MovieModel(movieTitle, rating);
                }
            } catch (IOException | ParseException | InterruptedException e) {
                e.printStackTrace();
            } catch (NullPointerException ignored) {
            }
        }
        return null;
    }
}
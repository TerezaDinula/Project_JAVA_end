import Views.InputView;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {


    public static void main(String[]args) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://imdb8.p.rapidapi.com/actors/list-born-today?month=4&day=1"))
                .header("x-rapidapi-key", "08fdb270ecmsh69ac13a40f319f5p189295jsn811b73e2d9fa")
                .header("x-rapidapi-host", "imdb8.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(response.body());


        request = HttpRequest.newBuilder()
                .uri(URI.create("https://imdb8.p.rapidapi.com/auto-complete?q=titanic"))
                .header("x-rapidapi-key", "08fdb270ecmsh69ac13a40f319f5p189295jsn811b73e2d9fa")
                .header("x-rapidapi-host", "imdb8.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(response.body());

        request = HttpRequest.newBuilder()
                .uri(URI.create("https://imdb8.p.rapidapi.com/title/get-ratings?tconst=tt0120338"))
                .header("x-rapidapi-key", "08fdb270ecmsh69ac13a40f319f5p189295jsn811b73e2d9fa")
                .header("x-rapidapi-host", "imdb8.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(response.body());

        JFrame frame = new JFrame("GuiMain");
        //Adds to the JFrame our main panel
        frame.setContentPane(new InputView().getMainPanel());
        //Set the default operation when closing the panel
        //In this case, exit the program
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Changes the window size so that we can show every element
        frame.pack();
        //Make the JFrame visible
        frame.setVisible(true);
        //Setting the frame size to 500 x 500 (because it was too small initially)
        frame.setSize(500,500);

    }

}
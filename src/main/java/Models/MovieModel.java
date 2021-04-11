package Models;

public class MovieModel {
    private final String title;
    private String id;
    private double rating;

    public MovieModel(String title, String id) {
        this.title = title;
        this.id = id;
    }

    public MovieModel(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public double getRating() {
        return rating;
    }
}

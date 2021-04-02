package Models;

import java.util.List;

public class MovieModel {
    private String name;
    private List<String> filmInformation;

    public MovieModel(String name, List<String> filmInformation) {
        this.name = name;
        this.filmInformation = filmInformation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getFilmInformation() {
        return filmInformation;
    }

    public void setFilmInformation(List<String> filmInformation) {
        this.filmInformation = filmInformation;
    }
}

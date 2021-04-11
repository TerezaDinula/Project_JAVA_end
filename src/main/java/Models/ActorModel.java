package Models;

public class ActorModel {
    private String name;
    private final String id;

    public ActorModel(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
}

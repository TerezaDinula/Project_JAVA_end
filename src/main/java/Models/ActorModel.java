package Models;

public class ActorModel {
    private String name;
    private String id;

    public ActorModel(String name, String id) {
        this.name = name;
        this.id = id;
    }

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

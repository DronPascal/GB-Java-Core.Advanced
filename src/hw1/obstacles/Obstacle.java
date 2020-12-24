package hw1.obstacles;

public abstract class Obstacle {
    private String name;

    public Obstacle() {
        this.name = this.toString();
    }

    public Obstacle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package hw1.obstacles;

public class Wall extends Obstacle {
    private double height = 0;

    public Wall(double height) {
        this.height = height;
    }

    public Wall(String name, double height) {
        super(name);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

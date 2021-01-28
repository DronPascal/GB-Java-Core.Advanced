package hw1.obstacles;

public class Treadmill extends Obstacle {
    private double length = 0;

    public Treadmill(double length) {
        this.length = length;
    }

    public Treadmill(String name, double length) {
        super(name);
        this.length = length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }
}

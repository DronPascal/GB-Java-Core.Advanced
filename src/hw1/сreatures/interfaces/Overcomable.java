package hw1.сreatures.interfaces;

import hw1.obstacles.Obstacle;

public interface Overcomable extends Runable, Jumpable {
    public boolean overcomeObstacle(Obstacle obstacle);
}

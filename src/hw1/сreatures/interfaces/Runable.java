package hw1.сreatures.interfaces;

public interface Runable {
    default void run() {
        System.out.println("Пробежался чутка");
    }

    default boolean run(double length) {
        System.out.println("Пробежал " + length);
        return true;
    }
}

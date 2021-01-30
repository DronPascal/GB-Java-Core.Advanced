package hw1.сreatures.interfaces;

public interface Jumpable {
    default void jump() {
        System.out.println("Подпрыгнл немножко");
    }

    default boolean jump(double height) {
        System.out.println("Запрыгнул на высоту " + height);
        return true;
    }
}

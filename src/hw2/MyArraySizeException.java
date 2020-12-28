package hw2;

public class MyArraySizeException extends Exception {
    public MyArraySizeException(int row, int column) {
        super("Матрица должна быть 4*4.\nРазмер вашей " + row + "*" + column + ".");
    }
}



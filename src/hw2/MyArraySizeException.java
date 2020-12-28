package hw2;

public class MyArraySizeException extends Exception {
    public MyArraySizeException(int elemNumber) {
        super("Матрица должна быть 4*4 и содержать 16 элементов. В вашей " + elemNumber + " элементов'.");
    }

    public MyArraySizeException() {
        super("Размер матрицы не 4*4");
    }
}



package hw2;

public class MyArrayDataException extends NumberFormatException{
    public MyArrayDataException(int row, int col, String str) {
        super("По индексу [" + row + "," + col+"] " + "обнаружено " +
                "недопустимое значение: " + str);
    }
}
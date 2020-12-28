package hw2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[][] strMat4 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        test(strMat4);

        String[][] strMat34 = {
                {"1", "2", "3", "4"},
                {"5", "6.0", "7", "8"},
                {"9", "10", "11", "12"}
        };
        test(strMat34);

        String[][] strMat43 = {
                {"1", "2", "3"},
                {"5", "6", "7"},
                {"9", "10", "11"},
                {"13", "14", "15"}
        };
        test(strMat43);

        String[][] strMatEmpty = {
                {"1", "2", "3", "4"},
                {},
                {"9", "10", "11"},
                {"13", "14", "15"}
        };
        test(strMatEmpty);

        String[][] strMatNotInt = {
                {"1", "2", "3dfd", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        test(strMatNotInt);
    }

    static void test(String[][] strMat) {
        try {
            System.out.println("Сумма значений матрицы: " + strMat4ToInt(strMat));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Чтобы повысить шанс вывода сообщений в правильном порядке
        // 500мс должно хватать
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Благодаря задержке переносы строк ставятся между каждым StackTrace
        System.out.println();
    }

    static int strMat4ToInt(String[][] strings) throws MyArraySizeException, MyArrayDataException {
        int rows = strings.length;
        if (rows != 4)
            throw new MyArraySizeException();
        int columns = 4;
        int elementsNumber = 0;
        for (int i = 0; i < rows; i++) {
            columns = strings[i].length;
            elementsNumber += columns;
        }
        if (elementsNumber != 16)
            throw new MyArraySizeException(elementsNumber);

        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                String str = strings[i][j];
                int num;

                try {
                    num = Integer.parseInt(str);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, str, e);
                }

                sum += num;
            }
        }
        return sum;
    }
}


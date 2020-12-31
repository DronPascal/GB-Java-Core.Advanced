package hw3;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
            1. Создать массив с набором слов (10-20 слов, среди которых должны
            встречаться повторяющиеся). Найти и вывести список уникальных слов,
            из которых состоит массив (дубликаты не считаем). Посчитать, сколько
            раз встречается каждое слово.
         */
        System.out.println("\n###Задание 1###");

        String[] words = new String[]{
                "команда", "банк", "сцена", "население", "свобода",
                "музыка", "правда", "свобода", "память", "команда",
                "память", "свобода", "договор", "дерево", "банк",
                "свобода", "музыка", "большинство", "сцена", "музыка"
        };
        List<String> wordsList = new ArrayList<>();
        wordsList = Arrays.asList(words);
        System.out.println("Все слова: " + wordsList);

        Set<String> wordsSet = new HashSet<>(wordsList);
        System.out.println("Уникальные слова: " + wordsSet);

        List<Integer> wordsNumber = new ArrayList<>(wordsSet.size());

        for (String word : wordsSet) {
            int number = Collections.frequency(wordsList, word);
            System.out.println(word + " : " + number);
        }
        /*
            2. Написать простой класс ТелефонныйСправочник, который хранит в
            себе список фамилий и телефонных номеров. В этот телефонный
            справочник с помощью метода add() можно добавлять записи.
            С помощью метода get() искать номер телефона по фамилии.
            Следует учесть, что под одной фамилией может быть несколько
            телефонов (в случае однофамильцев), тогда при запросе такой
            фамилии должны выводиться все телефоны.
            Желательно как можно меньше добавлять своего, чего нет в задании
            (т.е. не надо в телефонную запись добавлять еще дополнительные
            поля (имя, отчество, адрес), делать взаимодействие с пользователем
            через консоль и т.д.). Консоль желательно не использовать (в том
            числе Scanner), тестировать просто из метода main(), прописывая add() и get().
         */
        System.out.println("\n###Задание 2###");

        Phonebook phonebook = new Phonebook();
        System.out.println("-Добавляем Иванова.");
        phonebook.add("Иванов", "+79261425312");
        System.out.println("1) Иванов - " + phonebook.get("Иванов"));
        System.out.println("1) Сидоров - " + phonebook.get("Сидоров"));

        System.out.println("\n-Добавляем Сидорова.");
        phonebook.add("Сидоров", "+79157437375");
        System.out.println("2) Иванов - " + phonebook.get("Иванов"));
        System.out.println("2) Сидоров - " + phonebook.get("Сидоров"));

        System.out.println("\n-Добавляем второго Иванова.");
        phonebook.add("Иванов", "+79062431890");
        System.out.println("3) Иванов - " + phonebook.get("Иванов"));
        System.out.println("3) Сидоров - " + phonebook.get("Сидоров"));
    }
}

package hw3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Phonebook {
    private HashMap<String, HashSet<String>> phonebook;

    public Phonebook() {
        this.phonebook = new HashMap<>();
    }

    public HashSet<String> get(String surname) {
        if (phonebook.containsKey(surname))
            return phonebook.get(surname);
        return new HashSet<>(Arrays.asList(""));
    }

    public void add(String surname, String phone) {
        if (phonebook.containsKey(surname)) {
            HashSet<String> numberSet = phonebook.get(surname);
            numberSet.add(phone);
        } else {
            HashSet<String> numberSet = new HashSet<>(1);
            numberSet.add(phone);
            phonebook.put(surname, numberSet);
        }
    }
}

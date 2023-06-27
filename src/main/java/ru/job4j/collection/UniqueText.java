package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String oneWord : origin) {
            check.add(oneWord);
        }
        for (String oneWord : text) {
            if (!check.contains(oneWord)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
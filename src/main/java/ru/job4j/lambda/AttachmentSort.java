package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator<Attachment> comparator = new Comparator<>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return Integer.compare(o1.getSize(), o2.getSize());
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);
        Comparator<Attachment> sortIncrByName = new Comparator<>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        List<Attachment> listForTest = Arrays.asList(
                new Attachment("taclamacan", 100),
                new Attachment("honolulu", 34),
                new Attachment("reycyavic", 13)
        );
        List<Attachment> correctListForTest = Arrays.asList(
                new Attachment("honolulu", 34),
                new Attachment("reycyavic", 13),
                new Attachment("taclamacan", 100)
        );
        listForTest.sort(sortIncrByName);
        System.out.println("Приходится тестирование проводить здесь,"
        + " потому что анонимные компараторы \"не видны\" за пределами класса.");
        System.out.println(listForTest);
        System.out.println(correctListForTest);
        System.out.println("list1 & list2 isEquals == " + listForTest.equals(correctListForTest));
    }
}
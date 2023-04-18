package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setNameLastname("Гадя Петрович Хреново");
        student.setGroup("ХЗ");
        student.setReceiptDate(new Date());
        System.out.println("Студент " + student.getNameLastname()
                + ", учится в группе " + student.getGroup()
                + ", поступило " + student.getReceiptDate() + ".");
    }
}

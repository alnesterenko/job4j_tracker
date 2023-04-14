package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Show: " + this.active);
        System.out.println("Status: " + this.status);
        System.out.println("Error message: " + this.message);
    }

    public static void main(String[] args) {
        Error errorWithDefConstractor = new Error();
        errorWithDefConstractor.printInfo();
        Error first = new Error(true, 1, "Alarm!");
        first.printInfo();
        Error second = new Error(true, 2, "Somting broke!");
        second.printInfo();
        Error third = new Error(false, 3, "Всё накрылось! Страшно! Вырубай!!! )))");
        third.printInfo();
    }
}

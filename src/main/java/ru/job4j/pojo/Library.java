package ru.job4j.pojo;

public class Library {
    public static void printOneBook(Book oneBook) {
         System.out.println("Название: " + oneBook.getName()
                            + ", количество страниц: " + oneBook.getNumberOfPages());

    }

    public static void showBooks(Book[] arrOfBooks) {
        for (int i = 0; i < arrOfBooks.length; i++) {
            printOneBook(arrOfBooks[i]);
        }
    }

    public static void main(String[] args) {
        Book chemistry = new Book("Chemistry", 188);
        Book physics = new Book("Physics", 192);
        Book biology = new Book("Biology", 204);
        Book programming = new Book("Clean code", 648);
        Book[] books = new Book[4];
        books[0] = chemistry;
        books[1] = physics;
        books[2] = biology;
        books[3] = programming;
        showBooks(books);
        System.out.println("Вывод массива книг, после перестановки местами элементов"
                            + " c индексами 0 и 3:");
        Book tempVariable = books[0];
        books[0] = books[3];
        books[3] = tempVariable;
        showBooks(books);
        System.out.println("Вывод всего огромного количества книг с иминем \"Clean code\":");
        for (int i = 0; i < books.length; i++) {
            if ("Clean code".equals(books[i].getName())) {
                printOneBook(books[i]);
            }
        }
    }
}

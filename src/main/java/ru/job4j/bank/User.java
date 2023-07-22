package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает клиента банка.
 * @author alnesterenko
 * @version 1.0
 */
public class User {

    /**
     * Поле класса хранящее в себе номер паспорта в виде строки
     */
    private String passport;

    /**
     * Поле класса хранящее в себе имя(фамилию и отчество) юзверя
     */
    private String username;

    /**
     * Метод-конструктор принимает на вход номер паспорта и имя(фамилию и отчество) юзверя
     *
     * @param passport номер паспорта
     * @param username имя(фамилию и отчество) юзверя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод-геттер для номера паспорта
     *
     * @return возвращает номер паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод-сеттер для номера паспорта.
     *
     * @param passport устанавливает новый номер паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод-геттер для имени(фамилии и отчества) лузера
     *
     * @return возвращает имя(фамилию и отчество) лузера
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод-сеттер для имени(фамилии и отчества) лузера
     *
     * @param username устанавливает для лузера новые Ф.И.О.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод переопределяет способ сравнения юзверей.
     * Теперь юзвери будут сравниваться по номеру паспорта
     *
     * @param o объект, с которым мы будем сравнивать текущего юзверя
     * @return возвращает true, если объекты равны, если переданный в метод объект не равен null,
     *  если текущий юзверь и переданный в метод объект, имеют одинаковое название классов
     *  и имеют одинаковые номера паспортов
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод переопределяет с чего будет высчитываться хеш-код для текущего класса.
     * Метод необходим для правильного сравнения объектов данного класса.
     *
     * @return возвращает хеш-код, высчитанный на основании поля passport, в виде целого числа
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
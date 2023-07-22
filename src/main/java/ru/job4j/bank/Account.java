package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает аккаунт клиента банка.
 * @author alnesterenko
 * @version 1.0
 */
public class Account {

    /**
     * Поле класса хранящее в себе реквизиты(номер счёта)
     */
    private String requisite;

    /**
     * Поле класса хранящее в себе баланс на счету
     */
    private double balance;

    /**
     * Метод-конструктор принимает на вход реквизиты и баланс.
     *
     * @param requisite реквизиты(номер счёта)
     * @param balance баланс счёта
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод-геттер для реквизитов.
     *
     * @return возвращает реквизиты(номер счёта)
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод-сеттер для реквизитов.
     *
     * @param requisite устанавливает новые реквизиты(номер счёта)
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод-геттер для баланса.
     *
     * @return возвращает баланс на счету
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод-сеттер для реквизитов.
     *
     * @param balance устанавливает новый баланс
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод переопределяет способ сравнения аккаунтов.
     * Теперь аккаунты будут сравниваться по реквизитам
     *
     * @param o объект, с которым мы будем сравнивать текущий аккаунт
     * @return возвращает true, если объекты равны, если переданный в метод объект не равен null,
     *  если текущий аккаунт и переданный в метод объект, имеют одинаковое название классов
     *  и имеют одинаковые реквизиты
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод переопределяет с чего будет высчитываться хеш-код для текущего класса.
     * Метод необходим для правильного сравнения объектов данного класса.
     *
     * @return возвращает хеш-код, высчитанный на основании поля requisite, в виде целого числа
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
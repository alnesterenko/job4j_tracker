package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Класс описывает работу простейшего банковского сервиса.
 *
 * @author alnesterenko
 * @version 1.0
 */
public class BankService {

    /**
     * Создаётся мапа, которая будет хранить в себе всех пользователей банковского сервиса.
     * Ключ у неё -- это объект пользователя, а значение -- это список всех его аккаунтов.
     * Мапа типа HashMap.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового юзверя(с пустым списком аккаунтов) в мапу users
     *
     * @param user объект нового юзверя
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет юзверя из мапы users по номеру паспорта
     *
     * @param passport номер паспорта
     * @return возвращает true, если юзверь с таким номером паспорта был назден и удалён из мапы.
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод добавляет новый оккаунт юзверю.
     * Юзверь ищется по номеру паспорта. И если он найден и у него нет такого аккаунта(с такими реквизитами),
     * то этому юзверю добавляется новый аккаунт.
     *
     * @param passport номер паспорта
     * @param account  номер паспорта
     */
    public void addAccount(String passport, Account account) {
        User foundUser = findByPassport(passport);
        if (foundUser != null) {
            if (!users.get(foundUser).contains(account)) {
                users.get(foundUser).add(account);
            }
        }
    }

    /**
     * Метод ищет юзверя по паспорту.
     * Перебирается вся мапа с юзверями и у каждого номер паспорта сверяется с тем который ищут.
     *
     * @param passport номер паспорта
     * @return возвращает объект найденного юзверя
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(oneUser -> passport.equals(oneUser.getPassport()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод ищет аккаунт у юзверя.
     * Сперва находится конкретный юзверь по паспорту, а затем перебираются его аккаунты и сравниваются их реквизиты.
     *
     * @param passport  номер паспорта
     * @param requisite реквизиты счёта, который ищем
     * @return если нашли совпадение реквизитов -- возвращается объект аккаунта, если совпадения нет -- возвращается null
     */
    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User foundUser = findByPassport(passport);
        if (foundUser != null) {
            result = users.get(foundUser)
                    .stream()
                    .filter(oneAccount -> requisite.equals(oneAccount.getRequisite()))
                    .findFirst()
                    .orElse(null);
        }
        return result;
    }

    /**
     * Метод, который переводит деньги с одного счёта на другой.
     * Аккаунт списания и аккаунт назначения находятся по номеру паспорта и реквизитам.
     * В методе проверяется:
     * аккаунт списания существует,
     * баланс на аккаунте списания больше или равен списываемой сумме,
     * аккаунт назначения существует.
     * И только после этого с аккаунта списания списывается сумма, которая потом зачисляется на аккаунт назначения.
     *
     * @param srcPassport   номер паспорта юзверя, с аккаунта которого списываются деньги
     * @param srcRequisite  реквизиты счёта списания
     * @param destPassport  номер паспорта юзверя, которому на счёт зачисляются деньги
     * @param destRequisite реквизиты счёта назначения
     * @param amount        сумма перевода
     * @return возвращает true, если перевод прошёл успешно. False, если не успешно.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && srcAccount.getBalance() >= amount && destAccount != null) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод возвращает список аккаунтов одного юзверя
     *
     * @param user -- юзверь все аккаунты которого нужно найти.
     * @return возвращает список аккаунтов одного конкретного юзверя.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
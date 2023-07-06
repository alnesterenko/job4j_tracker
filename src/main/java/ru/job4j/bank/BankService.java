package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
            List<Account> emptyAccountList = new ArrayList<>();
            users.putIfAbsent(user, emptyAccountList);
    }

    public boolean deleteUser(String passport) {
        boolean result = false;
        User foundUser = findByPassport(passport);
        if (foundUser != null) {
            if (users.remove(foundUser) != null) {
                result = true;
            }
        }
        return result;
    }

    public void addAccount(String passport, Account account) {
        User foundUser = findByPassport(passport);
        if (foundUser != null) {
            if (!users.get(foundUser).contains(account)) {
                users.get(foundUser).add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User foundUser = null;
        for (User oneUser : users.keySet()) {
            if (passport.equals(oneUser.getPassport())) {
                foundUser = oneUser;
            }
        }
        return foundUser;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User foundUser = findByPassport(passport);
        if (foundUser != null) {
            List<Account> accounts = users.get(foundUser);
            for (Account oneAccount : accounts) {
                if (requisite.equals(oneAccount.getRequisite())) {
                    result = oneAccount;
                }
            }
        }
        return result;
    }

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

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
package services;


import dao.AccountDao;
import entities.Account;
import exceptions.AccountNumberNotExistException;
import exceptions.ValidationMessages;

public class PrintStatement implements Operation<String> {
    final AccountDao AccountDao;

    public PrintStatement(AccountDao AccountDao) {
        this.AccountDao = AccountDao;
    }

    @Override
    public void execute(String accountNumber) {
    }

    @Override
    public Account getAccount(String accountNumber) {
        return null;
    }

}
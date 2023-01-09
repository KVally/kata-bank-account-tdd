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
        var account = getAccount(accountNumber);
        System.out.println(account.printStatement());
    }

    @Override
    public Account getAccount(String accountNumber) {
        return AccountDao.findByAccountNumber(accountNumber)
                .orElseThrow(AccountNumberNotExistException::new);
    }

}
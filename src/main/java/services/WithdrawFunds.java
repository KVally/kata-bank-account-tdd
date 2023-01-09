package services;

import dao.AccountDao;
import dtos.OperationRequest;
import entities.Account;

public class WithdrawFunds implements Operation<OperationRequest> {
    final AccountDao accountDao;

    public WithdrawFunds(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void execute(OperationRequest operationRequest) {
    }

    @Override
    public Account getAccount(String accountNumber) {
        return null;
    }
}
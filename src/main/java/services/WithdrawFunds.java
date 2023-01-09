package services;

import dao.AccountDao;
import dtos.OperationRequest;
import entities.Account;
import exceptions.AccountNumberNotExistException;
import exceptions.OperationRequestFormatException;

public class WithdrawFunds implements Operation<OperationRequest> {
    final AccountDao accountDao;

    public WithdrawFunds(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void execute(OperationRequest operationRequest) {
        if (operationRequest == null || operationRequest.getAccountNumber() == null)
            throw new OperationRequestFormatException();

        var account = getAccount(operationRequest.getAccountNumber());
        account.withdrawal(operationRequest.getTransactionAmount());
    }

    @Override
    public Account getAccount(String accountNumber) {
        return accountDao.findByAccountNumber(accountNumber)
                .orElseThrow(AccountNumberNotExistException::new);
    }
}
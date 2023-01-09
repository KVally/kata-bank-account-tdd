package services;

import entities.Account;

public interface Operation<T> {
    void execute (T operationRequest);
    Account getAccount(String accountNumber);
}
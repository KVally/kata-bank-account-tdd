package dao;

import entities.Account;

import java.util.Optional;

public interface AccountDao {
    Optional<Account> findByAccountNumber(String accountNumber);

}

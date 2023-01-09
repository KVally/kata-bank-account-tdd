package dao;


import entities.Account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FakeAccountDao implements AccountDao{

    public List<Account> listAccountNumber(){
        List<Account>  listAccount = new ArrayList<>();
        listAccount.add(new Account("C01", BigDecimal.valueOf(10_000)));
        listAccount.add(new Account("C02"));
        listAccount.add(new Account("C03"));

        return listAccount;
    }

    @Override
    public Optional<Account> findByAccountNumber(String accountNumber) {
        return listAccountNumber()
                .stream()
                .filter(account1 -> account1.getAccountNumber().equals(accountNumber))
                .findFirst();
    }
}

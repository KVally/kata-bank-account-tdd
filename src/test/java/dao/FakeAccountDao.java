package dao;


import entities.Account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FakeAccountDao implements AccountDao{

    public List<Account> listAccountNumber(){
        List<Account>  listAccount = new ArrayList<>();

        var account = new Account("C01", BigDecimal.valueOf(10_000));
        BigDecimal depositAmount1 = BigDecimal.valueOf(10_000);
        account.deposit(depositAmount1);

        BigDecimal depositAmount2 = BigDecimal.valueOf(3_000);
        account.deposit(depositAmount2);

        BigDecimal withdrawAmount1 = BigDecimal.valueOf(2_000);
        account.withdrawal(withdrawAmount1);

        listAccount.add(account);
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

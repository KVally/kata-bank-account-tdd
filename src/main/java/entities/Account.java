package entities;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

public class Account {
    private final UUID id;
    private final String accountNumber;
    private BigDecimal balance;
    private LinkedHashSet<Transaction> transactions;

    public Account(String accountNumber,BigDecimal initialBalance) {
        this.id = UUID.randomUUID();
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        transactions = new LinkedHashSet<>();
    }

    public Account(String accountNumber) {
        this(accountNumber,BigDecimal.ZERO);
    }

    public void deposit(BigDecimal amount) {

    }

    public void withdrawal(BigDecimal amount) {
    }

    public String printStatement() {
        return "";
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }
}

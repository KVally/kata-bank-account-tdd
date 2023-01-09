package entities;

import exceptions.AmountFormatException;
import exceptions.InsufficientFundsException;

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
        checkAmountFormat(amount);

        var transaction = new Transaction(
                this.accountNumber,
                this.balance,
                amount,
                Transaction.TransactionType.DEPOSIT
        );
        transactions.add(transaction);
        balance = balance.add(amount);
    }

    public void withdrawal(BigDecimal amount) {
        checkAmountFormat(amount);
        if (this.balance.compareTo(amount)<0) {
            throw new InsufficientFundsException();
        }
        var transaction = new Transaction(
                this.accountNumber,
                this.balance,
                amount.negate(),
                Transaction.TransactionType.WITHDRAW
        );
        transactions.add(transaction);
        balance = balance.subtract(amount);
    }

    public void checkAmountFormat(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO)<0) {
            throw new AmountFormatException();
        }
    }

    public String printStatement() {
        StringBuilder statements = new StringBuilder(Transaction.HEADER);
        statements.append("\n");
        for (Transaction transaction:transactions)
            statements.append(transaction.printLine());
        return statements.toString();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }
}
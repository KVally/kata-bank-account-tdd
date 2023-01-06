package entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class Transaction {
    private final UUID id;
    private final String accountNumber;
    private final BigDecimal balanceBeforeTransaction;
    private final BigDecimal amount;
    private final Date date;
    private final TransactionType transactionType;
    public static final String HEADER = "date   |   amount  |   balance";

    public Transaction(String accountNumber, BigDecimal balanceBeforeTransaction, BigDecimal amount, TransactionType transactionType) {
        this.id=UUID.randomUUID();
        this.accountNumber = accountNumber;
        this.balanceBeforeTransaction = balanceBeforeTransaction;
        this.amount = amount;
        this.transactionType=transactionType;
        this.date = new Date();
    }

    public enum TransactionType {
        DEPOSIT,
        WITHDRAW
    }

    public String printLine (){
        StringBuilder line = new StringBuilder();
        line.append(this.date)
                .append("   |   ")
                .append(amount)
                .append("   |   ")
                .append(balanceBeforeTransaction.add(amount))
                .append("\n");
        return line.toString();
    }

}
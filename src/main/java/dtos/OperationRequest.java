package dtos;


import java.math.BigDecimal;

public class OperationRequest {
    private String accountNumber;
    private BigDecimal transactionAmount;

    public OperationRequest(String accountNumber, BigDecimal transactionAmount) {
        this.accountNumber = accountNumber;
        this.transactionAmount = transactionAmount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

}

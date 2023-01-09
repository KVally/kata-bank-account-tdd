package services;

import dao.AccountDao;
import dao.FakeAccountDao;
import dtos.OperationRequest;
import exceptions.AccountNumberNotExistException;
import exceptions.AmountFormatException;
import exceptions.OperationRequestFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DepositFundsTest {

    private DepositFunds depositFunds;

    @BeforeEach
    void setUp() {
        AccountDao AccountDao = new FakeAccountDao();
        this.depositFunds = new DepositFunds(AccountDao);
    }

    @Test
    void deposit() {
        BigDecimal amount = BigDecimal.valueOf(10_000);
        var operationRequest = new OperationRequest("C01",amount);
        assertDoesNotThrow(()->depositFunds.execute(operationRequest));
    }

    @Test
    void depositWithNullParameter() {
        assertThrows(OperationRequestFormatException.class,()->depositFunds.execute(null));
    }

    @Test
    void depositWithNullAccountNumber() {
        BigDecimal amount = BigDecimal.valueOf(10_000);
        var operationRequest = new OperationRequest(null,amount);
        assertThrows(OperationRequestFormatException.class,()->depositFunds.execute(operationRequest));
    }

    @Test
    void depositWithNullAmount() {
        var operationRequest = new OperationRequest("C01",null);
        assertThrows(AmountFormatException.class,()->depositFunds.execute(operationRequest));
    }

    @Test
    void depositWhenAccountNumberDoesNotExist() {
        BigDecimal amount = BigDecimal.valueOf(10_000);
        var operationRequest = new OperationRequest("C01Q",amount);
        assertThrows(AccountNumberNotExistException.class,()->depositFunds.execute(operationRequest));
    }
}
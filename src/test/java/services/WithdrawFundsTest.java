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

class WithdrawFundsTest {

    private WithdrawFunds withdrawFunds;

    @BeforeEach
    void setUp() {
        AccountDao AccountDao = new FakeAccountDao();
        this.withdrawFunds = new WithdrawFunds(AccountDao);
    }

    @Test
    void withdraw() {
        BigDecimal amount = BigDecimal.valueOf(10_000);
        var operationRequest = new OperationRequest("C01",amount);
        assertDoesNotThrow(()->withdrawFunds.execute(operationRequest));
    }

    @Test
    void withdrawWithNullParameter() {
        assertThrows(OperationRequestFormatException.class,()->withdrawFunds.execute(null));
    }

    @Test
    void withdrawWithNullAccountNumber() {
        BigDecimal amount = BigDecimal.valueOf(10_000);
        var operationRequest = new OperationRequest(null,amount);
        assertThrows(OperationRequestFormatException.class,()->withdrawFunds.execute(operationRequest));
    }

    @Test
    void withdrawWithNullAmount() {
        var operationRequest = new OperationRequest("C01",null);
        assertThrows(AmountFormatException.class,()->withdrawFunds.execute(operationRequest));
    }

    @Test
    void withdrawWhenAccountNumberDoesNotExist() {
        BigDecimal amount = BigDecimal.valueOf(10_000);
        var operationRequest = new OperationRequest("C01Q",amount);
        assertThrows(AccountNumberNotExistException.class,()->withdrawFunds.execute(operationRequest));
    }
}
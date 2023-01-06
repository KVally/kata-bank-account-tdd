package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    Account account;

    @BeforeEach
    void setUp() {
        account = new Account("C01");
    }

    @Test
    void deposit() {
        BigDecimal amount = BigDecimal.valueOf(10_000);
        account.deposit(amount);
        assertEquals(amount,account.getBalance());
    }

    @Test
    void depositWithInitialBalance() {
        BigDecimal initialBalance = BigDecimal.valueOf(10_000);

        account = new Account("CO2",initialBalance);
        BigDecimal amount = BigDecimal.valueOf(10_000);
        account.deposit(amount);

        BigDecimal amountExpected = BigDecimal.valueOf(20_000);
        assertEquals(amountExpected,account.getBalance());
    }

    @Test
    void depositWithNullParameter() {
        BigDecimal amount = null;
        assertThrows(Exception.class,()->account.deposit(amount));
    }

    @Test
    void withdrawal() {
        BigDecimal initialBalance = BigDecimal.valueOf(10_000);
        Account account = new Account("1000C",initialBalance);
        BigDecimal withdrawAmount = BigDecimal.valueOf(10_000);
        account.withdrawal(withdrawAmount);

        assertEquals(BigDecimal.ZERO,account.getBalance());
    }

    @Test
    void withdrawalWithNoBalance() {
        BigDecimal initialBalance = BigDecimal.valueOf(10_000);
        Account account = new Account("1000C",initialBalance);
        BigDecimal withdrawAmount = BigDecimal.valueOf(20_000);

        assertThrows(Exception.class,()->account.withdrawal(withdrawAmount));
    }

    @Test
    void withdrawalWithNullParameter() {
        BigDecimal amount = null;
        assertThrows(Exception.class,()->account.withdrawal(amount));
    }
}
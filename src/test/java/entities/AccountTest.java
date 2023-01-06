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


    @Test
    void checkTransactionWithEmptyOperation(){
        assertTrue(account.getTransactions().isEmpty());
    }

    @Test
    void checkTransactionWithOperations(){
        int nbTransactionExpected = 0;

        BigDecimal depositAmount1 = BigDecimal.valueOf(10_000);
        account.deposit(depositAmount1);
        nbTransactionExpected++;

        BigDecimal depositAmount2 = BigDecimal.valueOf(3_000);
        account.deposit(depositAmount2);
        nbTransactionExpected++;

        BigDecimal withdrawAmount1 = BigDecimal.valueOf(2_000);
        account.withdrawal(withdrawAmount1);
        nbTransactionExpected++;

        assertEquals(nbTransactionExpected,account.getTransactions().size());
    }

    @Test
    void printStatement() {
        BigDecimal amount = BigDecimal.valueOf(10_000);
        long nbLineExpected = 1; // For hearder

        account.deposit(amount);
        nbLineExpected++;

        account.withdrawal(amount);
        nbLineExpected++;

        account.deposit(amount);
        nbLineExpected++;

        System.out.println(account.printStatement());

        assertEquals(nbLineExpected,account.printStatement().lines().count());
    }

    @Test
    void checkManyOprerations(){
        long nbLineExpected = 1; // For hearder

        BigDecimal depositAmount1 = BigDecimal.valueOf(10_000);
        account.deposit(depositAmount1);
        nbLineExpected++;

        BigDecimal depositAmount2 = BigDecimal.valueOf(3_000);
        account.deposit(depositAmount2);
        nbLineExpected++;

        BigDecimal withdrawAmount1 = BigDecimal.valueOf(2_000);
        account.withdrawal(withdrawAmount1);
        nbLineExpected++;

        account.deposit(depositAmount1);
        nbLineExpected++;
        account.deposit(depositAmount2);
        nbLineExpected++;
        account.withdrawal(withdrawAmount1);
        nbLineExpected++;

        BigDecimal expectedBalance = BigDecimal.ZERO
                .add(depositAmount1)
                .add(depositAmount1)
                .add(depositAmount2)
                .add(depositAmount2)
                .subtract(withdrawAmount1)
                .subtract(withdrawAmount1);

        String statement = account.printStatement();
        System.out.println(statement);
        assertEquals(expectedBalance,account.getBalance());
        assertTrue( statement.contains(depositAmount1.toString()));
        assertTrue( statement.contains(depositAmount2.toString()));
        assertTrue( statement.contains(withdrawAmount1.toString()));
        assertEquals(nbLineExpected,account.printStatement().lines().count());
    }
}
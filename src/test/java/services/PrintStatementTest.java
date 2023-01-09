package services;

import dao.AccountDao;
import dao.FakeAccountDao;
import exceptions.AccountNumberNotExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PrintStatementTest {

    private PrintStatement printStatement;

    @BeforeEach
    void setUp() {
        AccountDao AccountDao = new FakeAccountDao();
        this.printStatement = new PrintStatement(AccountDao);
    }

    @Test
    void print() {
        assertDoesNotThrow(()->printStatement.execute("C01"));
    }

    @Test
    void printStatementWhenAccountNumberDoesNotExist() {
        assertThrows(AccountNumberNotExistException.class,()->printStatement.execute("C01Q"));
    }
}
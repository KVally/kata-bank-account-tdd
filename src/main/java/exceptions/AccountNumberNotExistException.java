package exceptions;

public class AccountNumberNotExistException extends RuntimeException{
    public AccountNumberNotExistException(String message) {
        super(message);
    }
}

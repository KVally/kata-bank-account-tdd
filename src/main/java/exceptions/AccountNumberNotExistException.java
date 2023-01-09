package exceptions;

public class AccountNumberNotExistException extends RuntimeException{
    public AccountNumberNotExistException() {
        super(ValidationMessages.ACCOUNT_NUMBER_NOT_EXIST);
    }
}

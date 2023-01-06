package exceptions;

public class InsufficientFundsException extends RuntimeException{
    public InsufficientFundsException() {
        super(ValidationMessages.INSUFFICIENT_FUNDS);
    }
}

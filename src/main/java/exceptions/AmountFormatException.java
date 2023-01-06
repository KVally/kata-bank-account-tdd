package exceptions;

public class AmountFormatException extends RuntimeException{
    public AmountFormatException() {
        super(ValidationMessages.AMOUNT_FORMAT_INCORRECT);
    }
}

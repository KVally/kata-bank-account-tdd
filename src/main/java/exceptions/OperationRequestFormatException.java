package exceptions;

public class OperationRequestFormatException extends RuntimeException{
    public OperationRequestFormatException() {
        super(ValidationMessages.OPERATION_REQUEST_FORMAT_INCORRECT);
    }
}

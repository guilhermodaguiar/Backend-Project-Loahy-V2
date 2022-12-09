package nl.novi.loahy.exceptions;

public class CustomerAlreadyExistException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public CustomerAlreadyExistException() {

        super();

    }

    public CustomerAlreadyExistException(String message) {

        super(message);

    }
}

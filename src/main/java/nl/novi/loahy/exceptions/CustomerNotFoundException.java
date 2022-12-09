package nl.novi.loahy.exceptions;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(Long CustomerId) {

        super(String.format("Order '%s' not found", CustomerId));
    }
}

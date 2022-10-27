package nl.novi.loahy.exceptions;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(Integer OrderId) {

        super(String.format("Order '%s' not found", OrderId));
    }
}

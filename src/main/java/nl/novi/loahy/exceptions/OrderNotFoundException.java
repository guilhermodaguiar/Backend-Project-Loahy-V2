package nl.novi.loahy.exceptions;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(Integer id) {

        super(String.format("Order '%s' not found", id));
    }
}

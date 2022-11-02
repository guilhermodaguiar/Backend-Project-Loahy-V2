package nl.novi.loahy.exceptions;

import java.io.Serial;

public class CustomerNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;


    public CustomerNotFoundException(Long customerId) {

        super(String.format("Customer with firstname'%s' does not exists", customerId));
    }
}

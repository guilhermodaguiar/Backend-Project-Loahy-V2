package nl.novi.loahy.exceptions;

import java.io.Serial;

public class ContactNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;


    public ContactNotFoundException(String contactName) {

        super(String.format("ContactRemark '%s' does not exists", contactName));
    }

}


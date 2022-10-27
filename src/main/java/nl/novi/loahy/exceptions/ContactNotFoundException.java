package nl.novi.loahy.exceptions;

public class ContactNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;


    public ContactNotFoundException(String contactName) {

        super(String.format("ContactRemark '%s' does not exists", contactName));
    }

}


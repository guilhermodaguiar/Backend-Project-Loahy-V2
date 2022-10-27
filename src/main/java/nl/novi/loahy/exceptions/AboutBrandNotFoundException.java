package nl.novi.loahy.exceptions;

public class AboutBrandNotFoundException extends RuntimeException{


    public AboutBrandNotFoundException(String brandTitle) {

        super(String.format("The brand title '%s' does not exists, and can't be updated", brandTitle));
    }

}

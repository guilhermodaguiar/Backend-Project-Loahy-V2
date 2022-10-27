package nl.novi.loahy.exceptions;

public class ShoppingCartNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ShoppingCartNotFoundException(Integer shoppincartId) {

        super(String.format("Product with Id '%s' does not exists", shoppincartId));
    }
}

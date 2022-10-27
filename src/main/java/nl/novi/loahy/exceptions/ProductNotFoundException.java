package nl.novi.loahy.exceptions;

public class ProductNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ProductNotFoundException(Integer productId) {

        super(String.format("Product with Id '%s' does not exists", productId));
    }
}

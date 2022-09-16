package nl.novi.loahy.controllers;

import nl.novi.loahy.service.ShoppingCartProductService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/shopping-cart-products")
public class ShoppingCartProductController {

    private final ShoppingCartProductService shoppingCartProductService;

    public ShoppingCartProductController(ShoppingCartProductService shoppingCartProductService) {
        this.shoppingCartProductService = shoppingCartProductService;
    }

    @PostMapping(value = "/{shoppingCartId}/{productId}")
    public void addWishlistProduct(@PathVariable("shoppingCartId") Integer shoppingCartId,
                                   @PathVariable("productId") Integer productId) {
        shoppingCartProductService.addShoppingCartProduct(shoppingCartId, productId);
    }
}

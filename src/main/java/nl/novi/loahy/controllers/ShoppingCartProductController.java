package nl.novi.loahy.controllers;

import nl.novi.loahy.services.ShoppingCartProductService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
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

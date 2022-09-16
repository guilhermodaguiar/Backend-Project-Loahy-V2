package nl.novi.loahy.controllers;

import nl.novi.loahy.dtos.ProductDto;
import nl.novi.loahy.dtos.ShoppingCartDto;
import nl.novi.loahy.dtos.ShoppingCartInputDto;
import nl.novi.loahy.service.ShoppingCartProductService;
import nl.novi.loahy.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/shopping-carts")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartProductService shoppingCartProductService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService, ShoppingCartProductService shoppingCartProductService) {
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartProductService = shoppingCartProductService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<ShoppingCartDto>> getAllShoppingCarts() {

        List<ShoppingCartDto> shoppingCartDto = shoppingCartService.getAllShoppingCarts();

        return ResponseEntity.ok().body(shoppingCartDto);
    }

    @PostMapping("")
    public ResponseEntity<ShoppingCartDto> createShoppingCart(@RequestBody ShoppingCartInputDto shoppingCartInputDto) {

        ShoppingCartDto shoppingCartDto = shoppingCartService.createShoppingCart(shoppingCartInputDto);

        return ResponseEntity.ok().body(shoppingCartDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateShoppingCart(@PathVariable("id") Integer shoppingCartId,
                                                      @RequestBody ShoppingCartInputDto shoppingCartInputDto) {

        ShoppingCartDto shoppingCartDto = shoppingCartService.updateShoppingCart(shoppingCartId, shoppingCartInputDto);

        return ResponseEntity.ok().body(shoppingCartDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteShoppingCart(@PathVariable("id") Integer shoppingCartId) {

        shoppingCartService.deleteShoppingCartById(shoppingCartId);

        return ResponseEntity.noContent().build();
    }


    @GetMapping("/products/{id}")
    public Collection<ProductDto> getProductsByShoppingCartId(@PathVariable("id") Integer shoppingCartId){
        return shoppingCartProductService.getShoppingCartProductsByShoppingCartId(shoppingCartId);
    }
}

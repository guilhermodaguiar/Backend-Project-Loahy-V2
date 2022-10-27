package nl.novi.loahy.services;

import nl.novi.loahy.dtos.ShoppingCartDto;
import nl.novi.loahy.dtos.ShoppingCartInputDto;
import nl.novi.loahy.exceptions.ShoppingCartNotFoundException;
import nl.novi.loahy.models.ShoppingCart;
import nl.novi.loahy.repositories.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartService {
    
    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public List<ShoppingCartDto> getAllShoppingCarts() {
        List<ShoppingCartDto> collection = new ArrayList<>();
        List<ShoppingCart> list = shoppingCartRepository.findAll();
        for (ShoppingCart shoppingCart : list) {
            collection.add(transferToDto(shoppingCart));
        }
        return collection;
    }

    public ShoppingCartDto createShoppingCart(ShoppingCartInputDto shoppingCartInputDto) {

        ShoppingCart shoppingCart = transferToShoppingCart(shoppingCartInputDto);
        shoppingCartRepository.save(shoppingCart);

        return transferToDto(shoppingCart);
    }

    public ShoppingCartDto updateShoppingCart(Integer shoppingCartId, ShoppingCartInputDto shoppingCartInputDto) {
        if (shoppingCartRepository.findById(shoppingCartId).isPresent()) {

            ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCartId).get();

            ShoppingCart shoppingCart1 = transferToShoppingCart(shoppingCartInputDto);
            shoppingCart1.setShoppingCartId(shoppingCart.getShoppingCartId());

            shoppingCartRepository.save(shoppingCart1);

            return transferToDto(shoppingCart1);
        } else {
            throw new ShoppingCartNotFoundException(shoppingCartId);
        }
    }

    public void deleteShoppingCartById( Integer shoppingCartId) {

        shoppingCartRepository.deleteById(shoppingCartId);
    }


    public ShoppingCartDto transferToDto(ShoppingCart shoppingCart) {

        var shoppingCartDto = new ShoppingCartDto();

        shoppingCartDto.shoppingCartId = shoppingCart.getShoppingCartId();
        ;

        return shoppingCartDto;
    }

    public ShoppingCart transferToShoppingCart(ShoppingCartInputDto shoppingCartInputDto) {

        var shoppingCart = new ShoppingCart();

        shoppingCart.setShoppingCartId(shoppingCartInputDto.getShoppingCartId());
        return shoppingCart;
    }
}

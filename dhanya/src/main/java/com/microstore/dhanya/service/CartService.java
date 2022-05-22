package com.microstore.dhanya.service;

import com.microstore.dhanya.DTO.AllCartItemsResponseDTO;
import com.microstore.dhanya.DTO.CartItemDTO;
import com.microstore.dhanya.model.CartItem;
import com.microstore.dhanya.model.Product;
import com.microstore.dhanya.model.User;
import com.microstore.dhanya.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    CartItemRepository repository;

    @Autowired
    ProductService productService;

    // add to cart
    public void addItemToCart(Product product, User user, Integer quantity)
    {
        CartItem cartItem = new CartItem(user,product,quantity);
        repository.save(cartItem);
    }

    // update quantity of item in cart
    public void updateItemInCart(Product product, User user, Integer quantity)
    {
        CartItem cartItem = repository.findByUserAndProduct(user,product);
        cartItem.setQuantity(quantity);
        repository.save(cartItem);
    }

    // delete an item from the cart
    public void deleteItemInCart(Product product, User user)
    {
        repository.deleteByUserAndProduct(user, product);
    }

    // list all items in cart
    public AllCartItemsResponseDTO listAllCartItems(User user)
    {
        List<CartItem> cartItemsList = repository.findAllByUserOrderByQuantity(user);

        int totalPrice = 0;

        List<CartItemDTO> cartItemDTOList = new ArrayList<>();

        for(CartItem cartItem : cartItemsList)
        {
            Product product = cartItem.getProduct();
            int price = product.getPrice();
            totalPrice += (price * cartItem.getQuantity());

            CartItemDTO cartItemDTO = new CartItemDTO(product.getName(),product.getPrice(),cartItem.getQuantity());

            cartItemDTOList.add(cartItemDTO);
        }

        return new AllCartItemsResponseDTO(cartItemDTOList, totalPrice);
    }


}

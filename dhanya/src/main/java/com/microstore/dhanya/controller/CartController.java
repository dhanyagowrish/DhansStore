package com.microstore.dhanya.controller;

import com.microstore.dhanya.DTO.AddItemToCartRequestDTO;
import com.microstore.dhanya.DTO.AllCartItemsResponseDTO;
import com.microstore.dhanya.DTO.DeleteItemFromCartRequestDTO;
import com.microstore.dhanya.Message.AuthenticationMessage;
import com.microstore.dhanya.Message.CartMessage;
import com.microstore.dhanya.model.CartItem;
import com.microstore.dhanya.model.Product;
import com.microstore.dhanya.model.User;
import com.microstore.dhanya.repository.CartItemRepository;
import com.microstore.dhanya.repository.ProductRepository;
import com.microstore.dhanya.response.StandardResponse;
import com.microstore.dhanya.service.CartService;
import com.microstore.dhanya.service.ProductService;
import com.microstore.dhanya.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    // add a new item to the cart
    @PostMapping("/add")
    public ResponseEntity<StandardResponse> addToCart(@RequestBody AddItemToCartRequestDTO addItemToCartRequestDTO)
    {
        // authenticate token
        String token = addItemToCartRequestDTO.getToken();
        Integer authStatus = tokenService.authenticateToken(token);

        if(authStatus == 2)
        {
            return new ResponseEntity<StandardResponse>(new StandardResponse("failed", AuthenticationMessage.AUTH_FAILED_INVALID_TOKEN), HttpStatus.UNAUTHORIZED);
        }

        if(authStatus == 3)
        {
            return new ResponseEntity<StandardResponse>(new StandardResponse("failed", AuthenticationMessage.AUTH_FAILED_EXPIRED_TOKEN), HttpStatus.UNAUTHORIZED);
        }

        User user = tokenService.findUserFromToken(token);
        Product product = productService.getProductById(addItemToCartRequestDTO.getProductId());
        //System.out.println(product.getId());
        //System.out.println(user.getEmail());
        //System.out.println(addItemToCartRequestDTO.getQuantity());

        cartService.addItemToCart(product,user, addItemToCartRequestDTO.getQuantity());

        return new ResponseEntity<StandardResponse>(new StandardResponse("success", CartMessage.SUCCESS_ITEM_ADD), HttpStatus.OK);

    }

    @PostMapping("/update")
    public ResponseEntity<StandardResponse> updateCartItem(@RequestBody AddItemToCartRequestDTO addItemToCartRequestDTO)
    {
        // authenticate token
        String token = addItemToCartRequestDTO.getToken();
        Integer authStatus = tokenService.authenticateToken(token);

        if(authStatus == 2)
        {
            return new ResponseEntity<StandardResponse>(new StandardResponse("failed", AuthenticationMessage.AUTH_FAILED_INVALID_TOKEN), HttpStatus.UNAUTHORIZED);
        }

        if(authStatus == 3)
        {
            return new ResponseEntity<StandardResponse>(new StandardResponse("failed", AuthenticationMessage.AUTH_FAILED_EXPIRED_TOKEN), HttpStatus.UNAUTHORIZED);
        }

        User user = tokenService.findUserFromToken(token);
        Product product = productService.getProductById(addItemToCartRequestDTO.getProductId());

        cartService.updateItemInCart(product, user, addItemToCartRequestDTO.getQuantity());

        return new ResponseEntity<StandardResponse>(new StandardResponse("success",CartMessage.SUCCESS_ITEM_QUANTITY_UPDATE), HttpStatus.OK);

    }

    // delete item from cart
    @Transactional
    @DeleteMapping("/delete")
    public ResponseEntity<StandardResponse> deleteCartItem(@RequestBody DeleteItemFromCartRequestDTO deleteItemFromCartRequestDTO)
    {

        // authenticate token
        String token = deleteItemFromCartRequestDTO.getToken();
        Integer authStatus = tokenService.authenticateToken(token);

        if(authStatus == 2)
        {
            return new ResponseEntity<StandardResponse>(new StandardResponse("failed", AuthenticationMessage.AUTH_FAILED_INVALID_TOKEN), HttpStatus.UNAUTHORIZED);
        }

        if(authStatus == 3)
        {
            return new ResponseEntity<StandardResponse>(new StandardResponse("failed", AuthenticationMessage.AUTH_FAILED_EXPIRED_TOKEN), HttpStatus.UNAUTHORIZED);
        }

        User user = tokenService.findUserFromToken(token);
        Product product = productService.getProductById(deleteItemFromCartRequestDTO.getProductId());

        cartService.deleteItemInCart(product, user);

        return new ResponseEntity<StandardResponse>(new StandardResponse("success",CartMessage.SUCCESS_ITEM_QUANTITY_UPDATE), HttpStatus.OK);


    }


    @GetMapping("/")
    public ResponseEntity<AllCartItemsResponseDTO> listAllCartItems(@RequestBody String token)
    {

        // authenticate token
        System.out.println(token);

        Integer authStatus = tokenService.authenticateToken(token);



        if(authStatus == 2)
        {
            return new ResponseEntity<AllCartItemsResponseDTO>(new AllCartItemsResponseDTO(null, -1), HttpStatus.UNAUTHORIZED);
        }

        if(authStatus == 3)
        {
            return new ResponseEntity<AllCartItemsResponseDTO>(new AllCartItemsResponseDTO(null, -1), HttpStatus.UNAUTHORIZED);
        }

        User user = tokenService.findUserFromToken(token);

        AllCartItemsResponseDTO allCartItemsResponseDTO = cartService.listAllCartItems(user);

        return new ResponseEntity<AllCartItemsResponseDTO>(allCartItemsResponseDTO, HttpStatus.OK);



    }







}

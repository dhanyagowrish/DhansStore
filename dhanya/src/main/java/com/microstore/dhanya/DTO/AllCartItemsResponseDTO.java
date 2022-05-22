package com.microstore.dhanya.DTO;

import java.util.List;

public class AllCartItemsResponseDTO {

    private List<CartItemDTO> cartItemDTOList;
    private Integer totalCartCost;

    public AllCartItemsResponseDTO(List<CartItemDTO> cartItemDTOList, Integer totalCartCost) {
        this.cartItemDTOList = cartItemDTOList;
        this.totalCartCost = totalCartCost;
    }

    public List<CartItemDTO> getCartItemDTOList() {
        return cartItemDTOList;
    }

    public void setCartItemDTOList(List<CartItemDTO> cartItemDTOList) {
        this.cartItemDTOList = cartItemDTOList;
    }

    public Integer getTotalCartCost() {
        return totalCartCost;
    }

    public void setTotalCartCost(Integer totalCartCost) {
        this.totalCartCost = totalCartCost;
    }
}

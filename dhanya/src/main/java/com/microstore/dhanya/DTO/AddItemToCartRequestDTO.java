package com.microstore.dhanya.DTO;

public class AddItemToCartRequestDTO {

    private String token;   // for user authentication
    private Integer productId;
    private Integer quantity;

    public AddItemToCartRequestDTO(String token, Integer productId, Integer quantity) {
        this.token = token;
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

package com.microstore.dhanya.DTO;

public class DeleteItemFromCartRequestDTO {

    private String token;
    private Integer productId;

    public DeleteItemFromCartRequestDTO(String token, Integer productId) {
        this.token = token;
        this.productId = productId;
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
}

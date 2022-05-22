package com.microstore.dhanya.DTO;

public class LoginResponseDTO {

    private String status;
    private String message;
    private String token;

    public LoginResponseDTO(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public LoginResponseDTO(String status, String message, String token) {
        this.status = status;
        this.message = message;
        this.token = token;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

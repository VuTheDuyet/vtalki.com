package com.vtalki.vtalki_backend.dto;

public class LoginResponse {
    private String email;
    private String chatboxLink;
    private String password;

    public LoginResponse() {
    }

    public LoginResponse(String email, String chatboxLink, String password) {
        this.email = email;
        this.chatboxLink = chatboxLink;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChatboxLink() {
        return chatboxLink;
    }

    public void setChatboxLink(String chatboxLink) {
        this.chatboxLink = chatboxLink;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

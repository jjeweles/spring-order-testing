package com.galvanize.datavalidation.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginModel {

    @NotNull(message = "Username is required")
    @Size(min = 5, max = 20, message = "Username must be between 5 and 20 characters")
    private String username;

    @NotNull(message = "Password is required")
    @Size(min = 5, max = 20, message = "Password must be between 5 and 20 characters")
    private String password;

    public LoginModel() {
        super();
    }

    public LoginModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

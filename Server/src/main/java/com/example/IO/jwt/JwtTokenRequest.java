package com.example.IO.jwt;

import java.io.Serializable;

public class  JwtTokenRequest implements Serializable {
  
  private static final long serialVersionUID = -5616176897013108345L;

    private String username;
    private String password;
    private boolean rememberMe; 

    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password, boolean rememberMe) {
        this.setUsername(username);
        this.setPassword(password);
        this.setRememberMe(rememberMe);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getRememberMe() {
        return this.rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}


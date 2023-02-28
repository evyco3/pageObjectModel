package com.evy.enums;

public enum NavBarType {
    LOGIN("Login"),
    SIGNUP("Sign Up");

    private final String name;

    public String getName() {
        return name;
    }

    NavBarType(String name) {
        this.name = name;
    }


}



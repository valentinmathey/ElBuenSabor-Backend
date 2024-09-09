package com.elbuensabor.apirest.Enums;

public enum Role {
    ADMIN("admin"),
    EMPLOYEE("employee"),
    CLIENT("client");

    private String value;

    Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}


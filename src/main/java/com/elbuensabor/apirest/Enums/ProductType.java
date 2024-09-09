package com.elbuensabor.apirest.Enums;

public enum ProductType {
    MANUFACTURED("manufactured"),
    SUPPLY("supply");

    private String value;

    ProductType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}


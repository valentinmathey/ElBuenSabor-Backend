package com.elbuensabor.apirest.Enums;

public enum OrderStatus {
    PREPARATION("preparation"),
    PENDING("pending"),
    CANCELED("canceled"),
    REJECTED("rejected"),
    DELIVERED("delivered");

    private String value;

    OrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}



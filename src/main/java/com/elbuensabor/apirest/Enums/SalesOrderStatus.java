package com.elbuensabor.apirest.Enums;

public enum SalesOrderStatus {
    PREPARATION("preparation"),
    PENDING("pending"),
    CANCELED("canceled"),
    REJECTED("rejected"),
    DELIVERED("delivered");

    private String value;

    SalesOrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}



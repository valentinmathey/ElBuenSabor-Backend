package com.elbuensabor.apirest.Enums;

public enum RequestStatus {
    PREPARATION("preparation"),
    PENDING("pending"),
    CANCELED("canceled"),
    REJECTED("rejected"),
    DELIVERED("delivered");

    private String value;

    RequestStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}



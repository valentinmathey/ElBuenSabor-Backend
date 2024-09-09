package com.elbuensabor.apirest.Enums;

public enum DeliveryType {
    DELIVERY("delivery"),
    TAKEAWAY("takeaway");

    private String value;

    DeliveryType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}



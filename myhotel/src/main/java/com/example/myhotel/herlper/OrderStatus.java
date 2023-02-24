package com.example.myhotel.herlper;

public enum OrderStatus {

    OPEN("Open"),
    BILL("Billing"),
    CLOSE("Closed");

    private final String displayValue;

    private OrderStatus(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return this.displayValue;
    }
}

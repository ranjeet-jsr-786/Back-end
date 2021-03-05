package com.cloudaidatastream.shoppingmart.enums;

public enum PaymentStatus {

	PAID("PAID"), PENDING("PENDING"), ADVANCE_PAID("ADVANCE_PAID"), PARTIAL_PAID("PARTIAL_PAID");
    private String status;

    PaymentStatus(String status){
        this.status = status;
    }
}

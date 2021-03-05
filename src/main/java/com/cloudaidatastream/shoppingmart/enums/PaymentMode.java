package com.cloudaidatastream.shoppingmart.enums;

public enum PaymentMode {
	CASH("CASH"), CHEQUE("CHEQUE"), DEBIT_CARD("DEBIT_CARD"), CREDIT_CARD("CREDIT_CARD"), NET_BANKING("NET_BANKING"), OTHERS("OTHERS");
    private String status;

    PaymentMode(String status) {
        this.status = status;
    }
}

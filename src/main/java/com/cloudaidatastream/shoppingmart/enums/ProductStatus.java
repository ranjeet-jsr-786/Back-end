package com.cloudaidatastream.shoppingmart.enums;


public enum ProductStatus {

    Ordered("Ordered"),Cancelled("Cancelled"),Delivered("Delivered");

    private String status;

    ProductStatus(String status){
        this.status = status;
    }

}

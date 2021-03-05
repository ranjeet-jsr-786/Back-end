package com.cloudaidatastream.shoppingmart.enums;

public enum Status {

	In_progress("In-progress"), Failed("Failed"), Success("Success");
    private String status;

    Status(String status){
        this.status = status;
    }

}

package com.cloudaidatastream.shoppingmart.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Hi on 02-02-2018.
 */
//@Setter
//@Getter
public class SuccessResponseDTO {

    private String message;

    public SuccessResponseDTO(String message) {
        this.message = message;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

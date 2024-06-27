package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.util.Objects;

public class ResponseClass {
    private String message;

    public ResponseClass(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
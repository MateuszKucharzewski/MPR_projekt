package com.example.mpr_project_front.exception;

public class BiletNotFoundException extends RuntimeException {
    public BiletNotFoundException() {
        super("Bilet not found!");
    }
}

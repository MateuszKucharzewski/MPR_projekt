package com.example.mpr_project_back.exception;

public class BiletNotFoundException extends RuntimeException {
    public BiletNotFoundException() {
        super("Bilet not found!");
    }
}
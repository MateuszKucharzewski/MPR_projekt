package com.example.mpr_project_front.exception;

public class BiletExist extends RuntimeException {
    public BiletExist() {
        super("Bilet istnieje");
    }
}


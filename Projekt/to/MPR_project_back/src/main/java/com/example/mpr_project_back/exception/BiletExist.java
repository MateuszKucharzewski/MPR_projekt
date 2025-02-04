package com.example.mpr_project_back.exception;


public class BiletExist extends RuntimeException {
    public BiletExist() {
        super("Bilet istnieje");
    }
}

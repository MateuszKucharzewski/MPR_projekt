package com.example.mpr_project_front.model;

public class Bilets {

    private Long id;
    private String nameP;
    private String miejsceWylotu;
    private String miejscePrzylotu;
    private String numerSiedzenia;

    public Bilets(String nameP, String miejsceWylotu, String miejscePrzylotu, String numerSiedzenia) {
        this.nameP = nameP;
        this.miejsceWylotu = miejsceWylotu;
        this.miejscePrzylotu = miejscePrzylotu;
        this.numerSiedzenia = numerSiedzenia;
    }

    public Bilets(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public String getMiejsceWylotu() {
        return miejsceWylotu;
    }

    public void setMiejsceWylotu(String miejsceWylotu) {
        this.miejsceWylotu = miejsceWylotu;
    }

    public String getMiejscePrzylotu() {
        return miejscePrzylotu;
    }

    public void setMiejscePrzylotu(String miejscePrzylotu) {
        this.miejscePrzylotu = miejscePrzylotu;
    }

    public String getNumerSiedzenia() {
        return numerSiedzenia;
    }

    public void setNumerSiedzenia(String numerSiedzenia) {
        this.numerSiedzenia = numerSiedzenia;
    }
}

package com.example.inf303;


public class Yemek {

    private int ID;
    private int KALORI;
    private String NAME, TYPE;


    public Yemek(String NAME, String TYPE, int KALORI) {
        this.NAME = NAME;
        this.TYPE = TYPE;
        this.KALORI = KALORI;
    }

    public Yemek() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public int getKALORI() {
        return KALORI;
    }

    public void setKALORI(int KALORI) {
        this.KALORI = KALORI;
    }
}


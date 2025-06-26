package com.example.extra_task;

public class CatatanKesehatan {
    private String tanggal;
    private double beratBadan;
    private String tekananDarah;
    private String catatan;

    public CatatanKesehatan(String tanggal, double beratBadan, String tekananDarah, String catatan) {
        this.tanggal = tanggal;
        this.beratBadan = beratBadan;
        this.tekananDarah = tekananDarah;
        this.catatan = catatan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public double getBeratBadan() {
        return beratBadan;
    }

    public void setBeratBadan(double beratBadan) {
        this.beratBadan = beratBadan;
    }

    public String getTekananDarah() {
        return tekananDarah;
    }

    public void setTekananDarah(String tekananDarah) {
        this.tekananDarah = tekananDarah;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }
}


package com.tram.way.rabat.Activities;

public class StationData {
    int id;
    int idref;
    String nom;
    String locali;
    String noville;

    public StationData()
    {}

    public StationData(int id, int idref, String nom, String locali, String noville) {
        this.id = id;
        this.idref = idref;
        this.nom = nom;
        this.locali = locali;
        this.noville = noville;
    }

    public StationData(String nom)
    {
        this.nom=nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdref() {
        return idref;
    }

    public void setIdref(int idref) {
        this.idref = idref;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLocali() {
        return locali;
    }

    public void setLocali(String locali) {
        this.locali = locali;
    }

    public String getNoville() {
        return noville;
    }

    public void setNoville(String noville) {
        this.noville = noville;
    }

    public String toString()
    {
        return nom;
    }
}

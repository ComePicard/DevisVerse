package com.example.devisverse;

import java.util.concurrent.atomic.AtomicInteger;

public class Entreprise {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int idEntreprise;
    private String raisonSociale;
    private String adresse;
    private String domaine;


    public Entreprise(String raisonSociale, String adresse, String domaine){
        this.raisonSociale = raisonSociale;
        this.adresse = adresse;
        this.domaine = domaine;
        this.idEntreprise = count.incrementAndGet();
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    @Override
    public String toString() {
        return "Entreprise{" +
                "idEntreprise=" + idEntreprise +
                ", raisonSociale='" + raisonSociale + '\'' +
                ", adresse='" + adresse + '\'' +
                ", domaine='" + domaine + '\'' +
                '}';
    }

    public int getIdEntreprise() {
        return idEntreprise;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }
}

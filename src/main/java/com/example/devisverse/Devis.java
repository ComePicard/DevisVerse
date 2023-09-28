package com.example.devisverse;

import java.util.concurrent.atomic.AtomicInteger;

public class Devis {
    static final double TVA = 1.015;

    private static final AtomicInteger count = new AtomicInteger(0);
    private final int idDevis;
    private String titre;
    private Entreprise entreprise;
    private double prix;
    private String detail;
    private boolean signe; // un devis signé devient une facture

    public Devis(String titre, String detail, Entreprise entreprise, double prix){
        this.titre = titre;
        this.detail = detail;
        this.entreprise = entreprise;
        this.idDevis = count.incrementAndGet();
        this.prix = calculerPrix(prix);
        this.signe = false;
    }

    public double calculerPrix(double prix){
        return prix * TVA;
    }

    public void signer() {
        this.signe = true;
    }


    public Devis genererFacture(){
        this.signe = true;
        return this;
    }


    public int getIdDevis() {
        return idDevis;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public double getPrix() {
        return prix;
    }

    @Override
    public String toString() {
        return "Devis{" +
                "idDevis=" + idDevis +
                ", titre='" + titre + '\'' +
                ", entrepriseFacture=" + entreprise +
                ", prix=" + prix +
                ", detail='" + detail + '\'' +
                '}';
    }
}


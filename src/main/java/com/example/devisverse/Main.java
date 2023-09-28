package com.example.devisverse;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Entreprise> listeEntreprise = new ArrayList<Entreprise>();
        listeEntreprise.add(new Entreprise("Conforama", "1 rue des papillons", "mobilier"));
        ArrayList<Devis> listeDevis = new ArrayList<Devis>();
        Entreprise selectedEntreprise = null;
        Devis selectedDevis = null;
        boolean quitter = false;
        System.out.println("Bienvenu dans le Devis Verse");
        while (!quitter){
            if(selectedEntreprise != null ) {
                System.out.println("Vous avez sélectionné l'entreprise " + selectedEntreprise.getRaisonSociale());
            }
            System.out.println("Que souhaitez vous faire ?\n" +
                    "1- Renseigner une entreprise\n" +
                    "2- Sélectionner une entreprise\n" +
                    "3- Créer un devis\n" +
                    "4- Sélectionner un devis\n" +
                    "5- Quitter.");
            int choix = sc.nextInt();
            if (choix == 1) {
                System.out.println("Renseignez la raison sociale de l'entreprise: ");
                String raisonSociale = sc.next();
                System.out.println("Renseignez l'adresse de l'entreprise: ");
                String adresse = sc.next();
                System.out.println("Renseignez le domaine de l'entreprise: ");
                String domaine = sc.next();
                Entreprise entreprise = new Entreprise(raisonSociale, adresse, domaine);
                listeEntreprise.add(entreprise);
            }
            if (choix == 2) {
                if (listeEntreprise.isEmpty()) {
                    System.out.println("Aucune entreprise présente");
                } else {
                    int index = 0;
                    System.out.println("Renseigner le numéro de l'entreprise ");
                    for (Entreprise entreprise : listeEntreprise) {
                        index++;
                        System.out.println(index + "- " + entreprise.getRaisonSociale());
                    }
                    int selection = sc.nextInt();
                    selectedEntreprise = listeEntreprise.get(selection - 1);
                }
            }
            if (choix == 3) {
                if (selectedEntreprise == null) {
                    System.out.println("Veuillez séléectionner une entreprise avant de créer une devis");
                } else {
                    System.out.println("Donner un titre au devis :");
                    String titre = sc.next();
                    System.out.println("Renseignez le domaine du devis :");
                    String domaine = sc.next();
                    System.out.println("Renseignez le prix du devis avant tax :");
                    double prix = sc.nextDouble();
                    Devis devis = new Devis(titre, domaine, selectedEntreprise, prix);
                    listeDevis.add(devis);
                }
            }

            if (choix == 4) {
                if (listeDevis.isEmpty()) {
                    System.out.println("Aucun devis présent");
                } else {
                    int index = 0;
                    System.out.println("Renseigner le numéro du devis ");
                    for (Devis devis : listeDevis) {
                        index++;
                        System.out.println(index + "- " + devis.getTitre());
                    }
                    int selection = sc.nextInt();
                    selectedDevis = listeDevis.get(selection - 1);

                    System.out.println("Quelle action souhaitez-vous effectuez ?\n" +
                            "1- Visionner le devis\n" +
                            "2- Signer le devis (deviens une facture)\n" +
                            "3- Supprimer le devis");
                    int choixDevis = sc.nextInt();

                    if (choixDevis == 1) {
                        System.out.println(selectedDevis.toString());
                    }
                    if (choixDevis == 2) {
                        selectedDevis.signer();
                    }
                    if (choixDevis == 3) {
                        listeDevis.remove(selection - 1);
                    }
                }
            }
            if (choix == 5) quitter = true;
        }
        System.out.println("Nous vous remercions d'avoir utilisé le Devis Verse");
        sc.close();
    }
}

package com.example.devisverse;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DevisApp extends Application {
    private final ObservableList<Entreprise> entreprises = FXCollections.observableArrayList();
    private ListView<Entreprise> entrepriseListView;
    private Button ajouterEntrepriseButton;
    private Button creerDevisButton;
    private Stage primaryStage;
    private TextField titreField;
    private TextField domaineField;
    private TextField prixField;
    private ComboBox<String> entrepriseComboBox;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        primaryStage.setTitle("Gestion des Devis");


        entrepriseListView = new ListView<>(entreprises);
        ajouterEntrepriseButton = new Button("Ajouter Entreprise");
        creerDevisButton = new Button("Créer Devis");
        titreField = new TextField();
        domaineField = new TextField();
        prixField = new TextField();
        entrepriseComboBox = new ComboBox<>();


        VBox vboxDevis = new VBox(10);
        vboxDevis.getChildren().addAll(ajouterEntrepriseButton, entrepriseListView, creerDevisButton, new Label("Titre du Devis:"), titreField, new Label("Domaine du Devis:"), domaineField, new Label("Prix du Devis:"), prixField, new Label("Entreprise associée:"), entrepriseComboBox);

        ajouterEntrepriseButton.setOnAction(event -> {
            primaryStage.setScene(createEntrepriseScene());
        });

        creerDevisButton.setOnAction(event -> {
            creerDevis();
        });

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(ajouterEntrepriseButton, entrepriseListView, creerDevisButton);

        Scene scene = new Scene(vbox, 800, 600);
        primaryStage.setScene(scene);

        primaryStage.show();
    }


    private Scene createEntrepriseScene() {
        VBox formulaireEntreprise = new VBox(10);
        Label labelRaisonSociale = new Label("Raison Sociale:");
        TextField champRaisonSociale = new TextField();
        Label labelAdresse = new Label("Adresse:");
        TextField champAdresse = new TextField();
        Label labelDomaine = new Label("Domaine:");
        TextField champDomaine = new TextField();
        Button sauvegarderEntrepriseButton = new Button("Sauvegarder");


        sauvegarderEntrepriseButton.setOnAction(event -> {


            String raisonSociale = champRaisonSociale.getText();
            String adresse = champAdresse.getText();
            String domaine = champDomaine.getText();

            Entreprise nouvelleEntreprise = new Entreprise(raisonSociale, adresse, domaine);
            entreprises.add(nouvelleEntreprise);


            primaryStage.setScene(entrepriseListView.getScene());
        });

        formulaireEntreprise.getChildren().addAll(labelRaisonSociale, champRaisonSociale, labelAdresse, champAdresse, labelDomaine, champDomaine, sauvegarderEntrepriseButton);

        return new Scene(formulaireEntreprise, 400, 300);
    }

    private Entreprise trouverEntrepriseParRaisonSociale(String raisonSociale) {
        for (Entreprise entreprise : entreprises) {
            if (entreprise.getRaisonSociale().equals(raisonSociale)) {
                return entreprise;
            }
        }
        return null;
    }


    private void creerDevis() {
        String titre = titreField.getText();
        String domaine = domaineField.getText();
        double prix = Double.parseDouble(prixField.getText());
        String raisonSociale = entrepriseComboBox.getValue();
        Entreprise selectedEntreprise = trouverEntrepriseParRaisonSociale(raisonSociale);

        if (selectedEntreprise != null) {
            Devis nouvelDevis = new Devis(titre, domaine, selectedEntreprise, prix);
        }


        titreField.clear();
        domaineField.clear();
        prixField.clear();
        entrepriseComboBox.getSelectionModel().clearSelection();
    }


}

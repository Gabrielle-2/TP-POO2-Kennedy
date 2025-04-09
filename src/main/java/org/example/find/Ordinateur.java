package org.example.find;

public class Ordinateur extends Appareil {
    private String marque;
    private String modele;
    private Integer Stockage;
    private String systemeExploitation;
    private Integer capaciteRam;  // en Go
    private Integer capaciteDisqueDur;  // en Go
    private String processeur;
    private boolean estPortable;
    private double tailleEcran;  // en pouces
    private String carteGraphique;

    // Constructeur
    public Ordinateur(String nom,Integer Stockage, String marque, String modele,
                      String systemeExploitation, int capaciteRam, int capaciteDisqueDur,
                      String processeur, boolean estPortable, double tailleEcran, String carteGraphique) {
        super(nom );
        this.Stockage = Stockage;
        this.marque = marque;
        this.modele = modele;
        this.systemeExploitation = systemeExploitation;
        this.capaciteRam = capaciteRam;
        this.capaciteDisqueDur = capaciteDisqueDur;
        this.processeur = processeur;
        this.estPortable = estPortable;
        this.tailleEcran = tailleEcran;
        this.carteGraphique = carteGraphique;
    }

    // Getters et Setters
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getSystemeExploitation() {
        return systemeExploitation;
    }

    public void setSystemeExploitation(String systemeExploitation) {
        this.systemeExploitation = systemeExploitation;
    }

    public int getCapaciteRam() {
        return capaciteRam;
    }

    public void setCapaciteRam(int capaciteRam) {
        this.capaciteRam = capaciteRam;
    }

    public int getCapaciteDisqueDur() {
        return capaciteDisqueDur;
    }

    public void setCapaciteDisqueDur(int capaciteDisqueDur) {
        this.capaciteDisqueDur = capaciteDisqueDur;
    }

    public String getProcesseur() {
        return processeur;
    }

    public void setProcesseur(String processeur) {
        this.processeur = processeur;
    }

    public boolean isEstPortable() {
        return estPortable;
    }

    public void setEstPortable(boolean estPortable) {
        this.estPortable = estPortable;
    }

    public double getTailleEcran() {
        return tailleEcran;
    }

    public void setTailleEcran(double tailleEcran) {
        this.tailleEcran = tailleEcran;
    }

    public String getCarteGraphique() {
        return carteGraphique;
    }

    public void setCarteGraphique(String carteGraphique) {
        this.carteGraphique = carteGraphique;
    }

    // Méthode pour afficher les détails d'un ordinateur

    @Override
    public String getType() {
        return "Ordinateur";
    }
}

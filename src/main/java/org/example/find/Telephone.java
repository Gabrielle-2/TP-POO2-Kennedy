package org.example.find;

public class Telephone extends Appareil {
    private String couleur;
    private Integer Stockage;
    private String Marque;

    public Telephone(String nom,  String couleur,Integer Stockage, String Marque) {
        super( nom);
        this.couleur = couleur;
        this.Stockage = Stockage;
        this.Marque = Marque;
    }


    public String getMarque() {
        return Marque;
    }

    public void setMarque(String marque) {
        Marque = marque;
    }

    public Integer getStockage() {
        return Stockage;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }



    public void setStockage(Integer stockage) {
        Stockage = stockage;
    }


    @Override
    public String getType() {
        return "Téléphone";
    }
}

package org.example.find;

public abstract class Appareil {

    protected String nom;

    public Appareil( String nom) {

        this.nom = nom;

    }


    public String getNom() {
        return nom;
    }

    public void setDescription(String description) {

    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    // Méthode que les sous-classes peuvent personnaliser
    public abstract String getType();

}

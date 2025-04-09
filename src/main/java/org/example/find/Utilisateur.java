package org.example.find;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Utilisateur {
    private String id;
    private String nom;
    private String prenom;
    private String localisation;
    private Integer telephone;
    private String motDePasse;

    // Constructeur
    public Utilisateur (String id, String nom, String prenom, String localisation, Integer telephone, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.localisation = localisation;
        this.telephone = telephone;
        this.motDePasse = motDePasse;
    }

    // Getters et Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String email) {
        this.localisation = localisation;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }


}

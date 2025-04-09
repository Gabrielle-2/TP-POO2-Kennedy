package org.example.find;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdinateurDAO {

    public boolean insererOrdinateur( String nom, String marque,String modele,Integer Stockage, String systemeEXploitation, Integer capaciteRam, Integer capaciteDisqueDur, String processeur, boolean estPortable, Double tailleEcran, String carteGraphique ) {
        String query = "INSERT INTO Ordinateur (nom, marque, modele,Stockage, systemeEXploitation ,  capaciteRam,capaciteDisqueDur,  processeur, estPortable, tailleEcran,carteGraphique) VALUES (?, ?, ?, ?,?,?,?,?,?,?,?)";
        try (Connection conn = DataBaseConnection.connect()){

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nom);
            stmt.setString(2, marque);
            stmt.setString(3, modele);
            stmt.setInt(4, Stockage);

            stmt.setString(5, systemeEXploitation);
            stmt.setInt(6,capaciteRam);
            stmt.setInt(7,capaciteDisqueDur);
            stmt.setString(8,processeur);
            stmt.setBoolean(9,estPortable);
            stmt.setDouble(10,tailleEcran);
            stmt.setString(11,carteGraphique);


            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<String> showOrdinateurs() {
        String query = "SELECT * FROM Ordinateur";
        List<String> ordinateurs = new ArrayList<>();

        // Establish connection and execute the query
        try (Connection conn = DataBaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            // Loop through the result set and store each record in the list
            while (rs.next()) {
                String ordinateur = "Nom: " + rs.getString("nom") +
                        ", Marque: " + rs.getString("marque") +
                        ", Modèle: " + rs.getString("modele") +
                        ", Stockage " +rs.getInt("Stockage")+
                        ", Système d'exploitation: " + rs.getString("systemeEXploitation") +
                        ", RAM: " + rs.getInt("capaciteRam") +
                        " Go, Disque Dur: " + rs.getInt("capaciteDisqueDur") +
                        " Go, Processeur: " + rs.getString("processeur") +
                        ", Est Portable: " + rs.getBoolean("estPortable") +
                        ", Taille Écran: " + rs.getDouble("tailleEcran") +
                        " pouces, Carte Graphique: " + rs.getString("carteGraphique");
                ordinateurs.add(ordinateur);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL exception
        }

        // Return the list of ordinateurs
        return ordinateurs;
    }
}

package org.example.find;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelephoneDAO {

    public boolean insererTelephone(String nom, String couleur, Integer Stockage, String Marque) {
        String query = "INSERT INTO Telephone (nom, couleur, Stockage ,Marque) VALUES (?, ?, ?, ?)";
        try (Connection conn = DataBaseConnection.connect()){

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nom);
            stmt.setString(2, couleur);
            stmt.setInt(3, Stockage);
            stmt.setString(4, Marque);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


        // Method to retrieve all telephone records from the database
        public List<String> showTelephones() {
            String query = "SELECT * FROM Telephone";
            List<String> telephones = new ArrayList<>();

            try (Connection conn = DataBaseConnection.connect();
                 PreparedStatement stmt = conn.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery()) {

                // Loop through the result set and store each record in the list
                while (rs.next()) {
                    String telephone = "Nom: " + rs.getString("nom") +
                            ", Couleur: " + rs.getString("couleur") +
                            ", Stockage: " + rs.getInt("Stockage") +
                            " Go, Marque: " + rs.getString("Marque");
                    telephones.add(telephone);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return telephones;
        }
    }


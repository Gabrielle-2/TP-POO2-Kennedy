package Interface;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.example.find.*;

public class SingINUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Création de compte");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(30));
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setAlignment(Pos.CENTER);

        Label nomLabel = new Label("Nom d'utilisateur:");
        TextField nomTextField = new TextField();

        Label preLabel = new Label("Prénom d'utilisateur:");
        TextField preTextField = new TextField();

        Label localisationLabel = new Label("Localisation:");
        TextField locTextField = new TextField();

        Label telLabel = new Label("Téléphone:");
        TextField telTextField = new TextField();

        Label passLabel = new Label("Mot de passe:");
        PasswordField passField = new PasswordField();

        Label confirmPassLabel = new Label("Confirmer le mot de passe:");
        PasswordField confirmPassField = new PasswordField();

        Button registerButton = new Button("Créer un compte");
        registerButton.setStyle("""
            -fx-background-color: #4CAF50;
            -fx-text-fill: white;
            -fx-font-weight: bold;
            -fx-background-radius: 30;
            -fx-padding: 10 20;
        """);

        Button backButton = new Button("Retour");
        backButton.setStyle("""
            -fx-background-color: #6A5ACD;
            -fx-text-fill: white;
            -fx-font-weight: bold;
            -fx-background-radius: 30;
            -fx-padding: 10 20;
        """);

        Label messageLabel = new Label();
        messageLabel.setStyle("-fx-font-size: 14px;");

        backButton.setOnAction(e -> {
            try {
                AccueilUI accueilUI = new AccueilUI();
                accueilUI.start(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        registerButton.setOnAction(e -> {
            String nom = nomTextField.getText();
            String prenom = preTextField.getText();
            String localisation = locTextField.getText();
            String tel = telTextField.getText();
            String password = passField.getText();
            String confirmPassword = confirmPassField.getText();

            if (nom.isEmpty() || prenom.isEmpty() || localisation.isEmpty() || tel.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                messageLabel.setText("Veuillez remplir tous les champs.");
                messageLabel.setTextFill(Color.RED);
                return;
            }

            if (!password.equals(confirmPassword)) {
                messageLabel.setText("Les mots de passe ne correspondent pas.");
                messageLabel.setTextFill(Color.RED);
                return;
            }

            try {
                int telephone = Integer.parseInt(tel);
                UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
                if (utilisateurDAO.insertUserIntoDatabase(nom, prenom, localisation, telephone, password)) {
                    messageLabel.setText("✅ Compte créé avec succès !");
                    messageLabel.setTextFill(Color.GREEN);
                    MenuPrincipal menuPrincipal = new MenuPrincipal();
                    menuPrincipal.start(primaryStage);
                } else {
                    messageLabel.setText("Erreur lors de la création du compte.");
                    messageLabel.setTextFill(Color.RED);
                }
            } catch (NumberFormatException ex) {
                messageLabel.setText("Numéro de téléphone invalide.");
                messageLabel.setTextFill(Color.RED);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        grid.add(nomLabel, 0, 0);
        grid.add(nomTextField, 1, 0);
        grid.add(preLabel, 0, 1);
        grid.add(preTextField, 1, 1);
        grid.add(localisationLabel, 0, 2);
        grid.add(locTextField, 1, 2);
        grid.add(telLabel, 0, 3);
        grid.add(telTextField, 1, 3);
        grid.add(passLabel, 0, 4);
        grid.add(passField, 1, 4);
        grid.add(confirmPassLabel, 0, 5);
        grid.add(confirmPassField, 1, 5);
        grid.add(registerButton, 0, 6);
        grid.add(backButton, 1, 6);
        grid.add(messageLabel, 1, 7);

        VBox layout = new VBox(30);
        layout.getChildren().add(grid);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #f4f4f4;"); // fond clair

        Scene scene = new Scene(layout, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


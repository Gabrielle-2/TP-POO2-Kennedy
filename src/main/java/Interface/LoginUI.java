package Interface;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.example.find.UtilisateurDAO;

public class LoginUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Connexion Utilisateur");

        // --- Création de la grille de connexion ---
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(30));
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setAlignment(Pos.CENTER);

        Label userLabel = new Label("Nom d'utilisateur:");
        TextField userTextField = new TextField();
        userTextField.setPromptText("Entrez votre nom d'utilisateur");
        userTextField.setStyle("""
            -fx-background-radius: 10;
            -fx-border-radius: 10;
            -fx-padding: 8;
            -fx-border-color: #2196f3;
        """);

        Label passLabel = new Label("Mot de passe:");
        PasswordField passField = new PasswordField();
        passField.setPromptText("Entrez votre mot de passe");
        passField.setStyle("""
            -fx-background-radius: 10;
            -fx-border-radius: 10;
            -fx-padding: 8;
            -fx-border-color: #2196f3;
        """);

        Button loginButton = new Button("Se connecter");
        loginButton.setStyle("""
            -fx-background-color: #4CAF50;
            -fx-text-fill: white;
            -fx-font-weight: bold;
            -fx-background-radius: 30;
            -fx-padding: 10 20;
        """);

        loginButton.setOnMouseEntered(e -> loginButton.setStyle("""
            -fx-background-color: #43a047;
            -fx-text-fill: white;
            -fx-font-weight: bold;
            -fx-background-radius: 30;
            -fx-padding: 10 20;
        """));
        loginButton.setOnMouseExited(e -> loginButton.setStyle("""
            -fx-background-color: #4CAF50;
            -fx-text-fill: white;
            -fx-font-weight: bold;
            -fx-background-radius: 30;
            -fx-padding: 10 20;
        """));

        Button backButton = new Button("Retour");
        backButton.setStyle("""
            -fx-background-color: #e53935;
            -fx-text-fill: white;
            -fx-font-weight: bold;
            -fx-background-radius: 30;
            -fx-padding: 10 20;
        """);

        Label messageLabel = new Label();
        messageLabel.setStyle("-fx-font-size: 14px;");

        // --- Action bouton retour ---
        backButton.setOnAction(e -> {
            try {
                AccueilUI mainUI = new AccueilUI();
                mainUI.start(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

        // --- Action bouton connexion ---
        loginButton.setOnAction(e -> {
            String username = userTextField.getText();
            String password = passField.getText();

            if (utilisateurDAO.verifierIdentifiants(username, password)) {
                messageLabel.setText("✅ Connexion réussie !");
                messageLabel.setTextFill(Color.GREEN);
                try {
                    MenuPrincipal menuPrincipal = new MenuPrincipal();
                    menuPrincipal.start(primaryStage);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                messageLabel.setText("❌ Identifiants incorrects !");
                messageLabel.setTextFill(Color.RED);
            }
        });

        // Ajout des éléments à la grille
        grid.add(userLabel, 0, 0);
        grid.add(userTextField, 1, 0);
        grid.add(passLabel, 0, 1);
        grid.add(passField, 1, 1);
        grid.add(loginButton, 0, 2);
        grid.add(backButton, 1, 2);
        grid.add(messageLabel, 1, 3);

        VBox layout = new VBox(30);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(grid);
        layout.setStyle("-fx-background-color: #f0f0f0;"); // couleur de fond claire

        Scene scene = new Scene(layout, 500, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

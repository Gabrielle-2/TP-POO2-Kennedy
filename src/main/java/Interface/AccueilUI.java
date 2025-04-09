package Interface;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AccueilUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        // ----------- Partie gauche : fond bleu foncé avec titre/logo -----------
        Image logo = new Image(getClass().getResource("/Logo.png").toExternalForm());
        ImageView logoView = new ImageView(logo);
        logoView.setFitWidth(50);
        logoView.setPreserveRatio(true);


        VBox leftPane = new VBox();
        leftPane.setPrefWidth(300);
        leftPane.setAlignment(Pos.CENTER);
        leftPane.setStyle("-fx-background-color: #0d47a1;");

        Label titleLabel = new Label("FindBack");
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setFont(Font.font("Verdana", 32));
        titleLabel.setStyle("-fx-font-weight: bold; -fx-font-style: italic;");
        titleLabel.setEffect(new DropShadow());

        leftPane.getChildren().addAll(logoView,titleLabel);

        // ----------- Partie droite : boutons sur fond bleu clair -----------
        VBox rightPane = new VBox(20);
        rightPane.setAlignment(Pos.CENTER);
        rightPane.setPadding(new Insets(60));
        rightPane.setPrefWidth(400);
        rightPane.setStyle("-fx-background-color: #e3f2fd;"); // Bleu très clair

        Label welcomeLabel = new Label("Bienvenue !");
        welcomeLabel.setFont(Font.font("Arial", 26));
        welcomeLabel.setStyle("-fx-font-weight: bold;");

        Button signUpButton = new Button("S'inscrire");
        Button loginButton = new Button("Se connecter");

        // Style commun aux boutons
        String buttonStyle = """
            -fx-font-size: 16px;
            -fx-background-color: #ffffff;
            -fx-text-fill: #6a1b9a;
            -fx-background-radius: 30;
            -fx-padding: 10 20;
            -fx-border-color: #6a1b9a;
            -fx-border-radius: 30;
        """;

        signUpButton.setStyle(buttonStyle);
        loginButton.setStyle(buttonStyle);

        // Hover effect
        signUpButton.setOnMouseEntered(e -> signUpButton.setStyle(buttonStyle + "-fx-background-color: #ede7f6;"));
        signUpButton.setOnMouseExited(e -> signUpButton.setStyle(buttonStyle));

        loginButton.setOnMouseEntered(e -> loginButton.setStyle(buttonStyle + "-fx-background-color: #ede7f6;"));
        loginButton.setOnMouseExited(e -> loginButton.setStyle(buttonStyle));

        // Actions
        signUpButton.setOnAction(e -> {
            SingINUI singINUI = new SingINUI();
            try {
                singINUI.start(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        loginButton.setOnAction(e -> {
            LoginUI loginUI = new LoginUI();
            try {
                loginUI.start(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        rightPane.getChildren().addAll(welcomeLabel, signUpButton, loginButton);

        // ----------- Conteneur principal -----------
        HBox root = new HBox();
        root.getChildren().addAll(leftPane, rightPane);

        Scene scene = new Scene(root, 700, 500);
        primaryStage.setTitle("Page d'Accueil");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}



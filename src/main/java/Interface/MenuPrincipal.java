package Interface;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MenuPrincipal extends Application {

    @Override
    public void start(Stage primaryStage) {

        // --- MENU BAR ---
        MenuBar menuBar = new MenuBar();
        Menu menuProfil = new Menu("Profil");
        Menu menuNotifications = new Menu("Notifications");
        Menu menuAjouter = new Menu("Ajouter une annonce");
        Menu menuVoir = new Menu("Voir les annonces");
        Menu menuAide = new Menu("Aide");

        // --- MENUITEMS ---
        MenuItem addTelephone = new MenuItem("Ajouter téléphone");
        MenuItem addOrdinateur = new MenuItem("Ajouter ordinateur");
        menuAjouter.getItems().addAll(addTelephone, new SeparatorMenuItem(), addOrdinateur);

        MenuItem seeTelephone = new MenuItem("Voir les téléphones");
        MenuItem seeOrdinateur = new MenuItem("Voir les ordinateurs");
        menuVoir.getItems().addAll(seeTelephone, new SeparatorMenuItem(), seeOrdinateur);

        menuBar.getMenus().addAll(menuProfil, menuNotifications, menuAjouter, menuVoir, menuAide);

        // --- STYLE DES MENUITEMS ---


        // --- ACTIONS ---
        ShowPhone pp = new ShowPhone();
        ShowOrdi oo = new ShowOrdi();
        TelephoneGUI telephoneGUI = new TelephoneGUI();
        OrdinateurGUI ordinateurGUI = new OrdinateurGUI();

        addTelephone.setOnAction(e -> transitionToNewScene(telephoneGUI, primaryStage));
        addOrdinateur.setOnAction(e -> transitionToNewScene(ordinateurGUI, primaryStage));
        seeTelephone.setOnAction(e -> transitionToNewScene(pp, primaryStage));
        seeOrdinateur.setOnAction(e -> transitionToNewScene(oo, primaryStage));

        // --- BOUTON DECONNEXION ---
        Button deconnecterButton = new Button("Déconnexion");
        deconnecterButton.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white; -fx-font-weight: bold;");
        deconnecterButton.setOnAction(e -> transitionToNewScene(new AccueilUI(), primaryStage));

        HBox buttonBox = new HBox(deconnecterButton);
        buttonBox.setAlignment(Pos.BOTTOM_LEFT);
        buttonBox.setPadding(new Insets(20, 10, 10, 10));

        // --- LAYOUT PRINCIPAL ---
        VBox root = new VBox(15);
        root.setPadding(new Insets(15));

        root.setStyle("-fx-background-color: #0d47a1;"); // couleur de fond claire
        root.getChildren().addAll(menuBar, buttonBox);

        // --- SCENE ---
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Menu Principal");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void transitionToNewScene(Application app, Stage primaryStage) {
        // Changement de scène sans animation
        try {
            app.start(primaryStage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

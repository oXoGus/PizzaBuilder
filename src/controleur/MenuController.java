package controleur;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {

    @FXML
    private Button btnMyPizza;

    @FXML
    private Button btnBuildPizza;

    @FXML
    private Button btnOrderPizza;

    @FXML
    private Button btnQuit;

    @FXML
    private void initialize() {
        btnMyPizza.setOnAction(e -> handleMyPizza(e));
        btnBuildPizza.setOnAction(e -> handleBuildPizza(e));
        btnOrderPizza.setOnAction(e -> handleOrderPizza(e));
        btnQuit.setOnAction(e -> handleQuit(e));
    }

    public void handleMyPizza(ActionEvent event) {
        System.out.println("My Pizza clicked");
        // Logique ou navigation vers la vue "My Pizza"
    }

    private void handleBuildPizza(ActionEvent event) {
        System.out.println("Build a pizza clicked");
        // Logique ou navigation vers la construction de pizza
    }

    private void handleOrderPizza(ActionEvent event) {
        System.out.println("Order pizza clicked");
        // Logique ou passage à la commande
    }

    private void handleQuit(ActionEvent event) {
        System.out.println("Quit clicked");
        // Ferme l'application
        Platform.exit();
    }
}

package controleur;

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
        // Initialisation si nécessaire
    }

    @FXML
    private void handleMyPizza(ActionEvent event) {
        System.out.println("My Pizza clicked");
        // Logique ou navigation vers la vue "My Pizza"
    }

    @FXML
    private void handleBuildPizza(ActionEvent event) {
        System.out.println("Build a pizza clicked");
        // Logique ou navigation vers la construction de pizza
    }

    @FXML
    private void handleOrderPizza(ActionEvent event) {
        System.out.println("Order pizza clicked");
        // Logique ou passage à la commande
    }

    @FXML
    private void handleQuit(ActionEvent event) {
        System.out.println("Quit clicked");
        // Ferme l'application
        System.exit(0);
    }
}

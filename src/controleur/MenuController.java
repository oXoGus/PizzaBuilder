package controleur;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {
    NavAgent nav = new NavAgent();

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
    public void btnMyPizza(ActionEvent event) {
        System.out.println("My Pizza clicked");
        // Logique ou navigation vers la vue "My Pizza"
    }

    @FXML
    private void btnBuildPizza(ActionEvent event) {
        nav.goTo(btnBuildPizza, "/vue/BuilderPizza.fxml");
    }   

    @FXML
    private void btnOrderPizza(ActionEvent event) {
        nav.goTo(btnOrderPizza, "/vue/order.fxml");
    }


    @FXML
    void btnQuit(ActionEvent event) {
        System.exit(0);
    }
}

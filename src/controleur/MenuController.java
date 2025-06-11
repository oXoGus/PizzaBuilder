package controleur;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {
    private final NavAgent nav = new NavAgent();

    @FXML
    private Button btnMyPizza;

    @FXML
    private Button btnBuildPizza;

    @FXML
    private Button btnOrderPizza;

    @FXML
    private Button btnQuit;

    @FXML
    public void btnMyPizza(ActionEvent event) {
        nav.goTo(btnMyPizza, "/vue/order.fxml");
    }

    @FXML
    private void btnBuildPizza(ActionEvent event) {
        nav.goTo(btnBuildPizza, "/vue/BuildPizza.fxml");
    }   

    @FXML
    private void btnOrderPizza(ActionEvent event) {
        nav.goTo(btnOrderPizza, "/vue/commande.fxml");
    }


    @FXML
    void btnQuit(ActionEvent event) {
        Platform.exit();
    }
}

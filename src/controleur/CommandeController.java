package controleur;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class CommandeController {
    NavAgent nav = new NavAgent();

    // Navigation and Menu Components
    @FXML private Button hamburgerButton;
    @FXML private VBox sidebarMenu;
    @FXML private TextField searchField;
    @FXML private Button searchButton;
    @FXML private Button loginButton;
    @FXML private Button signupButton;

    // Menu Navigation Buttons
    @FXML private Button menuMain;
    @FXML private Button menuCreatePizza;
    @FXML private Button menuMyPizzas;
    @FXML private Button menuTrending;

    private boolean isMenuOpen = false;

    /**
     * Toggle the hamburger menu visibility with smooth animation
     */
    @FXML
    private void toggleMenu(ActionEvent event) {
        if (isMenuOpen) {
            closeMenu();
        } else {
            openMenu();
        }
    }

    /**
     * Open the sidebar menu with slide animation
     */
    private void openMenu() {
        sidebarMenu.setVisible(true);
        sidebarMenu.setManaged(true);

        // Slide animation
        TranslateTransition slideIn = new TranslateTransition(Duration.millis(300), sidebarMenu);
        slideIn.setFromX(-250);
        slideIn.setToX(0);
        slideIn.play();

        isMenuOpen = true;
        hamburgerButton.setText("✕"); // Change to X icon
    }

    /**
     * Close the sidebar menu with slide animation
     */
    private void closeMenu() {
        TranslateTransition slideOut = new TranslateTransition(Duration.millis(300), sidebarMenu);
        slideOut.setFromX(0);
        slideOut.setToX(-250);
        slideOut.setOnFinished(e -> {
            sidebarMenu.setVisible(false);
            sidebarMenu.setManaged(false);
        });
        slideOut.play();

        isMenuOpen = false;
        hamburgerButton.setText("☰"); // Change back to hamburger icon
    }

    // ===================
    // NAVIGATION HANDLERS
    // ===================

    @FXML
    private void navigateToCreatePizza(ActionEvent event) {
        nav.goTo(menuMain, "/vue/BuildPizza.fxml");
    }

    @FXML
    private void navigateToMyPizzas(ActionEvent event) {
        nav.goTo(menuMain, "/vue/commande.fxml");
    }

    @FXML
    private void navigateToTrending(ActionEvent event) {
        nav.goTo(menuMain, "/vue/order.fxml");
    }

    // ==================
    // SEARCH FUNCTIONALITY
    // ==================

    @FXML
    private void performSearch(ActionEvent event) {
        String searchQuery = searchField.getText().trim();
        if (!searchQuery.isEmpty()) {
            System.out.println("Searching for: " + searchQuery);
            // TODO: Implement search functionality
            // Example: filterPizzas(searchQuery);
            searchPizzas(searchQuery);
        }
    }

    /**
     * Implement pizza search logic
     */
    private void searchPizzas(String query) {
        // TODO: Implement actual search logic
        // This could involve:
        // 1. Filtering pizza data based on name, ingredients, etc.
        // 2. Updating the displayed pizza cards
        // 3. Highlighting search results
        System.out.println("Searching pizzas with query: " + query);
    }

    // ====================
    // AUTHENTICATION HANDLERS
    // ====================

    @FXML
    private void showLogin(ActionEvent event) {
        System.out.println("Showing login dialog");
        // TODO: Implement login functionality
        // Example: DialogManager.showLoginDialog();
    }

    @FXML
    private void showSignup(ActionEvent event) {
        System.out.println("Showing signup dialog");
        // TODO: Implement signup functionality
        // Example: DialogManager.showSignupDialog();
    }


    public void navigateToMain(ActionEvent actionEvent) {
        nav.goTo(menuMain, "/vue/menu.fxml");
    }

}

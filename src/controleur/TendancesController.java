package controleur;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for the Tendances (Trends) page
 * Handles all UI interactions including menu toggle, scrolling, and pizza selection
 */
public class TendancesController implements Initializable {

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

    // First Row Scroll Components
    @FXML private Button leftArrow1;
    @FXML private Button rightArrow1;
    @FXML private ScrollPane pizzaScrollPane1;
    @FXML private HBox pizzaContainer1;

    // Second Row Scroll Components
    @FXML private Button leftArrow2;
    @FXML private Button rightArrow2;
    @FXML private ScrollPane pizzaScrollPane2;
    @FXML private HBox pizzaContainer2;

    // third Row Scroll Components
    @FXML private Button leftArrow3;
    @FXML private Button rightArrow3;
    @FXML private ScrollPane pizzaScrollPane3;
    @FXML private HBox pizzaContainer3;

    // Pizza Card Components (First Row)
    @FXML private VBox pizzaCard1;
    @FXML private VBox pizzaCard2;
    @FXML private VBox pizzaCard3;
    @FXML private VBox pizzaCard4;
    @FXML private VBox pizzaCard5;
    @FXML private VBox pizzaCard6;
    @FXML private VBox pizzaCard7;


    // Pizza Card Components (Second Row)
    @FXML private VBox pizzaCard8;
    @FXML private VBox pizzaCard9;
    @FXML private VBox pizzaCard10;
    @FXML private VBox pizzaCard11;
    @FXML private VBox pizzaCard12;
    @FXML private VBox pizzaCard13;
    @FXML private VBox pizzaCard14;

    // Pizza Card Components (Third Row)
    @FXML private VBox pizzaCard15;
    @FXML private VBox pizzaCard16;
    @FXML private VBox pizzaCard17;
    @FXML private VBox pizzaCard18;
    @FXML private VBox pizzaCard19;
    @FXML private VBox pizzaCard20;
    @FXML private VBox pizzaCard21;


    // State variables
    private boolean isMenuOpen = false;
    private static final double SCROLL_AMOUNT = 270.0; // Width of one pizza card + spacing

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize any default states or load data
        setupScrollPanes();
        setupPizzaCardHoverEffects();
    }

    /**
     * Configure scroll panes for smooth horizontal scrolling
     */
    private void setupScrollPanes() {
        // Make scroll panes focus traversable for keyboard navigation
        pizzaScrollPane1.setFocusTraversable(false);
        pizzaScrollPane2.setFocusTraversable(false);

        // Set initial scroll positions
        pizzaScrollPane1.setHvalue(0.0);
        pizzaScrollPane2.setHvalue(0.0);
    }

    /**
     * Add hover effects to pizza cards for better UX
     */
    private void setupPizzaCardHoverEffects() {
        // Add hover effects to pizza cards
        addHoverEffect(pizzaCard1);
        addHoverEffect(pizzaCard2);
        addHoverEffect(pizzaCard3);
        addHoverEffect(pizzaCard4);
        addHoverEffect(pizzaCard5);
        addHoverEffect(pizzaCard6);
        addHoverEffect(pizzaCard7);
        addHoverEffect(pizzaCard8);
        addHoverEffect(pizzaCard9);
        addHoverEffect(pizzaCard10);
        addHoverEffect(pizzaCard11);
        addHoverEffect(pizzaCard12);
        addHoverEffect(pizzaCard13);
        addHoverEffect(pizzaCard14);
        addHoverEffect(pizzaCard15);
        addHoverEffect(pizzaCard16);
        addHoverEffect(pizzaCard17);
        addHoverEffect(pizzaCard18);
        addHoverEffect(pizzaCard19);
        addHoverEffect(pizzaCard20);
        addHoverEffect(pizzaCard21);
    }

    /**
     * Add hover animation to a pizza card
     */
    private void addHoverEffect(VBox pizzaCard) {
        if (pizzaCard != null) {
            pizzaCard.setOnMouseEntered(e -> {
                pizzaCard.setStyle(pizzaCard.getStyle() +
                        "; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0, 0, 4);" +
                        "; -fx-scale-x: 1.02; -fx-scale-y: 1.02;");
            });

            pizzaCard.setOnMouseExited(e -> {
                pizzaCard.setStyle(pizzaCard.getStyle().replace(
                        "; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0, 0, 4);" +
                                "; -fx-scale-x: 1.02; -fx-scale-y: 1.02;", ""));
            });
        }
    }

    // =================
    // MENU FUNCTIONALITY
    // =================

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

    // ===================
    // SCROLLING FUNCTIONALITY
    // ===================

    /**
     * Scroll first row to the left
     */
    @FXML
    private void scrollLeft1(ActionEvent event) {
        scrollHorizontally(pizzaScrollPane1, -SCROLL_AMOUNT);
    }

    /**
     * Scroll first row to the right
     */
    @FXML
    private void scrollRight1(ActionEvent event) {
        scrollHorizontally(pizzaScrollPane1, SCROLL_AMOUNT);
    }

    /**
     * Scroll second row to the left
     */
    @FXML
    private void scrollLeft2(ActionEvent event) {
        scrollHorizontally(pizzaScrollPane2, -SCROLL_AMOUNT);
    }

    /**
     * Scroll second row to the right
     */
    @FXML
    private void scrollRight2(ActionEvent event) {
        scrollHorizontally(pizzaScrollPane2, SCROLL_AMOUNT);
    }

    /**
     * Scroll second row to the left
     */
    @FXML
    private void scrollLeft3(ActionEvent event) {
        scrollHorizontally(pizzaScrollPane3, -SCROLL_AMOUNT);
    }

    /**
     * Scroll second row to the right
     */
    @FXML
    private void scrollRight3(ActionEvent event) {
        scrollHorizontally(pizzaScrollPane3, SCROLL_AMOUNT);
    }

    /**
     * Generic method to scroll a ScrollPane horizontally
     * @param scrollPane The ScrollPane to scroll
     * @param amount The amount to scroll (positive for right, negative for left)
     */
    private void scrollHorizontally(ScrollPane scrollPane, double amount) {
        double currentValue = scrollPane.getHvalue();
        double contentWidth = scrollPane.getContent().getBoundsInLocal().getWidth();
        double viewportWidth = scrollPane.getViewportBounds().getWidth();
        double maxValue = (contentWidth - viewportWidth) / contentWidth;

        // Calculate new scroll position
        double newValue = currentValue + (amount / contentWidth);

        // Clamp the value between 0 and maxValue
        newValue = Math.max(0, Math.min(newValue, maxValue));

        // Animate the scroll
        TranslateTransition scrollTransition = new TranslateTransition(Duration.millis(300));
        // For smooth scrolling, we'll directly set the value
        scrollPane.setHvalue(newValue);
    }

    // ======================
    // PIZZA SELECTION HANDLERS
    // ======================

    @FXML
    private void selectPizza1(MouseEvent event) {
        handlePizzaSelection("Pizza Pepperoni #1");
    }

    @FXML
    private void selectPizza2(MouseEvent event) {
        handlePizzaSelection("Pizza Pepperoni #2");
    }

    @FXML
    private void selectPizza3(MouseEvent event) {
        handlePizzaSelection("Pizza Pepperoni #3");
    }

    @FXML
    private void selectPizza4(MouseEvent event) {
        handlePizzaSelection("Pizza Pepperoni #4");
    }

    @FXML
    private void selectPizza5(MouseEvent event) {
        handlePizzaSelection("Pizza Pepperoni #5");
    }

    @FXML
    private void selectPizza6(MouseEvent event) {
        handlePizzaSelection("Pizza Pepperoni #6");
    }

    @FXML
    private void selectPizza7(MouseEvent event) {
        handlePizzaSelection("Pizza Pepperoni #7");
    }

    @FXML
    private void selectPizza8(MouseEvent event) {
        handlePizzaSelection("Pizza Pepperoni #8");
    }

    @FXML
    private void selectPizza9(MouseEvent event) {
        handlePizzaSelection("Pizza Pepperoni #9");
    }

    @FXML
    private void selectPizza10(MouseEvent event) {
        handlePizzaSelection("Pizza Pepperoni #10");
    }

    @FXML
    private void selectPizza11(MouseEvent event) {
        handlePizzaSelection("Pizza Pepperoni #11");
    }

    @FXML
    private void selectPizza12(MouseEvent event) {
        handlePizzaSelection("Pizza Pepperoni #12");
    }

    @FXML
    private void selectPizza13(MouseEvent event) {
        handlePizzaSelection("Pizza Pepperoni #13");
    }

    @FXML
    private void selectPizza14(MouseEvent event) {
        handlePizzaSelection("Pizza Pepperoni #14");
    }

    @FXML
    private void selectPizza15(MouseEvent event) {
        handlePizzaSelection("Pizza Pepperoni #15");
    }

    @FXML
    private void selectPizza16(MouseEvent event) {
        handlePizzaSelection("Pizza Pepperoni #16");
    }

    @FXML
    private void selectPizza17(MouseEvent event) {
        handlePizzaSelection("Pizza Pepperoni #17");
    }

    @FXML
    private void selectPizza18(MouseEvent event) {
        handlePizzaSelection("Pizza Pepperoni #18");
    }

    @FXML
    private void selectPizza19(MouseEvent event) {
        handlePizzaSelection("Pizza Pepperoni #19");
    }

    @FXML
    private void selectPizza20(MouseEvent event) {
        handlePizzaSelection("Pizza Pepperoni #20");
    }

    @FXML
    private void selectPizza21(MouseEvent event) {
        handlePizzaSelection("Pizza Pepperoni #21");
    }

    /**
     * Handle pizza selection - show details or add to cart
     */
    private void handlePizzaSelection(String pizzaName) {
        System.out.println("Selected pizza: " + pizzaName);
        // TODO: Implement pizza selection logic
        // This could involve:
        // 1. Showing pizza details in a modal
        // 2. Adding to cart
        // 3. Navigating to pizza customization page
        showPizzaDetails(pizzaName);
    }

    /**
     * Show detailed information about a selected pizza
     */
    private void showPizzaDetails(String pizzaName) {
        // TODO: Implement pizza details dialog
        // Example: DialogManager.showPizzaDetails(pizzaName);
        System.out.println("Showing details for: " + pizzaName);
    }

    // ===================
    // UTILITY METHODS
    // ===================

    /**
     * Method to refresh pizza data (useful for dynamic content)
     */
    public void refreshPizzaData() {
        // TODO: Implement data refresh logic
        // This could involve:
        // 1. Fetching new pizza data from database
        // 2. Updating pizza cards with new information
        // 3. Refreshing ratings and availability
        System.out.println("Refreshing pizza data...");
    }

    /**
     * Method to handle window resize events
     */
    public void handleResize() {
        // TODO: Adjust layout based on window size
        // This could involve:
        // 1. Adjusting number of visible pizza cards
        // 2. Modifying scroll amounts
        // 3. Responsive design adjustments
        System.out.println("Handling window resize...");
    }

    public void navigateToMain(ActionEvent actionEvent) {
        nav.goTo(menuMain, "/vue/menu.fxml");
    }
}
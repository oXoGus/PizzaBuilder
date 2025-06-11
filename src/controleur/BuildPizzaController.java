package controleur;

import java.util.List;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.util.Duration;
import model.Ingredient;
import model.Pizza;
import model.TomatoSauce;
import model.baseShape.BaseCircle;
import model.baseShape.BaseRect;
import model.baseShape.BaseTri;
import model.ingredients.Ananas;
import model.ingredients.Champignon;
import model.ingredients.FromageRape;
import model.ingredients.Jambon;
import model.ingredients.Peperoni;
import model.ingredients.Tomate;
import model.Element;

public class BuildPizzaController {

    private Pizza pizza = new Pizza();

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

    @FXML
    private VBox ingredientsOrderContainer;

    @FXML
    private VBox ingredientsSelectContainer;

    @FXML
    private VBox pateSelectContainer;

    @FXML
    private AnchorPane pizzaContainer;

    @FXML
    private Label priceLabel;

    @FXML
    private BorderPane root;

    @FXML
    private Button baseCircleBtn;

    @FXML
    private Button baseRectBtn;

    @FXML
    private Button baseTriBtn;

    @FXML
    private VBox sauceSelectContainer;

    @FXML
    private Button btnValidate;

    private String elementSelectedLabel;

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

    @FXML
    private void initialize(){
        displaySauce();
        displayIngredients();
        pizzaContainer.setOnMouseClicked(event -> placeElement(event));
        pizzaContainer.setOnMouseDragged(event -> placeElement(event));

        baseCircleBtn.setOnAction(event -> setBase(event));
        baseRectBtn.setOnAction(event -> setBase(event));
        baseTriBtn.setOnAction(event -> setBase(event));

        btnValidate.setOnAction(event -> pizzaVerification());
    }

    public void setBase(ActionEvent event){
        String baseId =  ((Node) event.getSource()).getId();

        double x = pizzaContainer.getWidth() / 2;
        double y = pizzaContainer.getHeight() / 2;

        Element base = switch (baseId) {
            case "baseCircleBtn" -> new BaseCircle(x, y); 
            case "baseRectBtn" -> new BaseRect(x, y);
            case "baseTriBtn" -> new BaseTri(x, y);  
            default -> null;
        };

        pizza.addElement(base);
        pizzaContainer.getChildren().add(base.shape());
    }

    


    public void displayIngredients(){
        for (var ingredient : Ingredient.INGREDIENTS_LST){

            ImageView img = (ImageView) ingredient.shape();

            // on met l'img en tout petit pour faire l'icone
            img.setFitHeight(20);
            img.setFitWidth(20);
            img.setRotate(0);
            img.setPreserveRatio(true);
            
            Label label = new Label(ingredient.label());

            label.setFont(new Font(18));

            label.setTextFill(Paint.valueOf("white"));

            HBox hBox = new HBox(15, img, label);

            hBox.setAlignment(Pos.CENTER_LEFT);

            // pour retrouver l'ingrédient
            hBox.setId(ingredient.label());
            
            ingredientsSelectContainer.getChildren().add(hBox);

            // pour changer la séléction 
            hBox.setOnMouseClicked(event -> changeElementSelected(event));
        }
    }

    public void displaySauce(){
        for (var sauce : List.of(new TomatoSauce(0, 0))){

            Circle shape = (Circle) sauce.shape();

            shape.setRadius(10);
            
            Label label = new Label(sauce.label());

            label.setFont(new Font(18));

            label.setTextFill(Paint.valueOf("white"));

            HBox hBox = new HBox(15, shape, label);

            hBox.setAlignment(Pos.CENTER_LEFT);

            // pour retrouver l'ingrédient
            hBox.setId(sauce.label());
            
            sauceSelectContainer.getChildren().add(hBox);

            // pour changer la séléction 
            hBox.setOnMouseClicked(event -> changeElementSelected(event));
        }
    }

    public void changeElementSelected(MouseEvent event){
        elementSelectedLabel = ((Node) event.getSource()).getId();
        resetBtn();
        ((Node) event.getSource()).setStyle("-fx-background-color: #a0a0a0;");
    }

    public void resetBtn(){
        for (var btnSauce : sauceSelectContainer.getChildren()){
            btnSauce.setStyle("-fx-background-color: transparent;");
        }
        for (var btnIngredient : ingredientsSelectContainer.getChildren()){
            btnIngredient.setStyle("-fx-background-color: transparent;");
        }
    }

    public void pizzaVerification(){

        // listes des err : 
        
        // pas de pizza sans pâte 
        if (pizza.base() == null){
            
            Alert confirmation = new Alert(AlertType.ERROR);
            confirmation.setTitle("Pizza infaisable");
            confirmation.setContentText("Votre pizza n'a pas de pâte");

            // on montre l'alert et on attend le retour de l'utilisateur 
            confirmation.showAndWait();        
            return;
        }
                
        // pas de pizza vide
        if (pizzaContainer.getChildren().isEmpty()){
            Alert confirmation = new Alert(AlertType.ERROR);
            confirmation.setTitle("Pizza inéxistante");
            confirmation.setContentText("Veuillez ajouter des éléments pour constituer votre pizza");

            // on montre l'alert et on attend le retour de l'utilisateur 
            confirmation.showAndWait();   
            return;   
        }
        
        // pas de pizza où la base n'est pas le premier élément 
        if (!pizza.isBaseInFirstLayer()){
            Alert confirmation = new Alert(AlertType.ERROR);
            confirmation.setTitle("Pizza infaisable");
            confirmation.setContentText("Veuillez ajouter une base en premier");

            // on montre l'alert et on attend le retour de l'utilisateur 
            confirmation.showAndWait();   
            return; 
        }

        Alert confirmation = new Alert(AlertType.INFORMATION);
        confirmation.setTitle("Pizza commandé");
        confirmation.setContentText("Votre pizza a bien été créée");

        // on montre l'alert et on attend le retour de l'utilisateur 
        confirmation.showAndWait();   

        
    }



    public void displayPizza(){
        // on récup touts les éléments de la pizza
        for (var shape : pizza.shapes()){
            // on l'affiche a ses coords
            pizzaContainer.getChildren().add(shape);
           
        }
    }

    public void deletePizza(){
        pizzaContainer.getChildren().clear();
    }

    public void deleteLayer(ActionEvent e){
        
        // l'index de la layer est dans l'id du bouton cliqué 
        int layerIndex = Integer.parseInt(((Node) e.getSource()).getId());

        pizza.remove(layerIndex);
    }

    public void placeElement(MouseEvent event){
        if (elementSelectedLabel != null){

            var element = createElement(event.getX(), event.getY());
            pizza.addElement(element);

            // on dessine la pièce
            pizzaContainer.getChildren().add(element.shape());
        }
    }

    public Element createElement(double x, double y){
        switch (elementSelectedLabel) {
            case "Fromage rapé": return new FromageRape(x, y);
            case "Ananas": return new Ananas(x, y);
            case "Champignon": return new Champignon(x, y);
            case "Jambon": return new Jambon(x, y);
            case "Peperoni": return new Peperoni(x, y);
            case "Tomate": return new Tomate(x, y);
            case "Sauce tomate": return new TomatoSauce(x, y);
            default: return null;
        }
    }


}

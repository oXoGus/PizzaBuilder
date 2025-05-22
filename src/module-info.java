module PizzaBuilder {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	
	opens controleur to javafx.graphics, javafx.fxml;
	opens vue to javafx.graphics, javafx.fxml;
}
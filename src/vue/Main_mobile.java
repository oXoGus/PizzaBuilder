package vue;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;



public class Main_mobile extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = FXMLLoader.load(getClass().getResource("menu_mobile.fxml"));

			// on met la taille de la fenêtre pour qu'elle prenne tout l'écran
			Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
			primaryStage.setX(screenBounds.getMinX());
			primaryStage.setY(screenBounds.getMinY());
			primaryStage.setWidth(430);
			primaryStage.setHeight(932);

			// pour empécher le redimensionnement
			primaryStage.setResizable(false);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("PizzaBuilder - menu_mobile");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

package view;

import resources.constants.Doubles;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class View {

	// JavaFX Instance Variables
	private Scene scene;
	private Group root;
	private VBox vBox;
	
	private double width, height;
	private double twentiethWidth;
	private double halfWidth;
	
	// Constructor and helpers
	public View(double width, double height) {
		
		configureSize(width, height);
		createRootAndScene();
		createAndAddVBox();
		
	}
	
	private void configureSize(double width, double height) {

		this.width = width;
		this.height = height;

		twentiethWidth = Doubles.TWENTY_PERCENT * width;
		halfWidth = Doubles.FIFTY_PERCENT * width;

	}
	
	private void createRootAndScene() {
		
		root = new Group();
		scene = new Scene(root, width, height, Color.TAN);
		vBox = new VBox();
		root.getChildren().add(vBox);

	}

	private void createAndAddVBox() {

		vBox = new VBox();
		root.getChildren().add(vBox);

	}

	


	// Getters & Setters
	public Scene getSceneToDisplay() {
		return scene;
	}
	
	// All other instance methods
	
	
}

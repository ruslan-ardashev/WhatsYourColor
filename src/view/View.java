package view;

import resources.constants.Doubles;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class View {

	private Scene scene;
	private Group root;
	
	private double width, height;
	private double tenthWidth;
	private double halfWidth;
	
	// Constructor and helpers
	public View(double width, double height) {
		
		configureSize(width, height);
		createRootAndScene();
		
	}
	
	private void createRootAndScene() {
		
		root = new Group();
		scene = new Scene(root, width, height, Color.TAN);
		
	}
	
	private void configureSize(double width, double height) {
		
		this.width = width;
		this.height = height;
		
		tenthWidth = Doubles.TEN_PERCENT * width;
		halfWidth = Doubles.FIFTY_PERCENT * width;
		
	}

	
	// Getters & Setters
	public Scene getSceneToDisplay() {
		return scene;
	}
	
	// All other instance methods
	
	
}

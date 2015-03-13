package view;

import resources.constants.Doubles;
import resources.constants.Ints;
import view.box.ButtonBox;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class View {

	// JavaFX Instance Variables
	private Scene scene;
	private Group root;
	private VBox buttonBox;
	
	private double width, height;
	
	// Width
	private double twentiethWidth;
	private double halfWidth;
	private double buttonWidth;
	
	// Height
	private double ninthHeight;

	
	// Constructor and helpers
	public View(double width, double height) {
		
		configureSize(width, height);
		createRootAndScene();
		createAndAddButtonBox();
		
	}
	
	private void configureSize(double width, double height) {

		this.width = width;
		this.height = height;

		// Width
		twentiethWidth = Doubles.TWENTY_PERCENT * width;
		halfWidth = Doubles.FIFTY_PERCENT * width;
		buttonWidth = twentiethWidth * Doubles.NINETY_PERCENT;

		// Height
		ninthHeight = Doubles.NINETY_PERCENT * height;
		
	}
	
	private void createRootAndScene() {
		
		root = new Group();
		scene = new Scene(root, width, height, Color.TAN);

	}

	private void createAndAddButtonBox() {

		buttonBox = new ButtonBox(root, Ints.BUTTON_OFFSET, buttonWidth);
		
		buttonBox.setTranslateX(halfWidth);
		buttonBox.setTranslateY(ninthHeight);

	}
	

	// Getters & Setters
	public Scene getSceneToDisplay() {
		return scene;
	}
	
	// All other instance methods
	
	
}

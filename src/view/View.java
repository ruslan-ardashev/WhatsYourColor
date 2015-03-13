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
	private HBox centeringBox;
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
		createCenteringBox();
		createScene();
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
	
	private void createScene() {
		
		scene = new Scene(centeringBox, width, height);

	}
	
	private void createCenteringBox() {
		
		centeringBox = new HBox();
		centeringBox.setAlignment(Pos.CENTER);
		centeringBox.setStyle("-fx-background: #AAAAAA;");

	}

	private void createAndAddButtonBox() {

		buttonBox = new ButtonBox(Ints.BUTTON_OFFSET, buttonWidth);

		// Debugging
//		buttonBox.setStyle("-fx-border-style: solid;"
//				                + "-fx-border-width: 1;"
//				                + "-fx-border-color: black");

		
		buttonBox.setTranslateY(ninthHeight);
		
		centeringBox.getChildren().add(buttonBox);

	}
	

	// Getters & Setters
	public Scene getSceneToDisplay() {
		return scene;
	}
	
	// All other instance methods
	// Quick, proper method with aligning box
	private void addPane(Pane pane) {
		
		centeringBox.getChildren().add(pane);
		
	}
	
	
	
}

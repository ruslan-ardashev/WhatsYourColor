package view;

import resources.constants.Doubles;
import resources.constants.Ints;
import view.box.ButtonBox;
import view.box.DisplayBox;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class View {

	// JavaFX Instance Variables
	private Scene scene;
	private Group root;
	
	// Boxes
	private ButtonBox buttonBox;
	private DisplayBox displayBox;
	
	private double width, height;
	
	// Width
	private double twentyPercentWidth, thirtyPercentWidth;
	private double buttonWidth;
	
	// Height
	private double fivePercentHeight, seventyFivePercentHeight, eightyFivePercentHeight;

	
	// Constructor and helpers
	public View(double width, double height) {
		
		configureSize(width, height);
		createSceneAndRoot();
		createBoxes();
		
	}
	
	private void configureSize(double width, double height) {

		this.width = width;
		this.height = height;

		// Width
		twentyPercentWidth = Doubles.TWENTY_PERCENT * width;
		thirtyPercentWidth = Doubles.THIRTY_PERCENT * width;
		buttonWidth = twentyPercentWidth * Doubles.NINETY_PERCENT;

		// Height
		fivePercentHeight = Doubles.FIVE_PERCENT * height;
		seventyFivePercentHeight = Doubles.SEVENTY_FIVE_PERCENT * height;
		eightyFivePercentHeight = Doubles.EIGHTY_FIVE_PERCENT * height;
		
	}
	
	private void createSceneAndRoot() {
		
		root = new Group();
		scene = new Scene(root, width, height, Color.GRAY);

	}

	private void createBoxes() {
		
		buttonBox = createButtonBox();
		root.getChildren().add(buttonBox);
		
		displayBox = createDisplayBox();
		root.getChildren().add(displayBox);
		
	}
	
	private ButtonBox createButtonBox() {

		ButtonBox returnButtonBox = new ButtonBox(width, Ints.BUTTON_OFFSET, buttonWidth);

		// Debugging
//		buttonBox.setStyle("-fx-border-style: solid;"
//				                + "-fx-border-width: 1;"
//				                + "-fx-border-color: black");

		
		returnButtonBox.setTranslateY(eightyFivePercentHeight);
		
		return returnButtonBox;

	}
	
	private DisplayBox createDisplayBox() {

		DisplayBox returnDisplayBox = new DisplayBox(width, thirtyPercentWidth, seventyFivePercentHeight, null, null);

		returnDisplayBox.setTranslateY(fivePercentHeight);

		return returnDisplayBox;
		
	}
	
	// Getters & Setters
	public Scene getSceneToDisplay() {
		return scene;
	}
	
	// All other instance methods
	public void handleSelectClicked() {

		File f = FileFinder.getFile();
		createNewDisplayBoxWithImage(f.getPath());

	}


	private Image readImageFromLocation(String location) {

		// load an image and resize it to width of 90% while preserving its
		// original aspect ratio, using faster filtering method
		// The image is downloaded from the supplied URL through http protocol
		return new Image("file:"+location, width * Doubles.NINETY_PERCENT, 0, false, false);

	}
	
}

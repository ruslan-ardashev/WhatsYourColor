package view;

import java.io.File;

import files.FileFinder;
import resources.constants.Doubles;
import resources.constants.Ints;
import util.AverageColorFinder;
import view.box.ButtonBox;
import view.box.DisplayBox;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public abstract class View {

	// Instance Variables
	private Scene scene;
	private BorderPane root;
	// Size
	private double width, height;
	// Width
	private double twentyPercentWidth, thirtyPercentWidth;
	private double buttonWidth;
	// Height
	private double fivePercentHeight, seventyFivePercentHeight, eightyFivePercentHeight;

	
	// Getters & Setters
	public Scene getSceneToDisplay() {
		return scene;
	}
	
	protected double width() {
		return this.width;
	}
	
	protected double height() {
		return this.height;
	}
	
	protected BorderPane root() {
		return this.root;
	}
	
	protected double thirtyPercentWidth() {
		return this.thirtyPercentWidth;
	}
	
	protected double buttonWidth() {
		return this.buttonWidth;
	}
	
	protected double fivePercentHeight() {
		return this.fivePercentHeight;
	}
	
	protected double seventyFivePercentHeight() {
		return this.seventyFivePercentHeight;
	}
	
	protected double eightyFivePercentHeight() {
		return this.eightyFivePercentHeight;
	}
	
	
	// Constructor and helpers
	public View(double width, double height) {
		
		configureSize(width, height);
		createSceneAndRoot();
		
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
		
		root = new BorderPane();
		scene = new Scene(root, width, height, Color.GRAY);

	}
	
}

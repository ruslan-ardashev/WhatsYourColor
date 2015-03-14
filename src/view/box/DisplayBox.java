package view.box;

import resources.constants.Doubles;
import resources.constants.Ints;
import view.box.util.GradientRectangleFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class DisplayBox extends Box {

	private double width, height;
	
	private StackPane stackPane;
	private VBox vBox;
	
	private GradientRectangleFactory gradientRectangleFactory;
	
	public DisplayBox(double parentWidth, double width, double height, Color color, Image image) {

		super(parentWidth);
		
		setSizeVariables(width, height);
		createFactories();
		createStackPane();
		createVBox();
		fillVBox(color);
		placeImage(image);
		
	}
	
	private void createFactories() {
		
		gradientRectangleFactory = new GradientRectangleFactory(width, height);
		
	}

	private void setSizeVariables(double width, double height) {

		this.width = width;
		this.height = height;

	}

	private void createStackPane() {

		stackPane = new StackPane();
		this.getChildren().add(stackPane);

	}

	private void createVBox() {
		
		vBox = new VBox(Ints.RECTANGLE_OFFSET);
		stackPane.getChildren().add(vBox);
		
		vBox.setPrefWidth(width);
		vBox.setPrefHeight(height);
		
//		 Debugging
		vBox.setStyle("-fx-border-style: solid;"
				                + "-fx-border-width: 1;"
				                + "-fx-border-color: black");
		
	}
	
	private void fillVBox(Color color) {
		
		gradientRectangleFactory.fillVBox(vBox, color);
		
	}

	private void placeImage(Image image) {

		ImageView imageView = new ImageView(image);
		
		imageView.setFitWidth(Doubles.FIFTY_PERCENT * width);
		imageView.setTranslateY(-height * Doubles.TWENTY_PERCENT);
		
		this.stackPane.getChildren().add(imageView);
	
	}
	
}

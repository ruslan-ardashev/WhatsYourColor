package view.box;

import resources.constants.Doubles;
import resources.constants.Ints;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DisplayBox extends Box {

	private double width, height;
	
	private VBox vBox;
	
	public DisplayBox(double parentWidth, double width, double height, Color color, Image image) {

		super(parentWidth);
		
		setSizeVariables(width, height);
		createVBox();
		fillVBox(color);
		createImage(image);
		
	}
	
	private void setSizeVariables(double width, double height) {
		
		this.width = width;
		this.height = height;
		
	}
	
	private void createVBox() {
		
		vBox = new VBox(Ints.RECTANGLE_OFFSET);
		this.getChildren().add(vBox);
		
		vBox.setPrefWidth(width);
		vBox.setPrefHeight(height);
		
//		 Debugging
		vBox.setStyle("-fx-border-style: solid;"
				                + "-fx-border-width: 1;"
				                + "-fx-border-color: black");
		
	}
	
	private void fillVBox(Color color) {
		
		double heightEachRectangle = (height - (Ints.NUMBER_RECTANGLES-1) * Ints.RECTANGLE_OFFSET) / Ints.NUMBER_RECTANGLES;
		
		double runningR = 1.0, runningG = 1.0, runningB = 1.0;
		double finalR, finalG, finalB;
		
		if (color != null) {
			finalR = color.getRed();
			finalG = color.getGreen();
			finalB = color.getBlue();
		} else {
			finalR = 0.0;
			finalG = 0.0;
			finalB = 0.0;
		}
		
		double incrementR = finalR - runningR / Ints.NUMBER_RECTANGLES;
		double incrementG = finalG - runningG / Ints.NUMBER_RECTANGLES;
		double incrementB = finalB - runningB / Ints.NUMBER_RECTANGLES;
		
		for (int i=0; i < Ints.NUMBER_RECTANGLES; i++) {
			
			Rectangle gradientRectangle = new Rectangle();
			
			gradientRectangle.setWidth(width);
			gradientRectangle.setHeight(heightEachRectangle);
			
			gradientRectangle.setFill(new Color(runningR, runningG, runningB, Doubles.ALPHA_VALUE));
			
			vBox.getChildren().add(gradientRectangle);
			
			runningR += incrementR;
			runningG += incrementG;
			runningB += incrementB;
			
		}

	}
	
	private void createImage(Image image) {

		// Default
		if (image == null) {
			placeDefaultImage();
		}

		// User-inputted Image
		else {
			placeUserImage(image);
		}
	
	}
	
	private void placeUserImage(Image image) {
//		throw new IllegalStateException("unimplemented placeUserImage in DisplayBox");
	}

	private void placeDefaultImage() {
//		throw new IllegalStateException("unimplemented placeDefaultImage in DisplayBox");
	}
	
}

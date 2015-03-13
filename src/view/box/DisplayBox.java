package view.box;

import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class DisplayBox extends Box {

	private double width, height;
	
	private VBox vBox;
	
	public DisplayBox(double parentWidth, double width, double height, Color color, Image image) {

		super(parentWidth);
		
		setSizeVariables(width, height);
		createVBox();
		fillVBox();
		createImage(image);
		
	}
	
	private void setSizeVariables(double width, double height) {
		
		this.width = width;
		this.height = height;
		
	}
	
	private void createVBox() {
		throw new IllegalStateException("unimplemented createVBox in DisplayBox");
	}
	
	private void fillVBox() {
		throw new IllegalStateException("unimplemented fillVBox in DisplayBox");
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
		throw new IllegalStateException("unimplemented placeUserImage in DisplayBox");
	}

	private void placeDefaultImage() {
		throw new IllegalStateException("unimplemented placeDefaultImage in DisplayBox");
	}
	
}

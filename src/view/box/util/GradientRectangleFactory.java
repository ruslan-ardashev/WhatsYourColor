package view.box.util;

import resources.constants.Doubles;
import resources.constants.Ints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GradientRectangleFactory {

	private VBox vBox;
	private Rectangle gradientRectangle;
	
	private double width, height;

	public GradientRectangleFactory(double width, double height) {

		this.width = width;
		this.height = height;

	}

	public void fillVBox(VBox vBox, Color color) {

		this.vBox = vBox;
		
		double heightEachRectangle = (height - (Ints.NUMBER_RECTANGLES-1) * Ints.RECTANGLE_OFFSET) / Ints.NUMBER_RECTANGLES;

		double[] rgb = populateRGBFromColor(color);											// 0->2 RGB color

		double[] startFinalRGB = populateStartAndFinalRGBFromColorFromRGB(color, rgb);		// 0->2 start, 3->5 final
		double[] incrementRGB = populateIncrementAmountsFromStartFinalRGB(startFinalRGB);

		for (int i=0; i < Ints.NUMBER_RECTANGLES; i++) {

			createRectangleWithHeightWithColorRGBAndAddToVBox(i, heightEachRectangle, startFinalRGB[0], startFinalRGB[1], startFinalRGB[2]);

			incrementRunningRGB(startFinalRGB, incrementRGB);

		}

	}

	private double[] populateRGBFromColor(Color color) {

		double[] returnArray = new double[3];

		if (color != null) {
			returnArray[0] = color.getRed();
			returnArray[1] = color.getGreen();
			returnArray[2] = color.getBlue();


		} else {
			returnArray[0] = 0.0;
			returnArray[1] = 0.0;
			returnArray[2] = 0.0;
		}

		return returnArray;

	}

	private double[] populateStartAndFinalRGBFromColorFromRGB(Color color, double[] rgb) {

		double[] returnArray = new double[6];											// 0->2 start, 3->5 final
		double[] absDifference = populateMaximumDeviationFromLimitsRGB(rgb);			// holds maximum deviation from either 0.0 or 1.0 for color
			
		for (int i=0; i < rgb.length; i++) {
			
			if (color != null) {
				returnArray[i] = rgb[i] - absDifference[i];
				returnArray[i+3] = rgb[i] + absDifference[i];
			} else {
				returnArray[i] = 0.0;
				returnArray[i+3] = 1.0;
			}

		}
		
		return returnArray;
		
	}
	
	private double[] populateMaximumDeviationFromLimitsRGB(double[] rgb) {
		
		double[] returnArray = new double[3];
		
		for (int i=0; i < returnArray.length; i++) {
			
			if (rgb[i] <= 0.5) {
				returnArray[i] = rgb[i];
			} else {
				returnArray[i] = 1.0-rgb[i];
			}
			
		}

		return returnArray;

	}

	private double[] populateIncrementAmountsFromStartFinalRGB(double[] startFinalRGB) {

		double[] returnArray = new double[3];

		for (int i=0; i < returnArray.length; i++) {
			returnArray[i] = (startFinalRGB[i+3] - startFinalRGB[i]) / Ints.NUMBER_RECTANGLES;
		}
		
		return returnArray;
		
	}
	
	private void createRectangleWithHeightWithColorRGBAndAddToVBox(double heightEachRectangle, double r, double g, double b) {
	private void incrementRunningRGB(double[] startFinalRGB, double[] incrementRGB) {
		
		startFinalRGB[0] += incrementRGB[0];
		startFinalRGB[1] += incrementRGB[1];
		startFinalRGB[2] += incrementRGB[2];
		
	}
	
	private void createRectangleWithHeightWithColorRGBAndAddToVBox(int index, double heightEachRectangle, double r, double g, double b) {
		
		gradientRectangle = new Rectangle();
		
		gradientRectangle.setWidth(width);
		gradientRectangle.setHeight(heightEachRectangle);
		
		gradientRectangle.setFill(new Color(r, g, b, Doubles.ALPHA_VALUE));
		
		vBox.getChildren().add(gradientRectangle);
		
	}
	

}

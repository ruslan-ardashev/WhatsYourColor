package view.paintChipView;

import java.io.File;

import resources.constants.Ints;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import files.FileFinder;
import util.AverageColorFinder;
import view.View;
import view.box.ButtonBox;
import view.box.DisplayBox;

public class NonFacebookPaintChipView extends View {

	// Boxes
	private ButtonBox buttonBox;
	private DisplayBox displayBox;

	public NonFacebookPaintChipView(double width, double height) {

		super(width, height);
		createBoxes();

	}

	private void createBoxes() {

		buttonBox = createButtonBox();
		root().getChildren().add(buttonBox);

		displayBox = createInitialDisplayBox();
		root().getChildren().add(displayBox);

	}
	
	private ButtonBox createButtonBox() {

		ButtonBox returnButtonBox = new ButtonBox(this, width(), Ints.BUTTON_OFFSET, buttonWidth());

		returnButtonBox.setTranslateY(eightyFivePercentHeight());
		
		return returnButtonBox;

	}
	
	private DisplayBox createInitialDisplayBox() {

		DisplayBox returnDisplayBox = new DisplayBox(width(), thirtyPercentWidth(), seventyFivePercentHeight(), null, null);

		returnDisplayBox.setTranslateY(fivePercentHeight());

		return returnDisplayBox;
		
	}

	// All other instance methods
	public void handleSelectClicked() {

		File f = FileFinder.getFile();

		if (f != null) {
			createNewDisplayBoxWithImage(f.getPath());
		}

	}

	private void createNewDisplayBoxWithImage(String path) {

		if (path != null) {

			// Read image
			Image image = readImageFromLocation(path);

			if (image != null) {

				root().getChildren().remove(displayBox);

				Color averageColor = AverageColorFinder.findAverageColorFromImage(image);

				displayBox = new DisplayBox(width(), thirtyPercentWidth(), seventyFivePercentHeight(), averageColor, image);	// (double parentWidth, double width, double height, Color color, Image image)
				displayBox.setTranslateY(fivePercentHeight());

				root().getChildren().add(displayBox);

			}

		}

	}

	private Image readImageFromLocation(String location) {

		// load an image and resize it to width of 90% while preserving its
		// original aspect ratio, using faster filtering method
		// The image is downloaded from the supplied URL through http protocol
		return new Image("file:"+location, 0, 0, false, false);

	}

}

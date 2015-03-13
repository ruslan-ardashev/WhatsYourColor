package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class View {

	private Scene scene;
	private Group root;
	
	public View(double width, double height) {
		
		root = new Group();
		scene = new Scene(root, width, height, Color.TAN);
		
	}

	public Scene getSceneToDisplay() {
		return scene;
	}
	
}

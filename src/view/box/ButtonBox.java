package view.box;

import view.box.util.ButtonFactory;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ButtonBox extends VBox {

	// JavaFX
	private Group parent;
	
	// Factories
	private ButtonFactory buttonFactory;
	
	// Sizing
	private double buttonWidth;
	
	
	// Constructor & Helpers
	// Also adds self to parent
	public ButtonBox(Group parent, int buttonOffset, double buttonWidth) {

		super(buttonOffset);
		this.parent = parent;
		this.parent.getChildren().add(this);
		
		this.setAlignment(Pos.BASELINE_CENTER);
		
		this.buttonWidth = buttonWidth;
		
		createFactories();
		createButtons();
		
	}

	private void createButtons() {
		
		createSelectImageButton();
		createResetButton();
		
	}
	
	private void createFactories() {
		
		this.buttonFactory = new ButtonFactory(this, buttonWidth);
		
	}
	
	private void createSelectImageButton() {
		
		Button selectImageButton = buttonFactory.createAndAddButtonWithText("#WhatsMyColor");
		
		
	}
	
	private void createResetButton() {
		
		Button resetButton = buttonFactory.createAndAddButtonWithText("Reset");
		
	}
	
}

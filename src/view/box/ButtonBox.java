package view.box;

import view.View;
import view.box.util.ButtonFactory;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ButtonBox extends Box {

	// Parent
	private View parentView;
	
	// Factories
	private ButtonFactory buttonFactory;
	
	// Sizing
	private double buttonWidth;
	
	
	// Constructor & Helpers
	// Also adds self to parent
	public ButtonBox(View parentView, double parentWidth, int buttonOffset, double buttonWidth) {

		super(parentWidth);
		
		this.parentView = parentView;
		
		this.buttonWidth = buttonWidth;
		
		createFactories();
		createButtons();
		
	}

	private void createButtons() {
		
		createSelectImageButton();
		
	}
	
	private void createFactories() {
		
		this.buttonFactory = new ButtonFactory(this, buttonWidth);
		
	}
	
	private void createSelectImageButton() {
		
		Button selectImageButton = buttonFactory.createAndAddButtonWithText("#WhatsMyColor");
		this.getChildren().add(selectImageButton);
		
		selectImageButton.setOnAction(e -> parentView.handleSelectClicked());
		
	}
	
}

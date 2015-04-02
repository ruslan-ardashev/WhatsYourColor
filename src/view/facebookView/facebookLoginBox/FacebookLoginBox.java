package view.facebookView.facebookLoginBox;

import javafx.scene.layout.Pane;

public class FacebookLoginBox extends Pane {
	
	// Instance Variables
	private FacebookLoginController parent;
	
	
	// Constructor & Helpers
	public FacebookLoginBox(FacebookLoginController parent) {
		
		configureParent(parent);
		
	}
	
	private void configureParent(FacebookLoginController parent) {
		this.parent = parent;
	}
	
	
	// All other instance methods
	

}

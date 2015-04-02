package view.facebookView;

import javafx.scene.image.ImageView;
import resources.OAuth.OAuth;

import view.View;
import view.facebookView.facebookLoginBox.FacebookLoginBox;
import view.facebookView.facebookLoginBox.FacebookLoginController;

public class FacebookView extends View implements FacebookLoginController {

	// Instance Variables
	// JavaFX
	private FacebookLoginBox facebookLoginBox;
	
	
	// Constructor & Helpers
	public FacebookView(double width, double height) {
		
		super(width, height);

		instantiateFacebookLoginBox();
		
		testPrintingUser();
		
	}
	
	private void instantiateFacebookLoginBox() {
		
		this.facebookLoginBox = new FacebookLoginBox(this);
		root().setCenter(facebookLoginBox);
		
	}
	
	
	// All other instance methods
	private void testPrintingUser() {
		
		
		
	}
	
}

package view.facebookView;

import view.View;
import view.facebookView.facebookLoginBox.FacebookLoginBox;
import view.facebookView.facebookLoginBox.FacebookLoginController;

public class FacebookView extends View implements FacebookLoginController {

	// Instance Variables
	private FacebookLoginBox facebookLoginBox;
	
	
	// Constructor & Helpers
	public FacebookView(double width, double height) {
		
		super(width, height);
		
		instantiateFacebookLoginBox();
		
	}
	
	private void instantiateFacebookLoginBox() {
		
		this.facebookLoginBox = new FacebookLoginBox(this);
		root().setCenter(facebookLoginBox);
		
	}
	
	
	// All other instance methods
	
	
}

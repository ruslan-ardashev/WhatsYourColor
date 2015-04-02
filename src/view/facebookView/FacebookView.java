package view.facebookView;

import view.View;
import view.facebookView.facebookLoginBox.FacebookLoginBox;

public class FacebookView extends View {

	// Instance Variables
	private FacebookLoginBox facebookLoginBox;
	
	
	// Constructor & Helpers
	public FacebookView(double width, double height) {
		
		super(width, height);
		
		instantiateFacebookLoginBox();
		
	}
	
	private void instantiateFacebookLoginBox() {
		
		this.facebookLoginBox = new FacebookLoginBox();
		root().setCenter(facebookLoginBox);
		
	}
	
	
	// All other instance methods
	
	
}

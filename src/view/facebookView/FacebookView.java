package view.facebookView;

import javafx.scene.image.ImageView;
import resources.OAuth.OAuth;

import com.restfb.*;
import com.restfb.types.User;

import view.View;
import view.facebookView.facebookLoginBox.FacebookLoginBox;
import view.facebookView.facebookLoginBox.FacebookLoginController;

public class FacebookView extends View implements FacebookLoginController {

	// Instance Variables
	// JavaFX
	private FacebookLoginBox facebookLoginBox;
	// RestFB
	private FacebookClient facebookClient;
	
	
	// Constructor & Helpers
	public FacebookView(double width, double height) {
		
		super(width, height);

		instantiateFacebookClient();
		instantiateFacebookLoginBox();
		
		testPrintingUser();
		
	}
	
	private void instantiateFacebookClient() {
		this.facebookClient = new DefaultFacebookClient(OAuth.OAuth, Version.VERSION_2_2);
	}
	
	private void instantiateFacebookLoginBox() {
		
		this.facebookLoginBox = new FacebookLoginBox(this);
		root().setCenter(facebookLoginBox);
		
	}
	
	
	// All other instance methods
	private void testPrintingUser() {
		
//		User user = facebookClient.fetchObject("me", User.class);
//		System.out.println("User name: "+user.getName()+", other: "+user.getPicture());
				
		Connection<User> photos = facebookClient.fetchConnection("me/photos", User.class,Parameter.with("fields", "data"));

		System.out.println(photos);
		
	}
	
}

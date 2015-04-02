import view.View;
import view.facebookView.FacebookView;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.stage.*;

public class WYC extends Application {

	private static double width, height;
	
	private Screen screen;
	private Stage stage;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		stage = primaryStage;
		primaryStage.setTitle("#WhatsYourColor");
		
		setStageToFillWindow();

		primaryStage.setScene(new FacebookView(width, height).getSceneToDisplay());
		primaryStage.show();
				
	}
	
	private void setStageToFillWindow() {
		
		screen = Screen.getPrimary();
	    Rectangle2D bounds = screen.getVisualBounds();
	    stage.setX(0);
	    stage.setY(0);
	    
	    width = bounds.getWidth();
	    height = bounds.getHeight();
	    
	    stage.setWidth(width);
	    stage.setHeight(height);

	}
	
	public static void main(String[] args) {
        launch(args);
    }
	
}

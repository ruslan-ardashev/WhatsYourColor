import view.View;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.stage.*;


public class WMC extends Application {

	private static double screenWidth;
	private static double screenHeight;
	
	private Screen screen;
	private Stage stage;
	
	public static double getScreenWidth() {
		
		return screenWidth;
		
	}
	
	public static double getScreenHeight() {
		
		return screenHeight;
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		stage = primaryStage;
		primaryStage.setTitle("Cell Society");
		
		setStageToFillWindow();

		View view = new View(screenWidth, screenHeight);
		primaryStage.setScene(view.getSceneToDisplay());
		primaryStage.show();
				
	}
	
	private void setStageToFillWindow() {
		
		screen = Screen.getPrimary();
	    Rectangle2D bounds = screen.getVisualBounds();
	    stage.setX(0);
	    stage.setY(0);
	    
	    screenHeight = bounds.getHeight();
	    screenWidth = bounds.getWidth();
	    
	    stage.setWidth(screenWidth);
	    stage.setHeight(screenHeight);

	}
	
	public static void main(String[] args) {
        launch(args);
    }
	
}

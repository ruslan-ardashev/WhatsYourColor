import view.View;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.stage.*;

public class WMC extends Application {

	private static double width, height;
	
	private Screen screen;
	private Stage stage;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		stage = primaryStage;
		primaryStage.setTitle("Cell Society");
		
		setStageToFillWindow();

		View view = new View(width, height);
		primaryStage.setScene(view.getSceneToDisplay());
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

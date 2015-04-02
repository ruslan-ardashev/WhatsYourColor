package testing;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

import view.facebookView.FacebookView;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;

/**
 * Ties together Facebook's Graph API, Nashorn JavaScripting, and JavaFX representation
 * 
 * @author Ruslan
 *
 */
public class FacebookNashornJavaFXTester extends Application {

	// Static Variables
	private static double width, height;
	private static NashornScriptEngineFactory nashornScriptEngineFactory = new NashornScriptEngineFactory();
	private static ScriptEngine scriptEngine = nashornScriptEngineFactory.getScriptEngine(new String[] {"--global-per-engine"});

	// Instance Variables
	private Screen screen;
	private Stage stage;


	// Static Methods
	public static void main(String[] args) {
		launch(args);
	}


	// Instance Methods
	@Override
	public void start(Stage primaryStage) throws Exception {

		test();

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

	private void test() {

		FacebookJavaScriptRunner facebookJavaScriptRunner = new FacebookJavaScriptRunner();

		try {
			facebookJavaScriptRunner.run();
		} catch (ScriptException e) {
			// Silently fail
		}

	}

	private class FacebookJavaScriptRunner {

		public void run() throws ScriptException {

			scriptEngine.eval("java.lang.System.out.println('hello world!')");
			scriptEngine.eval("function sum(a, b) { return a + b; }");
			System.out.println(scriptEngine.eval("sum(1, 2);"));

			/**
			 * Example of how to use a .js file
			 */
			//		    engine.eval(new FileReader("src/sample1/greeter.js"));
			//		    System.out.println(invocable.invokeFunction("greet", "Julien"));

			

		}

	}

}

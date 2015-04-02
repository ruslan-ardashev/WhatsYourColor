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

//		stage = primaryStage;
//		primaryStage.setTitle("Testing");
//
//		setStageToFillWindow();
//
//		primaryStage.setScene(new FacebookView(width, height).getSceneToDisplay());
//		primaryStage.show();
		
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
			System.out.println(e);
		}

	}

	private class FacebookJavaScriptRunner {

		public void run() throws ScriptException {

			scriptEngine.eval("load('fx:base.js');");
			
			scriptEngine.eval("java.lang.System.out.println('hello world!')");
			scriptEngine.eval("function sum(a, b) { return a + b; }");
			System.out.println(scriptEngine.eval("sum(1, 2);"));
			
			/**
			 * Example of how to use a .js file
			 */
			//		    engine.eval(new FileReader("src/sample1/greeter.js"));
			//		    System.out.println(invocable.invokeFunction("greet", "Julien"));
			
			
			scriptEngine.eval("load('fx:base.js'); load('fx:controls.js'); load('fx:graphics.js');");
			scriptEngine.eval("var stage = new createjs.Stage(canvas);");
			scriptEngine.eval("var root = new Group();");
			scriptEngine.eval("var scene = new Scene(root, 800, 400, true); scene.fill = Color.rgb(127, 127, 127); scene.camera = new PerspectiveCamera(false); stage.scene = scene; stage.show();");
			
//			Passing Java objects to Nashorn interpreter
//			The way that Nashorn handles the binding between Java and JavaScript contexts is simpler than in Rhino. 
//			There is no need to setup or manipulate JavaScript contexts and create wrapping objects, just:
//
//			instantiate a Bindings object, a Map like class (line 4),
//			add the Java objects with a proper name (line 20),
//			and finally set the Bindings object into the engine in the proper scope (line 10).
			
//			private static void putJavaVariablesIntoEngine(ScriptEngine engine,
//			        List variables) {
//			 
//			    Bindings bindings = new SimpleBindings();
//			 
//			    for (EcmaVariable variable : variables) {
//			        putJavaVariableIntoEcmaScope(bindings, variable);
//			    }
//			 
//			    engine.setBindings(bindings, ScriptContext.GLOBAL_SCOPE);
//			}
//			 
//			private static void putJavaVariableIntoEcmaScope(Bindings bindings,
//			        EcmaVariable variable) {
//			 
//			    String variableName = variable.getName();
//			    EcmaValue ecmaValue = variable.getValue();
//			    Object javaValue = ecmaValue.getValue();
//			 
//			    bindings.put(variableName, javaValue);
//			}
			
		}

	}

}

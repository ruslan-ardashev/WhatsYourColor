package files;

import java.io.File;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileFinder {

	private static FileChooser fileChooser = new FileChooser();
	
	public static File getFile() {
		
		return fileChooser.showOpenDialog(new Stage());
		
	}
	
}

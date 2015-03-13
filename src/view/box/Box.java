package view.box;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class Box extends HBox {

	public Box(double parentWidth) {
		
		this.setMinWidth(parentWidth);
		this.setMaxWidth(parentWidth);
		
		this.setAlignment(Pos.CENTER);
		
	}
	
}

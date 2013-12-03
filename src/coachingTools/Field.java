package coachingTools;

import util.Rectangle;
import graphics.frontend.BackgroundImage;

public class Field extends BackgroundImage {
	
	public Field() {
		super();
		//creates a rectangle for the backgroundImage and imposes a .png image on it to create the field
		new BackgroundImage(new Rectangle(-.15f, .0f, 1.7f, 2.0f), "resources/field.png");
	}
	
}

package application;
import java.util.*;
import javafx.scene.shape.Rectangle;

public class FreefallNodeModel extends Thread{
	
	ArrayList<Rectangle> rectangleList;
	
	public FreefallNodeModel() {
		rectangleList = new ArrayList<Rectangle>();
	}
	
	public void createNewRectangle() {
		
	}
	
	public Rectangle getRectangle() {
		
		if(!rectangleList.isEmpty()) {
			Rectangle r = rectangleList.remove(0);
			
			return r;
		} else {
			return null;
		}
	}
}

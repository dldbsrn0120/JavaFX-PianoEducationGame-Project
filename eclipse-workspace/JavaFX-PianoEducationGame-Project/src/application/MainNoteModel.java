package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.*;

public class MainNoteModel {

	private ArrayList<TimerRectangle> rectangleList;

	public MainNoteModel() {
		rectangleList = new ArrayList<TimerRectangle>();		
	}
	
	public void createNewRectangle() {
		TimerRectangle r = new TimerRectangle(25,25,Color.GREEN);
		
		rectangleList.add(r);
	}
	
	public ArrayList<TimerRectangle> getRectangleList() {
		return this.rectangleList; 
	}
	
	public TimerRectangle getTimerRectangle() {
		if(!this.rectangleList.isEmpty()) {
			TimerRectangle r = rectangleList.remove(0);
			
			return r;
		}
		else {
			return null;
		}
	}
	
	public void initializeTimerRectangleList() {
		//rectangleList.removeAll(ArrayList<Rectangle>);
	}
}

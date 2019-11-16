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
		TimerRectangle r = new TimerRectangle(10,20,Color.GREEN);
		
		rectangleList.add(r);
	}
	
	public void createNewRectangle(int idx) {
		TimerRectangle r = new TimerRectangle(10,20,Color.GREEN,idx);
		
		rectangleList.add(r);
	}
	
	public void createNewRectangle(int idx, int x1, int x, int y) {
		TimerRectangle r = new TimerRectangle(15, 30, Color.HOTPINK ,idx, x1, x, y);
		
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
	
	public void setTimerRectangle(TimerRectangle r) {
		rectangleList.add(r);
	}
	
	public void initializeTimerRectangleList() {
		//rectangleList.removeAll(ArrayList<Rectangle>);
		
	}
}

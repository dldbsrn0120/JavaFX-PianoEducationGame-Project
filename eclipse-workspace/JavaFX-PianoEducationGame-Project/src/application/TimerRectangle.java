package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TimerRectangle extends Rectangle {

	private int index;
	private int thisx, thisy;
	private int x1;
	
	public TimerRectangle(int width, int height, Color color) {
		super(width, height, color);
		this.setTranslateX(0);
		this.setTranslateY(0);
	}
	
	public TimerRectangle(int width, int height, Color color, int idx) {
		super(width, height, color);
		index = idx;
	}
	
	public TimerRectangle(int width, int height, Color color, int idx, int x1, int X, int Y) {
		super(width, height, color);
		index = idx;
		setX1(x1);
		setThisx(X);
		setThisy(Y);
	}
	
	public void FallRectangle() {
		this.moveDown();
	}
	
	public void moveDown() {
		this.setTranslateY(this.getTranslateY() + 1);
	}

	public int getThisx() {
		return thisx;
	}

	public void setThisx(int thisx) {
		this.thisx = thisx;
	}

	public int getThisy() {
		return thisy;
	}

	public void setThisy(int thisy) {
		this.thisy = thisy;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}
	
	public void setColor(Color color) {
		super.setFill(color);
	}
}

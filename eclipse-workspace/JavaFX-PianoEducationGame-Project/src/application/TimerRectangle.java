package application;

import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TimerRectangle extends Rectangle {

	private double time;
	private AnimationTimer timer;
	
	public TimerRectangle(int width, int height, Color color) {
		super(width, height, color);
		time = 0;
	}
	
	public void FallNodes() {
		try {
			timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				update();
			}
		};
		timer.start();
		
		} catch(NullPointerException e) {
			
		}
	}
	
	public void update() {
		moveDown();
		
		time += 1;
		if(time % 10 == 0)
			System.out.println(time);
		if(time > 50) {
			stopTimer();
			return;
		}
	}
	
	public void stopTimer() {
		timer.stop();
		time = 0;
	}
	
	public void moveDown() {
		this.setTranslateY(this.getTranslateY() + 1);
	}

}

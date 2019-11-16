package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VirtualKeyboard {
	private Rectangle[] rects;
	
	public VirtualKeyboard() {
		rects = new Rectangle[88];
		for(int i=0; i<88; i++) {
			rects[i] = new Rectangle();
		}
		createVirtualKbds();
	}
	
	public void createVirtualKbds() {
		// use i, j, k
		
		// i=0,1,2,87; set manually;
		
		rects[1].setFill(Color.BLACK);
		rects[1].setWidth(18);
		rects[1].setHeight(60);
		rects[1].setTranslateX(11);
	
		rects[0].setFill(Color.WHITE);
		rects[0].setWidth(20);
		rects[0].setHeight(100);
		rects[0].setStroke(Color.BLACK);
		rects[0].setTranslateX(0);
		
		rects[2].setFill(Color.WHITE);
		rects[2].setWidth(20);
		rects[2].setHeight(100);
		rects[2].setStroke(Color.BLACK);
		rects[2].setTranslateX(20);
		
		rects[87].setFill(Color.WHITE);
		rects[87].setWidth(20);
		rects[87].setHeight(100);
		rects[87].setStroke(Color.BLACK);
		rects[87].setTranslateX(1300);

		// i=3, 15, ... 75
		for(int j=0; j<7; j++) {			
			for(int k = 0; k < 12; k++) {
				int i = 3 + j * 12 + k;
				int xpos = 0;
				switch(k % 12) {
				case 0: case 2: case 4: case 5: case 7: case 9: case 11:
				rects[i].setFill(Color.WHITE);
				rects[i].setWidth(26);
				rects[i].setHeight(100);
				rects[i].setStroke(Color.BLACK);
				if(k % 12 == 0)
					xpos = 40 + j * 180;
				if(k % 12 == 2)
					xpos = 40 + j * 180 + 26;
				if(k % 12 == 4)
					xpos = 40 + j * 180 + 26 * 2;
				if(k % 12 == 5)
					xpos = 40 + j * 180 + 26 * 2 + 25 * 1;
				if(k % 12 == 7)
					xpos = 40 + j * 180 + 26 * 3 + 25 * 1;
				if(k % 12 == 9)			
					xpos = 40 + j * 180 + 26 * 3 + 25 * 2;
				if(k % 12 == 11)
					xpos = 40 + j * 180 + 26 * 4 + 25 * 2;
					rects[i].setTranslateX(xpos);
					break;
				default:
					break;
				}
			}
			
			for(int k = 0; k < 12; k++) {
				int i = 3 + j * 12 + k;
				int xpos = 0;
				switch(k % 12) {
				case 1:
				case 3:
				case 6:
				case 8:
				case 10:
					rects[i].setFill(Color.BLACK);
					rects[i].setWidth(18);
					rects[i].setHeight(60);
					rects[i].setStroke(Color.BLACK);
					if(k % 12 == 1)
						xpos = 40 + j * 180 + 17;
					if(k % 12 == 3)
						xpos = 40 + j * 180 + 43;
					if(k % 12 == 6)
						xpos = 40 + j * 180 + 95;
					if(k % 12 == 8)
						xpos = 40 + j * 180 + 121;
					if(k % 12 == 10)
						xpos = 40 + j * 180 + 147;
						rects[i].setTranslateX(xpos);
					break;
				default:
					break;
				}
			}
		}
	}

	public Rectangle[] getRects() {
		return rects;
	}
	
	public Rectangle getRects(int index) {
		return rects[index];
	}
}

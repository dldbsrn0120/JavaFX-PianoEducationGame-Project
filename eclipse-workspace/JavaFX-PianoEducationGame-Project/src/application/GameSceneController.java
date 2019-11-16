package application;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.midi.ShortMessage;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameSceneController {
	
	private MidiModel midiModel;
	private MainNoteModel mainNoteModel;
	
	@FXML private AnchorPane fallnotepane;
	@FXML private AnchorPane judgepane;
	@FXML private AnchorPane virtualKeyboard;

	protected VirtualKeyboard virtualKeyboardInstance;
	
	private int numberOfRectangles;
	private int countOfNodes;

	private Timeline timeline = null;
	protected ArrayList<TimerRectangle> reclist;
	
	private GameSceneListener gameSceneListener;
	
	private Rectangle[] pianoRectangleArr;
	
	public GameSceneController() {
		gameSceneListener = new GameSceneListener(this);
		midiModel = new MidiModel(gameSceneListener);
		reclist = new ArrayList<TimerRectangle>();		
		virtualKeyboardInstance = new VirtualKeyboard();
		System.out.println("Constructed");
		manuallySetModel();
	}
	
	public GameSceneController(MainNoteModel mainNoteModel) {
		gameSceneListener = new GameSceneListener(this);
		midiModel = new MidiModel(gameSceneListener);
		reclist = new ArrayList<TimerRectangle>();	

		this.mainNoteModel = mainNoteModel;
		System.out.println("Constructed");
		createNotes();
	}
	
	public void manuallySetModel()
	{
		mainNoteModel = new MainNoteModel();
		createNotes();
	}

	public void setViewVirtualKeyboard() {
		pianoRectangleArr = virtualKeyboardInstance.getRects();
		
		Rectangle rect1 = pianoRectangleArr[0];
		rect1.setTranslateY(0);
		virtualKeyboard.getChildren().add(rect1);
		
		Rectangle rect2 = pianoRectangleArr[2];
		rect2.setTranslateY(0);
		virtualKeyboard.getChildren().add(rect2);
		
		Rectangle rect3 = pianoRectangleArr[1];
		rect3.setTranslateY(0);
		virtualKeyboard.getChildren().add(rect3);
		
		Rectangle rect4 = pianoRectangleArr[87];
		rect4.setTranslateY(0);
		virtualKeyboard.getChildren().add(rect4);
		
		for(int i=3; i<pianoRectangleArr.length - 1; i++) {
			int j=(i-3) % 12;
			if(j != 1 && j != 3 && j != 6 && j != 8 && j != 10) { 
				Rectangle rect = pianoRectangleArr[i];
				rect.setTranslateY(0);
				virtualKeyboard.getChildren().add(rect);
			}
		}
		
		for(int i=3; i<pianoRectangleArr.length - 1; i++) {
			int j=(i-3) % 12;
			if(j == 1 || j == 3 || j == 6 || j == 8 || j == 10) {
				Rectangle rect = pianoRectangleArr[i];
				rect.setTranslateY(0);
				virtualKeyboard.getChildren().add(rect);
			}
		}
	}
	
	public void createNotes() {
		setSampleRectangleData(1,60,1);
		setSampleRectangleData(2,62,2);
		setSampleRectangleData(3,61,3);
		setSampleRectangleData(4,63,4);
		setSampleRectangleData(5,64,5);
		setSampleRectangleData(6,66,6);
		setSampleRectangleData(7,75,7);
		setSampleRectangleData(8,72,10);
		setSampleRectangleData(9,60,11);
		setSampleRectangleData(10,62,12);
		setSampleRectangleData(11,61,13);
		setSampleRectangleData(12,63,14);
		setSampleRectangleData(13,64,15);
		setSampleRectangleData(14,66,16);
		setSampleRectangleData(15,75,17);
		setSampleRectangleData(16,72,20);
		setSampleRectangleData(17,51,30);
		setSampleRectangleData(18,60,31);
		setSampleRectangleData(19,62,42);
		setSampleRectangleData(20,61,43);
		setSampleRectangleData(21,63,54);
		setSampleRectangleData(22,64,55);
		setSampleRectangleData(23,66,66);
		setSampleRectangleData(24,75,67);
		setSampleRectangleData(25,72,80);
	}
	
	public void setSampleRectangleData(int idx, int x, int y) {
		mainNoteModel.createNewRectangle(idx, x, (x - 16) * 15, y * 10);
	}
	
	@FXML
	private void startSample() {
		if(timeline != null) {
			stopTimer();
		}
		
		countOfNodes = 0;
		setTimer();
		startTimer();
	}
	
	@FXML
	private void startGame() {		
		for(TimerRectangle r : reclist) {		
			if(r.getTranslateY() < 300) {
				r.moveDown();
			} else { 
				r.setVisible(false);
				mainNoteModel.setTimerRectangle(r);
				countOfNodes += 1;
			}
		}
	}
	
	public void printInfoRect() {
		for(int i=0; i<88; i++) {
			System.out.println(pianoRectangleArr[i].toString());
		}
	}
	
	@FXML
	private void setTimer() {	
		setViewVirtualKeyboard();
		printInfoRect();
		System.out.println("aa : " + mainNoteModel.getRectangleList().size());
		numberOfRectangles = mainNoteModel.getRectangleList().size();
		for(int i=0; i<numberOfRectangles; i++) {
			TimerRectangle r = mainNoteModel.getTimerRectangle();
			System.out.println(i);
			if(r == null) {
				return;
			}
			else {
				reclist.add(r);
				r.setTranslateX(r.getThisx());
				r.setTranslateY(r.getThisy()*(-1));
				fallnotepane.getChildren().add(r);
				r.FallRectangle();
			}
		}
		
		timeline = new Timeline(new KeyFrame(
				Duration.millis(20),
				e -> startGame()));	
		timeline.setCycleCount(1100);
		}
	
	@FXML
	private void startTimer() { 
		if(timeline != null) {
			timeline.play();
		}
	}
	
	@FXML
	private void stopTimer() {
		if(timeline != null) {
			timeline.stop();
		}
	}
	
	@FXML
	private void exitProgram() {
		System.exit(0);
	}
	
	public class GameSceneListener implements PropertyChangeListener{

		GameSceneController gsc;
		
		public GameSceneListener(GameSceneController gsc) {
			this.gsc = gsc;
		}
		
		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			// TODO Auto-generated method stub
			
			ShortMessage s = (ShortMessage) evt.getNewValue();
			int ds = s.getCommand();
			int d1 = s.getData1();
			
			for(TimerRectangle i : gsc.reclist) {		
				if(ds == 0x90) {
					if(d1 - 21 >= 0 && d1 - 21 < 88)
						pianoRectangleArr[d1 - 21].setFill(Color.ORANGE);
					if(i.getX1() == d1) {
						if(i.getTranslateY() < 250) {
							i.setColor(Color.HOTPINK);
						} else {
							i.setColor(Color.AQUA);
						}
					}
				}			
				else if(ds == 0x80) {
					
					if(d1 - 21 >= 0 && d1 - 21 < 88) {										
						int j = (d1 - 24) % 12;
						
						if(j == 1 || j == 3 || j == 6 || j == 8 || j == 10)  {
							pianoRectangleArr[d1 - 21].setFill(Color.BLACK);
						} else {
							pianoRectangleArr[d1 - 21].setFill(Color.WHITE);
						}
					}
					if(i.getX1() == d1) {
						if(i.getTranslateY() < 250) {
							i.setColor(Color.HOTPINK);
						} else {
							i.setColor(Color.BLUE);
						}		
					}
				}		
			}
		}

	}
}

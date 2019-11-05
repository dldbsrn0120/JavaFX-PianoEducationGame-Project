package application;

import javafx.fxml.FXML;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;

public class MainController{

	private double time;
	private MainModel mainModel;
	private MainNoteModel mainNoteModel;
	
	@FXML private HBox freefall_1;
	@FXML private Label numlabel;
	@FXML private GridPane gridpane;
	
	public MainController() {
		time = 0;
		mainModel = new MainModel();
		mainNoteModel = new MainNoteModel();
	}
	
	@FXML
	private void btn_1_clicked() {
		mainModel.increaseSharedData();
		int data = mainModel.getSharedData();
		numlabel.setText(Integer.toString(data));
	}
	
	@FXML
	private void btn_2_clicked() {
		mainModel.decreaseSharedData();
		int data = mainModel.getSharedData();
		numlabel.setText(Integer.toString(data));
	}
	
	@FXML
	private void btn_3_clicked() {
		mainModel.multiplySharedData();
		int data = mainModel.getSharedData();
		numlabel.setText(Integer.toString(data));
	}
	
	@FXML
	private void btn_4_clicked() {
		int data = mainModel.getSharedData();
		System.out.println(data);
	}
	
	@FXML
	private void btn_5_clicked() {
		mainNoteModel.createNewRectangle();
	}
	
	@FXML
	private void btn_6_clicked() {
		Rectangle r = mainNoteModel.getTimerRectangle();
		if(r == null) return;
		else System.out.println("getRectangle");
		
		r.setTranslateX(Math.random() * 4);
		r.setTranslateY(Math.random() * 4);
		
		freefall_1.getChildren().add(r);
	}
	
	@FXML
	private void btn_7_clicked() {
		TimerRectangle r = mainNoteModel.getTimerRectangle();
		if(r == null) {
			System.out.println("no Node");
			return;
		}
		else {
			freefall_1.getChildren().add(r);
			FallNodes(r);
		}
	}

	public void FallNodes(TimerRectangle r) {
		r.FallNodes();
	}
}

package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainController{

	private MainModel mainModel;
	private MainNoteModel mainNoteModel;
	private NextController nextController;
	
	private Stage linkstage;
	private Parent nextParent;
	
	private double xmoving = 0;
	
	@FXML private HBox freefall_1;
	@FXML private Label numlabel;
	@FXML private AnchorPane anchorpane;
	
	public MainController() {
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
		
		anchorpane.getChildren().add(r);
	}
	
	@FXML
	private void btn_7_clicked() {
		TimerRectangle r = mainNoteModel.getTimerRectangle();
		
		if(r == null) {
			return;
		}
		else {
			xmoving += 25;
			if(xmoving > 1000) xmoving = 0;
			r.setTranslateX(xmoving);
			anchorpane.getChildren().add(r);
			FallNodes(r);
		}
	}
	
	@FXML
	private void gotonextbutton_clicked(ActionEvent e) throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("NextView.fxml"));
			nextParent = loader.load();
			
			//if(nextController == null)
			nextController = new NextController();
			
			Scene scene = new Scene(nextParent,600,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			linkstage = (Stage) (((Node)e.getSource()).getScene().getWindow()); // 장면전환
			linkstage.setScene(scene);
			linkstage.show();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public void FallNodes(TimerRectangle r) {
		r.FallNodes();
	}
}

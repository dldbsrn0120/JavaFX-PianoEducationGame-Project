package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class NextController implements Initializable {
	
	private MidiModel midiModel;
	
	@FXML private AnchorPane nextfirstpane;
	
	@FXML private Button button;
	@FXML private Circle sound1;
	@FXML private Circle sound2;
	@FXML private Circle sound3;
	@FXML private Circle sound4;
	@FXML private Circle sound5;
	@FXML private Circle sound6;
	@FXML private Circle sound7;
	@FXML private Circle sound8;
	@FXML private Circle sound9;
	@FXML private Circle sound10;
	@FXML private Circle sound11;
	@FXML private Circle sound12;	
	@FXML private Circle sound13;
	
	public NextController() {
		midiModel = new MidiModel();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		nextfirstpane.setOnKeyPressed(e -> {
		    if (e.getCode() == KeyCode.A) {
		    	sound1.setFill(Color.RED);
		    } else if (e.getCode() == KeyCode.W) {
		    	sound2.setFill(Color.RED);
		    } else if (e.getCode() == KeyCode.S) {
		    	sound3.setFill(Color.RED);
		    } else if (e.getCode() == KeyCode.E) {
		    	sound4.setFill(Color.RED);
		    } else if (e.getCode() == KeyCode.D) {
		    	sound5.setFill(Color.RED);
		    } else if (e.getCode() == KeyCode.F) {
		    	sound6.setFill(Color.RED);
		    } else if (e.getCode() == KeyCode.T) {
		    	sound7.setFill(Color.RED);
		    } else if (e.getCode() == KeyCode.G) {
		    	sound8.setFill(Color.RED);
		    } else if (e.getCode() == KeyCode.Y) {
		    	sound9.setFill(Color.RED);
		    } else if (e.getCode() == KeyCode.H) {
		    	sound10.setFill(Color.RED);
		    } else if (e.getCode() == KeyCode.U) {
		    	sound11.setFill(Color.RED);
		    } else if (e.getCode() == KeyCode.J) {
		    	sound12.setFill(Color.RED);
		    } else if (e.getCode() == KeyCode.K) {
		    	sound13.setFill(Color.RED);
		    } 
		});
		
		nextfirstpane.setOnKeyReleased(e -> {
		    if (e.getCode() == KeyCode.A) {
		    	sound1.setFill(Color.DARKRED);
		    } else if (e.getCode() == KeyCode.W) {
		    	sound2.setFill(Color.DARKRED);
		    } else if (e.getCode() == KeyCode.S) {
		    	sound3.setFill(Color.DARKRED);
		    } else if (e.getCode() == KeyCode.E) {
		    	sound4.setFill(Color.DARKRED);
		    } else if (e.getCode() == KeyCode.D) {
		    	sound5.setFill(Color.DARKRED);
		    } else if (e.getCode() == KeyCode.F) {
		    	sound6.setFill(Color.DARKRED);
		    } else if (e.getCode() == KeyCode.T) {
		    	sound7.setFill(Color.DARKRED);
		    } else if (e.getCode() == KeyCode.G) {
		    	sound8.setFill(Color.DARKRED);
		    } else if (e.getCode() == KeyCode.Y) {
		    	sound9.setFill(Color.DARKRED);
		    } else if (e.getCode() == KeyCode.H) {
		    	sound10.setFill(Color.DARKRED);
		    } else if (e.getCode() == KeyCode.U) {
		    	sound11.setFill(Color.DARKRED);
		    } else if (e.getCode() == KeyCode.J) {
		    	sound12.setFill(Color.DARKRED);
		    } else if (e.getCode() == KeyCode.K) {
		    	sound13.setFill(Color.DARKRED);
		    } 
		});
	}
}

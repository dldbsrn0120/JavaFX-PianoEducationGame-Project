package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	
	private MainController mainController;
	private NextController nextController;
	private GameSceneController gamescenecontroller;
	
	private MainModel mainModel;
	private MainNoteModel mainNoteModel;

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("MainView.fxml"));
			BorderPane root = (BorderPane) loader.load();
			
			mainModel = new MainModel();
			mainNoteModel = new MainNoteModel();
			
			mainController = new MainController(mainModel, mainNoteModel);
			nextController = new NextController();
			gamescenecontroller = new GameSceneController(mainNoteModel);
			
			Scene scene = new Scene(root,500,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

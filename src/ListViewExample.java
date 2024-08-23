import java.util.Random;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ListViewExample extends Application {

	private ListView<String> exampleLV;
	private ObservableList<String> items ;
	private Button addAnother;
	private Button removeSelected;
	
	@Override
	public void start(Stage primaryStage) {
		Pane root = new Pane();

		exampleLV = new ListView<String>();
		items = exampleLV.getItems();
		exampleLV.getItems().add("First");
		items.add("First");
		items.add("Second");
		items.add("Third");
		
		addAnother = new Button ("Add New Item");
		addAnother.setLayoutX(250);  addAnother.setLayoutY(0);
		addAnother.setOnAction(new AddItemHandler());
		
		removeSelected = new Button ("Remove Selected");
		removeSelected.setLayoutX(250); removeSelected.setLayoutY(50);
		removeSelected.setOnAction(new RemoveItemHandler());
		
		root.getChildren().addAll(exampleLV,addAnother, removeSelected);
		
		Scene scene = new Scene(root, 600, 200);
		primaryStage.setTitle("FX ListView Example");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
		
	private class AddItemHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			items.add("New Item From Button");
		}
	}
	
	private class RemoveItemHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
		    int toRemove =5;
		    		String i = exampleLV.getSelectionModel().getSelectedItem();
			
			if ( i != null)
				exampleLV.getItems().remove(8);
		
		
		}
	}	
	
	
}




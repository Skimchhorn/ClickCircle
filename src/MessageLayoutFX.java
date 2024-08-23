import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.awt.TextArea;


public class MessageLayoutFX extends Application {
	private final String initialMessage="Hello, World";
	private final int fontSize = 72;
	private TextField messageTextField;
	private CheckBox boldCheckBox;
	private RadioButton noLineRB;
	private RadioButton underlineRB;
	private RadioButton strikeThroughRB;
	private ToggleGroup textLineGroup;	
	private Text message;
	
@Override
public void start(Stage primaryStage) {
	
	message = new Text(20,85,initialMessage);
	message.setFont(Font.font("Arial",fontSize));
	Text message1 = new Text(20,85,initialMessage);
	VBox j = new VBox(1, message);
	VBox h = new VBox(1, message1);
	Pane messagePane = new Pane();
//	messagePane.setPrefWidth(500);
//	messagePane.setPrefHeight(100);
//	message = new Text(20,85,initialMessage);
//	message.setFont(Font.font("Arial",fontSize));
//	messagePane.getChildren().add(message);
////    messagePane.setPadding(new Insets(200,90,90,90));
	messageTextField = new TextField(initialMessage);
//	messageTextField.setPrefWidth(100);
//	messageTextField.setPrefHeight(100);
	Button updateMessageButton = new Button("Update Message");

	boldCheckBox = new CheckBox("Bold");
	boldCheckBox.setSelected(true);
	message.setFont(Font.font("Arial", FontWeight.BOLD,fontSize));
	
	noLineRB = new RadioButton("No Line");
	underlineRB = new RadioButton("Underline");
	strikeThroughRB = new RadioButton("Strikethrough");
	VBox leftSide = new VBox(5,boldCheckBox,noLineRB, underlineRB, strikeThroughRB);

	textLineGroup = new ToggleGroup();
	noLineRB.setToggleGroup(textLineGroup);
	underlineRB.setToggleGroup(textLineGroup);
	strikeThroughRB.setToggleGroup(textLineGroup);
	textLineGroup.selectToggle(noLineRB);		
	
	MessageEventHandler meh = new MessageEventHandler();
	updateMessageButton.setOnAction(meh);
	messageTextField.setOnAction(meh);
	boldCheckBox.setOnAction(meh);
	noLineRB.setOnAction(meh);
	underlineRB.setOnAction(meh);
	strikeThroughRB.setOnAction(meh);

	BorderPane root = new BorderPane();
	root.setCenter(j);
	root.setTop(messageTextField);
	root.setBottom(updateMessageButton);
	updateMessageButton.setAlignment(Pos.CENTER);
	root.setLeft(h);
	root.setRight(leftSide);
	
	root.setPadding( new Insets(50));
	BorderPane.setMargin(messageTextField , new Insets(50,100,50,100));
	messageTextField.setPadding(new Insets(50,0,50,0));
//	noLineRB.setPadding(new Insets(5,5,5,5));
//	VBox.setMargin(noLineRB, new Insets(10));

	Scene scene = new Scene(root);
	primaryStage.setTitle("FX Custom Text Message");
	primaryStage.setScene(scene);
	primaryStage.show();
}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
		
	private class MessageEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			message.setText(messageTextField.getText());
			FontWeight fw = FontWeight.NORMAL;
			if (boldCheckBox.isSelected()) {
				fw = FontWeight.BOLD;
			}
			message.setFont(Font.font("Arial",fw,fontSize));
			
			message.setStrikethrough(strikeThroughRB.isSelected());
			message.setUnderline(underlineRB.isSelected());				
		}
	}
}




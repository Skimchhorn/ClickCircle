package testttiing;

import java.util.ArrayList;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
public class clickCircle extends Application{
    private Pane root;
    private Ellipse circle1;
    private int counttimer=0 , count = 0 ;
    private Random rand = new Random();
    private ArrayList<Ellipse> circleList;
    private Text textDisplay;
    private boolean endPoint;
    private Button startButton;
    private animationHandler i;
    private boolean ending = false;
	@Override
	public void start(Stage primaryStage) throws Exception {
		root = new Pane();
        circleList= new ArrayList<Ellipse>();
		circle1 = new Ellipse(200,300,20,20);
		circle1.setOnMouseClicked(new clickEventHandler());
	    textDisplay = new Text(20,60,"Game Started");
		textDisplay.setFill(Color.GRAY);
		textDisplay.setFont(Font.font(30));
		circleList.add(circle1);
		
		startButton = new Button("START");
		startButton.setLayoutX(0);
		startButton.setLayoutY(0);
		startButton.setOnAction(new startEventHandler());
		root.getChildren().addAll(textDisplay,startButton);
		Scene scene = new Scene(root,400,600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ClickCircle");
		primaryStage.show();
	}
    
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	
	private class clickEventHandler implements EventHandler<MouseEvent>{

		@Override
		public void handle(MouseEvent arg0) {
			if(!ending) {
			for(Ellipse t : circleList) {
				t.setVisible(false);
			}
		
			endPoint= false;
			count++;
			textDisplay.setText("Circle Clicked Count: " + count);
		}}
	}
	
	private class startEventHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			animationHandler i = new animationHandler();
			i.start();
//			root.getChildren().add(circle1);
			root.getChildren().remove(startButton);
			
		}
		
	}
	private class animationHandler extends AnimationTimer{

		@Override
		public void handle(long arg0) {
			counttimer++;
			
			
			if(counttimer == 120 && endPoint) {
				textDisplay.setText("Game Over || " + count + " Clicked");
                ending = true;
				i.stop();
				
			}
			else if(counttimer == 120) {
				
			   Ellipse temp = new Ellipse(rand.nextInt(350), rand.nextInt(550), 20,20);
			   temp.setOnMouseClicked(new clickEventHandler());
			   root.getChildren().add(temp);
			   circleList.add(temp);
			   endPoint = true;
			   counttimer=0;
			}
			
		}
		
	}
}

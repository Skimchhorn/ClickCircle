package testttiing;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class clickGame extends Application {
    private Rectangle rec1 , rec2;
    private Pane root;
    private boolean randomClick , endpoint;
     private clickGameAnimation animation; 
    int countTime = 0;
    private Text countText;
    private int click= 0;
	@Override
	public void start(Stage primaryStage){
		root = new Pane();
	 rec1 = new Rectangle(0,0 ,200,200);
	 rec2 = new Rectangle(0,200 ,200,200);
	 rec1.setFill(Color.BLACK);
	 rec2.setFill(Color.BLACK);
	   clickGameEventHandler i = new clickGameEventHandler();
	    rec2.setOnMouseClicked(i);
	    rec1.setOnMouseClicked(i);
	    rec1.setStroke(Color.BLACK);
	    rec2.setStroke(Color.BLACK);
	    rec1.setStrokeWidth(2);
	    rec2.setStrokeWidth(2);
	    countText = new Text(50,150,"Count Click = 0 ");
	    countText.setFill(Color.RED);
	    animation = new clickGameAnimation();
		animation.start();
		root.getChildren().addAll(rec1 , rec2, countText);
	    Scene scene = new Scene(root, 200,400);
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("ClickGame");
	    primaryStage.show();
	    
	    
	}
    
	public static void main(String [] args) {
		Application.launch(args);
	}
	
	
	private class clickGameEventHandler implements EventHandler<MouseEvent>{

		@Override
		public void handle(MouseEvent o) {
			rec1.setFill(Color.WHITE);
			rec2.setFill(Color.WHITE);
			rec1.setMouseTransparent(true);
			rec2.setMouseTransparent(true);
			endpoint = false;
        	click++;
			countText.setText("Count Click " + click);
		}
		
	}
	
	private class clickGameAnimation extends AnimationTimer{

		@Override
		public void handle(long arg0) {
			
			
			rec1.setVisible(randomClick);
			rec2.setVisible(!randomClick);
			
			countTime++;
			
			if(countTime == 120 && endpoint) {
			 root.getChildren().removeAll(rec1,rec2);
			 countText.setText("GAME OVER: " + click+ "Clicked");
			}
				
			else if(countTime == 120) {
				rec1.setFill(Color.BLACK);
				rec2.setFill(Color.BLACK);
				rec1.setMouseTransparent(false);
				rec2.setMouseTransparent(false);
				randomClick = (int)(Math.random()*2)==0  ? true : false ;
				System.out.println(randomClick);
				countTime=0;
				endpoint = true;
			
			}
		}
		
	}
}

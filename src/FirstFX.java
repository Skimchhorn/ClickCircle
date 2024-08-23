import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class FirstFX extends Application {
	@Override
	public void start(Stage primaryStage) {

		Pane root = new Pane();
		Group item = new Group();
	  
		
		Text t = new Text(150,50,"kim");
		t.setFont(Font.font("Times New Roman", FontWeight.BOLD , 50));
		t.setStroke(Color.BLACK);
		t.setFill(Color.TRANSPARENT);
         
		Ellipse e = new Ellipse(200,100, 50,70);
		e.setStroke(Color.DARKRED);
		e.setFill(Color.TRANSPARENT);
		e.setStrokeWidth(1.9);
		  item.getChildren().addAll(t);
		  
		Line l = new Line (20, 20,380, 180); 
		l.setStrokeWidth(10);
		l.setFill(Color.ANTIQUEWHITE);
		Line l2 = new Line (20, 180, 380, 20);
		l2.setStrokeWidth(10);
		Rectangle r = new Rectangle (10,10 ,380,180);
		r.setFill(Color.RED);
		Polygon e1 = new Polygon(14,12.5  ,200,95 ,384,12.5 );
		e1.setFill(Color.RED); 
        
		
		Arc a = new Arc(200,100, 50 , 25 , 180 , 270);
		a.setFill(Color.TRANSPARENT);
		a.setType(ArcType.ROUND);
		a.setStroke(Color.BLACK);

		root.getChildren().addAll(a,l);
      
		Scene scene = new Scene(root, 400, 200);
		primaryStage.setTitle("First JavaFX Example");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
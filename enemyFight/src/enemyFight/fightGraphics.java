package enemyFight;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;




public class fightGraphics extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    boolean goNorth, goSouth, goEast, goWest; 
    
    @Override
    public void start(Stage stage) {
    	stage.setTitle("Demo 2 Enemy Fight");
    	Pane layout = new Pane();
    	Scene scene = new Scene(layout, 800, 800);
    	stage.setScene(scene);
    	stage.show();
    	
    	
    	
    	
    	Image playerSprite = new Image("file:SPRITE.png");
    	Image enemySprite = new Image("file:DrPepperRound.png");
    	
      ImageView iv = new ImageView();
      ImageView vi = new ImageView();
      iv.setImage(playerSprite);
      vi.setImage(enemySprite);
      layout.getChildren().add(iv);
      layout.getChildren().add(vi);


    scene.setOnKeyPressed(e ->{
        	
        	if(e.getCode()==KeyCode.RIGHT) {
    			iv.setLayoutX(iv.getLayoutX()+50);
    			//System.out.println("bruh");
    			iv.setImage(playerSprite);
    		}else if(e.getCode()==KeyCode.LEFT){
    			iv.setLayoutX(iv.getLayoutX()-50);
    		}else if(e.getCode()==KeyCode.DOWN) {
    			iv.setLayoutY(iv.getLayoutY()+50);
    		}else if(e.getCode()==KeyCode.UP) {
    			iv.setLayoutY(iv.getLayoutY()-50);
    		}

    	});

 
   
      
      }//start method

        
      
    
    

}
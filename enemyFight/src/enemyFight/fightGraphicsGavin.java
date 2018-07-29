package enemyFight;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.image.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

/**Haven't found a way to check the boundaries of the window. ~Eric.Z
 * Features that are in here:
 * - Movement with WASD
 * - Sprites changing direction when you move
 * - Proper Collision Detecting ( Wont kill you after player dies)
 * - Game freezes/ends when you die.(Dosen't let you keep moving the invisible sprite)
 * If you want to make the player move, 
 * perhaps use Yuxiaos player movement code from the text only version 
 * and implement that
 * or find some way to make it move normally.
 *
 * @author Eric Zhang
 *
 */
 

public class fightGraphics extends Application {
    public static void main(String[] args) {
        launch(args);
    }

/**
 * enemy and enemies health. Set as needed.
 */
private int pHealth = 10;
private int eHealth = 9;
ImageView player = new ImageView();
ImageView enemy = new ImageView();

Image brick = new Image("file:wall3.png");
Image playerSprite = new Image("file:linkDown.png");
Image enemySprite = new Image("file:frown.png");
Image playerRight = new Image("file:linkRight.png");
Image playerLeft = new Image("file:linkLeft.png");
Image playerDown = new Image("file:linkDown.png");
Image playerUp = new Image("file:linkUp.png");
Pane layout = new Pane();

Group hostileG = new Group();

Group walls= new Group();
int size=12;
ImageView[][] map = new ImageView[size][size];


private int moveRes=10;

    @Override
    public void start(Stage stage) {
    	stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		    @Override
		    public void handle(WindowEvent t) {
		        Platform.exit();
		        System.exit(0);
		    }
		});
    	
    	stage.setTitle("Demo 2 player Fight");
    	
    	
    	/**
    	 * Set coordinates as needed.
    	 */
    	Scene scene = new Scene(layout, 600, 600);
    	stage.setScene(scene);
    	stage.show();
    	
    	
    	player.setImage(playerSprite);
    	enemy.setImage(enemySprite);

      /**
       * enemy and Enemies starting coordinates, set as desired.
       */
    	player.setLayoutX(75);
    	player.setLayoutY(75);
    	
    	enemy.setLayoutX(400);
    	enemy.setLayoutY(400);
   


    	
    	layout.getChildren().add(player);
    	

    	
    	hostileG.getChildren().add(enemy);
    	layout.getChildren().add(hostileG);
    	layout.getChildren().add(walls);
    	
      createMap("############" +
			    "#          #" +
			    "########## #" +
			    "#     	    #" +
			    "##### ## ###" +
			    "##### #  ###" +
			    "#     #  ###" +
			    "# #####  ###" +
			    "#          #" +
			    "#          #" +
			    "#          #" +
			    "############" );
    	
     /**
      * Takes User's key inputs. change KeyCode.RIGHT to KEyCode.D and etc to change from arrow keys to WASD.
      */
   
    	scene.setOnKeyPressed(e ->{
    	
    		if(pHealth > 0) {
        	
    			if(e.getCode()==KeyCode.D) {
    				player.setImage(playerRight);
    				if (check(moveRes,0)==true) {
    					
    					player.setLayoutX(player.getLayoutX()+moveRes);
    				}
    			}
    			
    			if(e.getCode()==KeyCode.A){
    				player.setImage(playerLeft);
    				if(check(-moveRes,0)==true){
    					
    					player.setLayoutX(player.getLayoutX()-moveRes);
    				}
    			}
    			
    		
	    		if(e.getCode()==KeyCode.S) {
	    			player.setImage(playerDown);
	    			if (check(0,moveRes)==true) {
	    			
	    			player.setLayoutY(player.getLayoutY()+moveRes);
	    			}
	    			
	    		}
	        	
	    		if(e.getCode()==KeyCode.W) {
	    			player.setImage(playerUp);
	    			if (check(0,-moveRes)==true) {
	    			
	    			player.setLayoutY(player.getLayoutY()-moveRes);
	    			}
	    		}
    		}
    	
    	});
    	}
      
    public void createMap(String layout) {

    	

         
	double xWalls=0;
	double yWalls=0;
  		int posX = 0;
  		int posY=0;
  		
  		for (int i = 0; i < layout.length(); i++){
  			//System.out.println("yWalls "+yWalls); 
			//System.out.println("xWalls "+xWalls); 
			System.out.println("xPos"+posX);
			System.out.println("yPos"+posY);
			System.out.println();
				
				
  			
  			if (i % size==0 && i !=0) { // i!=0 because i only want the counter to iterate on multiples of mSizeX.  0%(mSizeX)=0 unintentionally satisfying the if condition
  				posY++;
  				
  				xWalls=0;
  				yWalls=yWalls+50;
  			}
  				
  			if( layout.charAt(i)=='#'){
  					map[posX][posY]= new ImageView();   
  		      		map[posX][posY].setImage(brick);
  		      		
  		      		map[posX][posY].setLayoutX(xWalls);//map[i][j].getLayoutBounds().getWidth());
  		      		map[posX][posY].setLayoutY(yWalls);//map[i][j].getLayoutBounds().getHeight());
  		      		walls.getChildren().add(map[posX][posY]);
  	  			}
  				posX=0;
  	  			posX++;
  	  		xWalls=xWalls+50;
  			}
  		}
  			
	
  		
    
    
    public boolean check(double xDelt,double yDelt) {
    	Bounds pBound=player.getBoundsInParent();
    	
    	for( Node object: hostileG.getChildren()) {
    		System.out.println(object.getBoundsInParent());
    	
    		if(object.getBoundsInParent().intersects(pBound.getMinX()+xDelt, pBound.getMinY()+yDelt, pBound.getWidth(), pBound.getHeight())){
    			
    			//Damage, change as desired.
    			eHealth -= 2;
    			pHealth -= 1;
    			
    			System.out.println("eHealth "+ eHealth);
    			System.out.println("pHealth "+ pHealth);
    			
    			//"Deaths of the sprites"
    			if(pHealth <=0) {
    				layout.getChildren().remove(player);
    				System.out.println("You died!");
    			}
    			
    			if(eHealth <=0) {
    	
    				layout.getChildren().remove(enemy);
    				enemy.setLayoutX(-10000);
    				enemy.setLayoutY(-10000);
    				
    			}
    			
    			return false;
    		}
    		
        }
    	for( Node object: walls.getChildren()) {
    		System.out.println(object.getBoundsInParent());
    	
    		if(object.getBoundsInParent().intersects(pBound.getMinX()+xDelt, pBound.getMinY()+yDelt, pBound.getWidth(), pBound.getHeight())){
    			return false;
    	}
    		
    		
    
}
		return true;
    }
}
    
   
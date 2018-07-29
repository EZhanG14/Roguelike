package enemyFight;

import javafx.scene.layout.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.*;
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
 

public class Core extends Application {
    public static void main(String[] args) {
        launch(args);
    }

/**
 * enemy and enemies health. Set as needed.
 */
private int pHealth = 10;
private int eHealth = 9;
ImageView damageView = new ImageView();
ImageView player = new ImageView();
ImageView enemy = new ImageView();
Image playerSprite = new Image("file:linkDown.png");
Image enemySprite = new Image("file:frown.png");
Image playerRight = new Image("file:linkRight.png");
Image playerLeft = new Image("file:linkLeft.png");
Image playerDown = new Image("file:linkDown.png");
Image playerUp = new Image("file:linkUp.png");
Image damage=new Image ("file:damage.png");
 static Image brick = new Image("file:wall3.png");
 
Image sword = new Image("file:sword.jpg");
Image health=new Image("file:health.png");
 Image inventorybar=new Image("file:inventorybar.png");
 static Image chest=new Image("file:chest.jpg");
Pane layout = new Pane();

Group hostileG = new Group();
Map map1=new Map();

private int moveRes=2;
double deltaX=0;
double deltaY=0;

    @Override
    public void start(Stage stage) throws InterruptedException {

    	stage.setTitle("Demo 2 player Fight");
    	Scene scene = new Scene(layout, 800, 800);
    	stage.setScene(scene);
    	
    	
    	map1.createMap("############"+
    				   "#          #"+
    				   "########## #"+
    				   "#     #    #"+
    				   "# # ! #    #"+
    				   "# #####    #"+
    				   "#          #"+
    				   "#          #"+
    				   "#          #"+
    				   "#          #"+
    				   "#          #"+
    				   "############");
    	player.setImage(playerSprite);
    	enemy.setImage(enemySprite);

      /**
       * enemy and Enemies starting coordinates, set as desired.
       */
    	player.setLayoutX(325);
    	player.setLayoutY(325);
 	
    	enemy.setLayoutX(400);
    	enemy.setLayoutY(400);	
    	
    	layout.getChildren().add(player);

    	hostileG.getChildren().add(enemy);
    	layout.getChildren().add(hostileG);
    	layout.getChildren().add(map1.walls);
    	layout.getChildren().add(map1.chests);
    	
    	stage.show();
    	
    	
    	
     /**
      * Takes User's key inputs. change KeyCode.RIGHT to KEyCode.D and etc to change from arrow keys to WASD.
      */
    			
    		
    	
    	scene.setOnKeyPressed(e ->{
    		
    			if(e.getCode()==KeyCode.D) {
    				player.setImage(playerRight);
    				deltaX=moveRes;
    				deltaY=0;
    				/*if (check(moveRes,0)==true) {
    					
    					player.setLayoutX(player.getLayoutX()+moveRes);
    				}*/
    			}
    			
    			if(e.getCode()==KeyCode.A){
    				player.setImage(playerLeft);
    				deltaX=-moveRes;
    				deltaY=0;
    				/*if(check(-moveRes,0)==true){
    					
    					player.setLayoutX(player.getLayoutX()-moveRes);
    				}*/
    			}
    	
    			
    		
	    		if(e.getCode()==KeyCode.S) {
	    			deltaY=moveRes;
	    			deltaX=0;
	    			player.setImage(playerDown);
	    			/*
	    			if (check(0,moveRes)==true) {
	    			
	    			player.setLayoutY(player.getLayoutY()+moveRes);
	    			}*/
	    			
	    		}
	        	
	    		if(e.getCode()==KeyCode.W) {
	    			deltaY=-moveRes;
	    			deltaX=0;
	    			player.setImage(playerUp);
	    			/*if (check(0,-moveRes)==true) {
	    			
	    			player.setLayoutY(player.getLayoutY()-moveRes);
	    			}*/
	    		}
	    		if(e.getCode()==KeyCode.SPACE) {
	    			
	    		}
    		});
    	
    	 AnimationTimer animator = new AnimationTimer()
    	    {
    		
    	        @Override
    	        public void handle(long arg0) 
    	        {
    	            
    	        for(int i=0;i<10;i++) {
    	        	if (check(deltaX,deltaY)==true) {
    	            
    	        	//renders
    	        	player.setLayoutY(player.getLayoutY()+deltaY);
    	        	player.setLayoutX(player.getLayoutX()+deltaX);
    	        	}
    	        	
    	        }
    	        deltaX=0;
	    		deltaY=0;
    	        }
    	    };
    	    animator.start();
    	}

    public boolean check(double xDelt,double yDelt) {
    	Bounds pBound=player.getBoundsInParent();
    	
    	for( Node object: hostileG.getChildren()) {
 
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
    	for( Node object: map1.walls.getChildren()) {
    	
    	
    		if(object.getBoundsInParent().intersects(pBound.getMinX()+xDelt, pBound.getMinY()+yDelt, pBound.getWidth(), pBound.getHeight())){
    			return false;
    		}
    		
    	for( Node chest: map1.chests.getChildren()) {
        	
        	
        	if(chest.getBoundsInParent().intersects(pBound.getMinX()+xDelt, pBound.getMinY()+yDelt, pBound.getWidth(), pBound.getHeight())){
        		map1.chests.getChildren().remove(chest);
        	
        		return false;
        		}	
   
    	}
    
	
    }
    	return true;
		
}
}
    
   

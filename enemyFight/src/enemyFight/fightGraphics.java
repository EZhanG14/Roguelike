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

//HAven't found a way to check the boundaries of the window. ~Eric.Z


public class fightGraphics extends Application {
    public static void main(String[] args) {
        launch(args);
    }

/**
 * PLayer and enemies health. Set as needed.
 */
private int pHealth = 9;
private int eHealth = 3;
    
    @Override
    public void start(Stage stage) {
    	stage.setTitle("Demo 2 Enemy Fight");
    	Pane layout = new Pane();
    	
    	/**
    	 * Set coordinates as needed.
    	 */
    	Scene scene = new Scene(layout, 800, 800);
    	stage.setScene(scene);
    	stage.show();
    	
    	
    	/**
    	 * Sprites, add the desired png images in eclipse.
    	 */
    	
      Image playerSprite = new Image("file:wall2.png");
      Image enemySprite = new Image("file:DrPepperRound.png");
      /**
       * "iv" is for player
       * "vi" is for enemy
       */
      ImageView iv = new ImageView();
      ImageView vi = new ImageView();
      iv.setImage(playerSprite);
      vi.setImage(enemySprite);
      /**
       * PLayer and Enemies starting coordinates, set as desired.
       */
      iv.setLayoutX(0);
      iv.setLayoutY(0);
      vi.setLayoutX(400);
      vi.setLayoutY(400);
      
      
      layout.getChildren().add(iv);
      layout.getChildren().add(vi);

     /**
      * Takes User's key inputs. change KeyCode.RIGHT to KEyCode.D and etc to change from arrow keys to WASD.
      */
    scene.setOnKeyPressed(e ->{
        	
        	if(e.getCode()==KeyCode.RIGHT) {
        		
        		//Change the number at the end to change how much player moves by.
    			iv.setLayoutX(iv.getLayoutX()+50);
    			iv.setImage(playerSprite);
    			
    			//Collision detection.
    			if(iv.getBoundsInParent().intersects(vi.getBoundsInParent())){
    				
    				//Damage, change as desired.
    				eHealth -= 1;
    				pHealth -= 1;
    				boolean eCheck = enemyHealth(eHealth);
    				boolean pCheck = playerHealth(pHealth);
    				
    				//"Deaths of the sprites"
    				if(pCheck == true) {
    					iv.setImage(null);
    					System.out.println("You died!");
    				}
    				if(eCheck == true) {
    					vi.setImage(null);
    				}
    				
    			}
    		}else if(e.getCode()==KeyCode.LEFT){
    			iv.setLayoutX(iv.getLayoutX()-50);
    			if(iv.getBoundsInParent().intersects(vi.getBoundsInParent())){
    				eHealth -= 1;
    				pHealth -= 1;
    				boolean eCheck = enemyHealth(eHealth);
                    boolean pCheck = playerHealth(pHealth);
    				
    				if(pCheck == true) {
    					iv.setImage(null);
    					System.out.println("You died!");
    				}
    				if(eCheck == true) {
    					vi.setImage(null);
    				}
    			}
    		}else if(e.getCode()==KeyCode.DOWN) {
    			iv.setLayoutY(iv.getLayoutY()+50);
    			if(iv.getBoundsInParent().intersects(vi.getBoundsInParent())){
    				eHealth -= 1;
    				pHealth -= 1;
    				boolean eCheck = enemyHealth(eHealth);
    				boolean pCheck = playerHealth(pHealth);
    				
    				if(pCheck == true) {
    					iv.setImage(null);
    					System.out.println("You died!");
    				}
    				if(eCheck == true) {
    					vi.setImage(null);
    					System.out.println();
    				}
    			}
    		}else if(e.getCode()==KeyCode.UP) {
    			iv.setLayoutY(iv.getLayoutY()-50);
    			if(iv.getBoundsInParent().intersects(vi.getBoundsInParent())){
    				eHealth -= 1;
    				pHealth -= 1;
    				boolean eCheck = enemyHealth(eHealth);
    				boolean pCheck = playerHealth(pHealth);
    				
    				if(pCheck == true) {
    					iv.setImage(null);
    					System.out.println("You died!");
    				}
    				if(eCheck == true) {
    					vi.setImage(null);
    				}
    			}
    		}

    	});

   
      
      }//end of bracket for start method
    /**
     * Methods to check enemy and player's health.
     * @param eHealth
     * @return boolean
     */
    public boolean enemyHealth(int eHealth){
    	boolean healthCheckEnemy = false;
    	if(eHealth <=0) {
    		healthCheckEnemy = true;
    	}
    	return healthCheckEnemy;
    }
    public boolean playerHealth(int pHealth) {
    	boolean healthCheckPlayer = false;
    	if(pHealth <=0) {
    		healthCheckPlayer = true;
    	}	
    	return healthCheckPlayer;
    }  
      
    
    

}
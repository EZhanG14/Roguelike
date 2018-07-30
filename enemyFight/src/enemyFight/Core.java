package enemyFight;

import javafx.scene.layout.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Bounds;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

   /* private ImageView damageView = new ImageView();
    private ImageView player = new ImageView();*/
    
  


    static Pane layout = new Pane();
    
    private Map map1=new Map();
    private Inventory inventory=new Inventory();
   
    
	private int pHealth = 10;
	private int eHealth = 9;
	private int chestchose=0;
	private boolean attack=false;
	private int moveRes=1;
	private double deltaX=0;
	private double deltaY=0;
	
	static Player player1= new Player();
	static Enemy enemy1= new Enemy();
	  
    @Override
    public void start(Stage stage) throws InterruptedException {
    	
    	stage.setTitle("Demo 2 player Fight");
    	Scene scene = new Scene(layout, 600, 600);
    	stage.setScene(scene);
    
    	map1.createMap("void");

    	

    	stage.show();
    	
    	scene.setOnKeyPressed(e ->{
			if(e.getCode()==KeyCode.D) {
				player1.player.setImage(player1.playerRight);
				deltaX=moveRes;
				deltaY=0;
			}
			
			if(e.getCode()==KeyCode.A){
				player1.player.setImage(player1.playerLeft);
				deltaX=-moveRes;
				deltaY=0;
			}

    		if(e.getCode()==KeyCode.S) {
    			deltaY=moveRes;
    			deltaX=0;
    			player1.player.setImage(player1.playerDown);
    		}
        	
    		if(e.getCode()==KeyCode.W) {
    			deltaY=-moveRes;
    			deltaX=0;
    			player1.player.setImage(player1.playerUp);
    		}
    		
    		if(e.getCode()==KeyCode.SPACE) {
    			attack=true;
    		}
    	});
    	
    	AnimationTimer animator = new AnimationTimer() {
			@Override
			public void handle(long arg0){
				int i1;
				
				player1.damageView.setLayoutX(-1000);
				player1.damageView.setLayoutY(-1000);

				for(int i=0;i<10;i++) {
			    	if (check(deltaX,deltaY)==true) {
			            
			    		player1.player.setLayoutY(player1.player.getLayoutY()+deltaY);
			    		player1.player.setLayoutX(player1.player.getLayoutX()+deltaX);
				    	
				    	i1=(int)(Math.random()-3);
				    	if(enemy1.enemy.getLayoutY()-i1*deltaX>0&&enemy1.enemy.getLayoutX()-i1*deltaX<600) enemy1.enemy.setLayoutX(enemy1.enemy.getLayoutX()-i1*deltaX);
				    	if(enemy1.enemy.getLayoutY()-i1*deltaY>0&&enemy1.enemy.getLayoutY()-i1*deltaY<600)enemy1.enemy.setLayoutY(enemy1.enemy.getLayoutY()-i1*deltaY);	
			    	}
    	        }
				
		        deltaX=0;
		        deltaY=0;
	    	        	
	    		if (attack==true) {
		    		if (player1.player.getImage()==player1.playerUp)	
		    			player1.damageView.setLayoutX(player1.player.getLayoutX()-20);
		    		player1.damageView.setLayoutY(player1.player.getLayoutY()-75);
		        		
		    		if (player1.player.getImage()==player1.playerDown) {
		    			player1.damageView.setLayoutX(player1.player.getLayoutX()-15);
		    			player1.damageView.setLayoutY(player1.player.getLayoutY()+50);
	        		}
		    		
	    	    	if (player1.player.getImage()==player1.playerLeft) {
	    	    		player1.damageView.setLayoutX(player1.player.getLayoutX()-75);
	    	    		player1.damageView.setLayoutY(player1.player.getLayoutY()-15);
	        		}
	    	    	
	    			if (player1.player.getImage()==player1.playerRight) {
	    				player1.damageView.setLayoutX(player1.player.getLayoutX()+50);
	    				player1.damageView.setLayoutY(player1.player.getLayoutY()-10);
	    		
	    			}
	    		
	    			if(player1.damageView.getBoundsInParent().intersects(enemy1.enemy.getBoundsInParent())) {
	
	    				eHealth -= 2;
	    				if(eHealth <=0) {
	    			    	
	        				layout.getChildren().remove(enemy1.enemy);
	        				enemy1.enemy.setLayoutX(-10000);
	        				enemy1.enemy.setLayoutY(-10000);
	    				}
		    		}
	    			
	    		attack=false;
	    		}
	    	}	
	    };animator.start(); 
    }

    public boolean check(double xDelt,double yDelt) {
    	Bounds pBound= player1.player.getBoundsInParent();
    	
    	for( Node object: enemy1.hostileG.getChildren()) {
    		
    		if(object.getBoundsInParent().intersects(pBound.getMinX()+xDelt, pBound.getMinY()+yDelt, pBound.getWidth(), pBound.getHeight())){
    			

    			eHealth -= inventory.getpDamage();
    			pHealth -= 1;

    			System.out.println("eHealth "+ eHealth);
    			System.out.println("pHealth "+ pHealth);
    			
    			//"Deaths of the sprites"
    			if(pHealth <=0) {
    				layout.getChildren().remove(player1.player);
    				System.out.println("You died!");
    			}
    			
    			if(eHealth <=0) {
    				layout.getChildren().remove(enemy1.enemy);
    				enemy1.enemy.setLayoutX(-10000);
    				enemy1.enemy.setLayoutY(-10000);
    			}
    		return false;
    		}
        }
    	
    	for( Node object: map1.walls.getChildren()) {
    		if(object.getBoundsInParent().intersects(pBound.getMinX()+xDelt, pBound.getMinY()+yDelt, pBound.getWidth(), pBound.getHeight())) return false;
    	}
    	
    	for( Node chest: map1.chests.getChildren()) {
        	if(chest.getBoundsInParent().intersects(pBound.getMinX()+xDelt, pBound.getMinY()+yDelt, pBound.getWidth(), pBound.getHeight())){
        		map1.chests.getChildren().remove(chest);
    	        chestchose=inventory.getchestchose();
    	        
    	        if(chestchose==1)inventory.sworda.setVisible(true);
    	        if(chestchose==2)inventory.healthbag.setVisible(true);
    	        
    	        return false;
        	} 
        }	
    	
    return true;
    }
}
    
   
package inventory;




import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;
public class inventory extends Application{
private int phealth=10;
private int pdamage=1;
private int chestchose=0;
  public void setpHealth(int a){
	if (phealth<=10)phealth=a;
   }
   public int getpHealth(){
	return this.phealth;
   }
   public void setpDamage(int a) {
	pdamage=a;
   }
    public int getpDamage(){
	return this.pdamage;
    }
	public static void main(String [] args)
	{
		launch(args);
	}

	public void start(Stage PrimaryStage)
	{
		PrimaryStage.setTitle("Inventory");
		Pane layout=new Pane();
		Scene scene=new Scene(layout,800,800);
		PrimaryStage.setScene(scene);
		PrimaryStage.show();
		Image playerSprite = new Image("file:linkDown.png");
		Image sword = new Image("file:sword.jpg");
		Image health=new Image("file:health.png");
	    Image inventorybar=new Image("file:inventorybar.png");
	    Image chest=new Image("file:chest.jpg");
	    
	    ImageView iv = new ImageView();
	    iv.setImage(playerSprite);
	    
		ImageView s = new ImageView();
		s.setPreserveRatio(true);
		s.setFitHeight(70);
		s.setFitWidth(100);
		s.setVisible(false);
		
		ImageView h=new ImageView();
		h.setPreserveRatio(true);
		h.setFitHeight(50);
		h.setFitWidth(50);
		h.setVisible(false);
		
		
		ImageView i=new ImageView();	
		i.setPreserveRatio(true);
		i.setFitHeight(200);
		i.setFitWidth(800);
		
		ImageView c=new ImageView();
		c.setPreserveRatio(true);
		c.setFitHeight(50);
		c.setFitWidth(50);
		
		 iv.setImage(playerSprite);
		 s.setImage(sword);
		 h.setImage(health);
		 i.setImage(inventorybar);
		 c.setImage(chest);
		 
	
		 
		 iv.setLayoutX(10);
	     iv.setLayoutY(10);
	     
		 s.setLayoutX(100);
		 s.setLayoutY(700);
		  
		 h.setLayoutX(150);
		 h.setLayoutY(700);
		 
		 i.setLayoutX(100);
		 i.setLayoutY(600);
		 
		 c.setLayoutX(200);
		 c.setLayoutY(200);

	
	 layout.getChildren().add(iv);
	 layout.getChildren().add(i);
	 layout.getChildren().add(s);
	 layout.getChildren().add(h);
	 layout.getChildren().add(c);
	 
	 
	 
	 
	 
	 scene.setOnKeyPressed(e ->{
	      
	
		 
		 
		 
		 if(iv.getBoundsInParent().intersects(c.getBoundsInParent()	)){
				 
			           layout.getChildren().remove(c);
			           chestchose=(int) Math.ceil(Math.random()*3 );
			       	  if(chestchose==1) s.setVisible(true);
			          if(chestchose==2) h.setVisible(true);
			         
			}
		 
		     if(chestchose==1&&e.getCode()==KeyCode.F) {
			  	layout.getChildren().remove(s);    s.setImage(null); setpDamage(3);
			  		
			  	 }
			  	if(chestchose==2&&e.getCode()==KeyCode.H) {
			  		layout.getChildren().remove(h);    h.setImage(null);setpHealth(10);
		 
		 
			  	}
		 
		 if(e.getCode()==KeyCode.D) {
	        
	        	
	    			iv.setLayoutX(iv.getLayoutX()+50);
	    				
	    			
	    		}else if(e.getCode()==KeyCode.A){
	    		
	    			iv.setLayoutX(iv.getLayoutX()-50);
	    			
	    				
	    		}else if(e.getCode()==KeyCode.S) {
	    		
	    			iv.setLayoutY(iv.getLayoutY()+50);
	    		
	    		}else if(e.getCode()==KeyCode.W) {
	    			
	    			iv.setLayoutY(iv.getLayoutY()-50);
	    		
	    			}
	    		
	        
	    	});

	 }
	      
	  
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	

	
	
	
	
	
	
}
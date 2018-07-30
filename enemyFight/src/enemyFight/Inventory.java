package enemyFight;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Inventory{ 
	
	private int phealth=10;
	private int pdamage=1;
	private int chestchose=0;
	
	ImageView sworda=new ImageView();
	private Image sword = new Image("file:sword.jpg");
	
    ImageView healthbag=new ImageView(); 
    private Image health=new Image("file:health.png");
    
    ImageView inventory=new ImageView();
	private Image inventorybar=new Image("file:inventorybar.png");
	
	Inventory(){
		
		inventory.setImage(inventorybar);
		inventory.setLayoutX(40);
    	inventory.setLayoutY(400);
    	inventory.setPreserveRatio(true);
        inventory.setFitHeight(200);
        inventory.setFitWidth(800);
        Core.layout.getChildren().add(inventory);
        
        sworda.setLayoutX(95);
	    sworda.setLayoutY(500);
	    sworda.setPreserveRatio(true);
	    sworda.setFitHeight(70);
	    sworda.setFitWidth(150);
	    sworda.setVisible(false);
	    sworda.setImage(sword);
	    Core.layout.getChildren().add(sworda);
	    
	    healthbag.setLayoutX(150);
		healthbag.setLayoutY(500);
		healthbag.setPreserveRatio(true);
		healthbag.setFitWidth(150);
		healthbag.setVisible(false);
		healthbag.setImage(health);
		Core.layout.getChildren().add(healthbag);
	}
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
	    
	public int getchestchose() {
		chestchose=(int)(Math.ceil(Math.random()*2 ));
	    return chestchose;
	}
}   
	
	 
	
	      
	  
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	

	
	

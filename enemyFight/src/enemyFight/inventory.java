package enemyFight;

public class inventory{ 
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
    public int getchestchose() {
    	chestchose=(int)(Math.ceil(Math.random()*2 ));
    	return chestchose;
    }
}   
	
	 
	
	      
	  
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	

	
	
	
	
	
	

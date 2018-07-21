import java.util.Scanner;

//johnny

	

public class fight{

	



	    private static boolean playing = false;
	    private static int enemyHealth = 4;
	    private static int playerHealth = 5;
	    private static double enemymakeChoice=Math.ceil(Math.random()*2 );
	    private static double swordChoice= Math.ceil(Math.random()*2 );
	    private static String pName;
	    private static int power=1;
	    
        
	  
	   
	    		
	    	     
	    		
	    public static void checkHealth(){
	        if(enemyHealth <= 0){
	            System.out.println(pName+" wins!");
	            playing = false;
	        }else if(playerHealth <= 0){
	            System.out.println(pName+" has fallen! Enemy wins!");
	            playing = false;
	        }
	    }






	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        String wantPlay;
	        // asking the player if they want to play
	        System.out.println("Want to play a fighting game?: ");
	        wantPlay = sc.next();

	        // if the player chooses to play, it will start the game 
	        if(wantPlay.equals("Yes") || wantPlay.equals("yes")){

	            System.out.println("What do you want your name to be?: ");
	            pName = sc.next();

	            System.out.println("Hey folks!, we are going to have an exiting game today!");
	            System.out.println(" Hint! If you have sword you can win game easy!!!!!"
	            		+ "But you have to choose run");
	           

	            playing = true;
	        }

	        while(playing == true){


	            System.out.println("enemy has "+enemyHealth+" health remaining.");
	            System.out.println("You have "+playerHealth+" health remaining.");

	            String action;
	            System.out.println("What would you like to do? (a)fight  (b) run");
	            action = sc.next();
	        
	           
	            checkHealth();
	            enemymakeChoice=Math.ceil(Math.random()*2 );
	            if(action.equals("a") && enemymakeChoice == 1){
	                checkHealth();
	                System.out.println("oohh!  "+pName+" fight with enemy");
	                playerHealth-=power;
	                enemyHealth-=power;
	                checkHealth();

	            
	            }else if (action.equals("a") && enemymakeChoice == 2){
	              
	                System.out.println("enemy Run!!!");
	                enemyHealth-=power;
	                checkHealth();
	           
	         
	                       
	               
	               
	            }else if (action.equals("b") && enemymakeChoice == 1){
	                
	                System.out.println("Player run");
	                playerHealth-=power;
	                checkHealth();
	                swordChoice=Math.ceil(Math.random()*2 );
	                if(swordChoice==2)
	                {
	                	System.out.println("Get Sword");
	                	power=3;
	                }
	             
	            }else if (action.equals("b") && enemymakeChoice == 2){
	                
	                System.out.println("Player and Enemy both run");
	              
	                
	           
	            }



	        }

	    }

	}
	
	
	
	
	


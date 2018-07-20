import java.util.Scanner;

//johnny

	

public class fight{

	



	    private static boolean playing = false;
	    private static int enemyHealth = 4;
	    private static int playerHealth = 5;
	    private static double enemyChoice = Math.ceil(Math.random() * 2);
	    private static String pName;
	    private static int power=1;
	    private static int sword=0;
        
	    public int getpower()
	    {
	    	return power;
	    }
	    public  void  setpower()
	    {
	    	if (sword==0)
	    	{
	    		fight.power=1;
	    	}
	    	else if(sword==1)
	    	{
	    		fight.power=3;
	    	}
	    }


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
	            System.out.println(" Hint! If you have sword you can win game easy!!!!!");
	           

	            playing = true;
	        }

	        while(playing == true){


	            System.out.println("enemy has "+enemyHealth+" health remaining.");
	            System.out.println("You have "+playerHealth+" health remaining.");

	            String action;
	            System.out.println("What would you like to do? (a)fight  (b) run");
	            action = sc.next();
	        
	            enemyChoice = Math.ceil(Math.random() * 2);
	            checkHealth();

	            if(action.equals("a") && enemyChoice == 1){
	                checkHealth();
	                System.out.println("oohh!  "+pName+" fight with enemy");
	                playerHealth-=power;
	                enemyHealth-=1;
	                checkHealth();

	            
	            }else if (action.equals("a") && enemyChoice == 2){
	              
	                System.out.println("enemy Run!!!");
	               
	               
	            }else if (action.equals("b") && enemyChoice == 1){
	                
	                System.out.println("Player run");
	             
	            }else if (action.equals("b") && enemyChoice == 2){
	                
	                System.out.println("Player and Enemy both run");
	              
	                
	           
	            }



	        }

	    }

	}
	
	
	
	


package mondayDemo;

import java.util.Scanner;

/**
 * This Class implement Player and Fight System
 * This Class also include inventory function
 * @ author Zhaoning Meng, Eric Zhang;
 * 
 */

public class Player extends Movers  {
  String name;
  int x,y;
  int health=5;
  @SuppressWarnings("unused")
private static boolean playing = false;
  private static int enemyHealth = 4;
  private static int playerHealth = 5;
  private static double enemymakeChoice=Math.ceil(Math.random()*2 );
  private static int power=1;
  private static boolean swordSheath;
  // This is a Construct Player with specific (X,Y ) location
  public Player(int x,int y)
  {
	  super(x,y);
  }
 
  
 
// This is a Inventory method to add sword
	public static boolean addInv(char x){
		if(x == '!'){
		swordSheath = true;
		return swordSheath;
		}else
		{swordSheath=false;
		 return swordSheath;
		}
	}


// This is the method to check the sword 
	public static  void  checkInv(){
		if(swordSheath = true){
			System.out.println("You have a sword!");
		}else if(swordSheath=false){
			
		System.out.println("Your bag is empty");
		}
	}
	  		
  	     
 //This is the method to check health if enemy's health is lower than 0,player win.		
  public static void checkHealth(){
      if(enemyHealth <= 0){
          System.out.println("Player wins!");
          playing = false;
      }else if(playerHealth <= 0){
          System.out.println("Player has fallen! Enemy wins!");
          playing = false;

      }
  }

//This is the method to build fight system
 public static void monsterFight()
 {
   
      System.out.println("You ran into a monster");
      System.out.println(" Hint! If you have sword you can do more damage!");
   


      
   //This loop decide when to end the fight
      while(playing =true){


          System.out.println("enemy has "+enemyHealth+" health remaining.");
          System.out.println("You have "+playerHealth+" health remaining.");

          
          System.out.println("Do you want to attack? YES or NO ");   
          @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
          	String	action = sc.next();

   
          enemymakeChoice=Math.ceil(Math.random()*2 );
          if(action.equals("YES") && enemymakeChoice == 1){
              checkHealth();
              
              checkInv();
              
              System.out.println("You attacked the monster!");
              if(swordSheath==true)
              {
            	  power=3;
              }
              else
              {
            	  power=1;
              }
              
              playerHealth-=1;
              enemyHealth-=power;
              checkHealth();

          
          }else if (action.equals("YES") && enemymakeChoice == 2){
            
              System.out.println("The monster ran away!");
     // It will break the loop either player or enemy choose run                      
              break;
          }else if (action.equals("NO") && enemymakeChoice == 1){
              
              System.out.println("You ran away...");
              break;
             
          }else if (action.equals("NO") && enemymakeChoice == 2){
              
              System.out.println("Both of you ran away...");
            
              break;
         
          }

      }

      }

}










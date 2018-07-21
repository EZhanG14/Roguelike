package mondayDemo;

import java.util.Scanner;

/**
 * zhaoning meng
 * 
 */

public class Player extends Movers  {
  String name;
  int x,y;
  int health=5;
  private static boolean playing = false;
  private static int enemyHealth = 4;
  private static int playerHealth = 5;
  private static double enemymakeChoice=Math.ceil(Math.random()*2 );
  
  private static String pName;
  private static int power=1;
  
  
  private static  boolean swordSheath= false;

	public boolean addInv(char x){
		if(x == '!'){
		swordSheath = true;
		return swordSheath;
		}else
		{swordSheath=false;
		 return swordSheath;
		}
	}



	public static void  checkInv(){
		if(swordSheath == true){
			System.out.println("You have a sword!");
		}else { 
		System.out.println("Your bag is empty");
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







  public static void monsterFight(){
      @SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
      //System.out.println("What do you want your name to be?: ");
   	  //pName = sc.next();
   
      System.out.println("You ran into a monster");
      System.out.println(" Hint! If you have sword you can do more damage!");
   


      
   
      while(playing =true){


          System.out.println("enemy has "+enemyHealth+" health remaining.");
          System.out.println("You have "+playerHealth+" health remaining.");

          
          System.out.println("Do you want to attack? YES or NO ");     
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
  public Player(int x,int y)
  {
	  super(x,y);
  }
 

   


public void setname(String n)
  {
	this.name=n;
	
   }

  public String getname()
 {
	return name;

  }
  public void setpower(int p)
  {
	power=p;
	
   }
   public int getpower()
   {
	return power;
   }
    public void sethealth(int h)
   {
	this.health=h;
    }

   public int gethealth()
    {
	return health;
    }









}


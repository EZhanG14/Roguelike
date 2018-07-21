package mondayDemo;
import java.util.Scanner;

public class game{
	private int shiftX=1;
	private int shiftY=1;
	private int checkX=1;
	private int checkY=1;
    private int gamestatement=1;
	

	public void move(){
		String input;
		while (gamestatement==1){
		System.out.println("Your location is " + shiftX +" "+ shiftY);
		
		System.out.println("what do u want to do at this time?");
		Scanner sc = new Scanner(System.in);
		input=sc.next();
		if(input=="w"){	 
			checkY = shiftY-1;
			System.out.println("you decided to move up");
		}
		else if(input =="s") {
			checkY=shiftY+1;
		    System.out.println("you decided to move down");
		}
		
	    else if(input == "a"){
	    	checkX= shiftX-1;
	    	System.out.println("you decided to move left");
			}
		
		else if(input == "d") {
			checkX=shiftX-1;
		    System.out.println("you decided to move down"); 
		}
	
		
			 
		}
			gamestatement--;
		 
	}
}

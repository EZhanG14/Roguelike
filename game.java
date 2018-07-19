import java.util.Scanner;

public class basicgame {
	
	
	int shiftX=1;
	
	int shiftY=1;
	int checkX=1;
	int checkY=1;
	int gamestatement =1 
	whlie(gamestatement=1){
	System.out.println("Your location is " shiftX, shiftY);
	System.out.println("what do u want to do at this time?");
	int userinput;
	Scanner userinput = new Scanner(System.in);
	if(userinput.hasNextInt()){
		  userinput = numberGuess.nextInt();
		  if(userinput = "w"){
			  checkY = shiftY-1;
				  System.out.println("you decided to move up");
			 
			  }else if(userinput ="s") {
				  checkY=shiftY+1;
			  
				  System.out.println("you decided to move down");
			  
			  }else if(userinput == "a"){
				  checkX= shiftX-1;
				  
				  System.out.println("you decided to move left");
			  }
		 }else if(userinput == "d") 
		 {checkX=shiftX-1;
	  
	      System.out.println("you decided to move down");
	     
		 }
	if (checkX=1) {
		if(checkY=7) {
			 System.out.println(" but you get blocked");
			 break;
		}else {
			shiftX=checkX;
			shiftY=checkY;
			gamestatement++;
		}
	}
	else if(checkX=2) {
		if(checkY=2||checkY=5||checkY=7) {
			System.out.println(" but you get blocked");
			break;
	}else {
		shiftX=checkX;
		shiftY=checkY;
		gamestatement++;
	}
		
	 
}
	else if(checkX=3) {
		if(checkY=2||checkY=3||checkY=5||checkY=7) {
			System.out.println(" but you get blocked");
			break;
	}else {
		shiftX=checkX;
		shiftY=checkY;
		gamestatement++;
	}
	}
		else if(checkX=4) {
			if(checkY=5) {
				System.out.println(" but you get blocked");
				break;
		}else {
			shiftX=checkX;
			shiftY=checkY;
			gamestatement++;
		}
			
		 
	}
		else if(checkX=5) {
			if(checkY=3||checkY=7) {
				System.out.println(" but you get blocked");
				break;
		}else {
			shiftX=checkX;
			shiftY=checkY;
			gamestatement++;
		}
		}
			else if(checkX=6) {
				if(checkY=1||checkY=2||checkY=3||checkY=5||checkY=6||checkY=7) {
					System.out.println(" but you get blocked");
					break;
			}else {
				shiftX=checkX;
				shiftY=checkY;
				gamestatement++;
			}
				
			 
		}
			else if(checkX=7) {
				if(checkY=5) {
					System.out.println(" but you get blocked");
					break;
			}else {
				shiftX=checkX;
				shiftY=checkY;
				gamestatement++;
			}
			}
			else if(checkX=8) {
				if(checkY=3||checkY=7) {
					System.out.println(" but you get blocked");
					break;
			}else if(checkX=8){
				System.out.println(" u reach the final point");
				shiftX=checkX;
				shiftY=checkY;
				gamestatement++;
			}
			else{
				shiftX=checkX;
				shiftY=checkY;
				gamestatement++;
			}
			}
		 
	}
		gamestatement--;
	 
}
}
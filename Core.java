package mondayDemo;

import java.util.Scanner;

//sorry for the bad documentation everyone!
public class core {
	private static int posX = 1;
	private static int posY = 1;
	static Map map1 = new Map();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {  
	
		{
	
	
	String map = "########" +
			     "#      #" +
			     "#      #" +
			     "#      #" +
			     "#      #" +
			     "#      #" +
			     "#      #" +
			     "########" ;
	
	map1.createMap(map);
	//map1.printMap();
	
	
	//map1.printMap();
	
	
	 
	while (true) { // game loop change later
		move();
		map1.printMap();
	}
	
	}
	}
	
	static public void move(){
		
		String input;
			
			System.out.println("Your location is " + posX +" "+ posY);
			System.out.println("what do u want to do at this time?");
			
			input=sc.next();
			System.out.println(input);
			
			if(input.equals("w")){	 
				if (map1.getPos(posX,posY-1)!='#') {
					map1.setSpace(posX,posY-1,'O');
					map1.setSpace(posX,posY,' ');
				System.out.println("you decided to move up");
				posY--;
			}
			}
			else if(input.equals("s")) {
				if (map1.getPos(posX,posY+1)!='#') {
					map1.setSpace(posX,posY+1,'O');
					map1.setSpace(posX,posY,' ');
					posY++;
				}
			
			    System.out.println("you decided to move down");
			}
			
			
		    else if(input.equals("a")){
		    	if (map1.getPos(posX-1,posY)!='#') {
					map1.setSpace(posX-1,posY,'O');
					map1.setSpace(posX,posY,' ');
					posX--;
				}
		    }
			
			else if(input.equals("d")) {
				if (map1.getPos(posX+1,posY)!='#') {
					map1.setSpace(posX+1,posY,'O');
					map1.setSpace(posX,posY,' ');
					posX++;
				}
			}
			else System.out.println("invalid");
	}

	
}
	


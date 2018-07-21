package mondayDemo;
//known bug: starting a player in a wall bugss everything out 

import java.util.Scanner;

//sorry for the bad documentation everyone!
public class Core {
	Enemy monster =new Enemy();
	
	static Player player1= new Player(1,1);
	static Map map1 = new Map();
	static String map = "########" +
					    "#      #" +
					    "# #    #" +
					    "#  #   #" +
					    "# x    #" +
					    "#      #" +
					    "#      #" +
					    "########" ;
	
	public static String input() {
		String input;
		System.out.println("Your location is " + player1.getX() +" "+ player1.getY());
		System.out.println("what do u want to do at this time?");
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		input=sc.next();
		return input;
		
		
	}
	
	public static void main(String[] args) { 
		map1.createMap(map);
		while (true) { // game loop change later
			String input=input();
			
			if(input.equals("~")) player1.checkInv();
			if (input.equals("w")||input.equals("a")||
				input.equals("s")||input.equals("d")){
				player1.move(input);
			}
			Enemy.moveEnemy();
			map1.printMap();
		}
	}
}
	
	
	

package mondayDemo;
//known bug: starting a player in a wall bugss everything out 

import java.util.Scanner;

//sorry for the bad documentation everyone!
public class core {
	
	static player player= new player(1,1);
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
		System.out.println("Your location is " + player.getX() +" "+ player.getY());
		System.out.println("what do u want to do at this time?");
		Scanner sc = new Scanner(System.in);
		input=sc.next();
		return input;
		
		
	}

	
	public static void main(String[] args) {  
		while (true) { // game loop change later
			String input=input();
			map1.createMap(map);
			if (input.equals("w")||input.equals("a")||
				input.equals("s")||input.equals("d")){
				player.move(input);
		
			}
			map1.printMap();
		}
	}
}
	
	
	

	
	
	

	


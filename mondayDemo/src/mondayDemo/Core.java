package mondayDemo;
//known bug: starting a player in a wall bugs everything out 

import java.util.Scanner;

/**
 * Core runs the game using methods from the other classes in the same package.
 */
public class Core {
	/**
	 * Creates an enemy.
	 */
	Enemy monster =new Enemy();
	
	/**
	 * Creates the player and sets its coordinates.
	 */
	static Player player1= new Player(1,1);
	
	/**
	 * Creates the map object and sets the characters.
	 * # = Walls
	 * x = Enemy
	 * ! = Sword
	 * $ = Endpoint
	 */	
	static Map map1 = new Map();
	static String map = "########" +
					    "#      #" +
					    "# #    #" +
					    "#  #   #" +
					    "#      #" +
					    "#      #" +
					    "#   ! $#" +
					    "########" ;
	
	/**
	 * Sets game loop to true, this allows the user to constantly input until the win condition is met.
	 */	
	private static boolean gameLoop = true;
	/**
	 * Takes the user's input if they want to move or check thier inventory.
	 * @return the string that the user types in.
	 */
	public static String input() {
		String input;
		System.out.println("Your location is " + player1.getX() +" "+ player1.getY());
		System.out.println("what do you want to do at this time?");
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		input=sc.next();
		return input;
		
		
	}
	
	/**
	 * Tells the user that they have fininshed the game when this method is called.
	 * sets the boolean in the parameter as false to stop the loop for the game.
	 * @param gameOver Boolean variable.
	 *                 Used as a condition to see 
	 *                 if the game is still running.
	 */
	public static void setGameLoop(boolean gameOver){
		System.out.println("You have finished the demo. Thanks for playing :) ~Group 4");
		gameLoop = false;
		
	}
	
	@SuppressWarnings("static-access") //FIX THIS
	
	/**
	 * Main method initializes the game.
	 * @param args 
	 *        An array command line arguments for game.
	 */
	public static void main(String[] args) { 
		map1.createMap(map);
		while (gameLoop == true) { // game loop change later
			String input = input().toUpperCase();
			
			if(input.equals("~")) player1.checkInv();
			
			if (input.equals("W")||input.equals("A")||
				input.equals("S")||input.equals("D")) player1.move(input);
				
			Enemy.moveEnemy();
			map1.printMap();
		}
	}
}

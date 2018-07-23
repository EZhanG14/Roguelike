package mondayDemo;
/**
 * Movers implements the basic methods required for characters to move around the map
 * has children Enemy and player
 * 
 * @authorT01 Group 4
 * @author Gavin Guinn
 * @since July 22, 2018
 * @version 1.0
 */

public class Movers {

	private int posX;
	private int posY;

	/**
	 * default constructor 
	 * sets x=1 and y =1
	 * change to something better latter
	 */	
	public Movers() {
		posX=1;
		posY=1;
	}

	/**
	 * Constructor
	 * @param setPosX sets starting x position of the mover
	 * @param setPosY sets starting y position of the mover
	 */	
	public Movers(int setPosX,int setPosY) {
		posX= setPosX;
		posY=setPosY;
	}
	
	/**
	 * getter method for x coord
	 * @return x coordinate of mover
	 */
	public int getX() {
		return posX;
	}
	
	/**
	 * getter method for y coord
	 * @return y coordinate of mover
	 */
	public int getY() {
		return posY;
	}

	/**
	  * preCheck method checks the contents of a tile and determines if the player or monster can move there
	  * @param checkX x coordinate to be checked
	  * @param checkY y coordinate to be checked
	  * @returns canMove true if the Mover can is allowed on the tile
	  */
	public boolean preCheck(int checkX, int checkY) { // if false you cannot move there
		boolean canMove=true;
		if (Core.map1.getPos(checkX,checkY)=='#') canMove=false; 
		if (Core.map1.getPos(checkX,checkY)=='x') Player.monsterFight();		
		if (Core.map1.getPos(checkX,checkY)=='!') Player.addInv('!');
		if (Core.map1.getPos(checkX,checkY)=='$') Core.setGameLoop(false);
			
		return canMove;
	}
	/**
	  * movePlayer method moves the player to the desired tile
	  * made to decrease repeated code
	  * @param newX x tile to be moved to
	  * @param newY y tile to be moved to
	  */
	private void movePlayer(int newX,int newY) {
		Core.map1.setSpace(newX,newY,'O');
		Core.map1.setSpace(posX,posY,' '); //erases old position
	}
	
	/**
	  *move class changes the position of the Mover based on the input it receives
	  * @param input takes WASD input from the player 
	  */
	public void move(String input){
		
		Core.map1.setSpace(posX,posY,'O'); // this fixes the bug when character disappears when touching wall
		
		if(input.equals("W")){	 
			if (preCheck(posX,posY-1)==true) {
				movePlayer(posX,posY-1);
				posY--;
			}
		}
		
		if(input.equals("S")) {
			if (preCheck(posX,posY+1)==true) {
				movePlayer(posX,posY+1);
				posY++;
				}
			}
			
			
		if(input.equals("A")){
		    if (preCheck(posX-1,posY)==true) {
		    	movePlayer(posX-1,posY);
		    	posX--;
				}
		    }
			
		if(input.equals("D")) {
			if (preCheck(posX+1,posY)==true) {
				movePlayer(posX+1,posY);
				posX++;
			}
		}
	}
}

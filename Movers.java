package mondayDemo;


public class Movers {
	private int posX;
	private int posY;

	public Movers() {
		posX=1;
		posY=1;
	}
	
	public Movers(int setPosX,int setPosY) {
		posX= setPosX;
		posY=setPosY;
		
	}
	public int getX() {
		return posX;
	}
	
	public int getY() {
		return posY;
	}

	public boolean preCheck(int checkX, int checkY) { // if false you cannot move there
		boolean canMove=true;
		if (Core.map1.getPos(checkX,checkY)=='#') canMove=false; 
		else if (Core.map1.getPos(checkX,checkY)=='x') {
			canMove=true;
			Player.monsterFight();
		}
		return canMove;
		
	}
	
	private void movePlayer(int newX,int newY) {
		Core.map1.setSpace(newX,newY,'O');
		Core.map1.setSpace(posX,posY,' ');
	}
	

	public void move(String input){
		
		Core.map1.setSpace(posX,posY,'O'); // this fixes the bug when character disappears when touching wall
		
		if(input.equals("w")){	 
			if (preCheck(posX,posY-1)==true) {
				movePlayer(posX,posY-1);
				posY--;
			}
		}
		
		if(input.equals("s")) {
			if (preCheck(posX,posY+1)==true) {
				movePlayer(posX,posY+1);
				posY++;
				}
			}
			
			
		if(input.equals("a")){
		    if (preCheck(posX-1,posY)==true) {
		    	movePlayer(posX-1,posY);
		    	posX--;
				}
		    }
			
		if(input.equals("d")) {
			if (preCheck(posX+1,posY)==true) {
				movePlayer(posX+1,posY);
				posX++;
			}
			
	
		}
	}
}

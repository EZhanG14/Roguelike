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
		if (core.map1.getPos(checkX,checkY)=='#') canMove=false; 
		else if (core.map1.getPos(checkX,checkY)=='x') {
			canMove=true;
			player.monsterFight();
		}
		return canMove;
		
	}
	
	private void movePlayer(int newX,int newY) {
		core.map1.setSpace(newX,newY,'O');
		core.map1.setSpace(posX,posY,' ');
	}
	

	public void move(String input){
		
		core.map1.setSpace(posX,posY,'O'); // this fixes the bug when character disappears when touching wall
		
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

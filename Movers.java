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
		if (Core.map1.getPos(checkX,checkY)=='x') Player.monsterFight();		
		if (Core.map1.getPos(checkX,checkY)=='!') Player.addInv('!');
		if (Core.map1.getPos(checkX,checkY)=='$') Core.setGameLoop(false);
			
		
		return canMove;
		
	}
	
	private void movePlayer(int newX,int newY) {
		Core.map1.setSpace(newX,newY,'O');
		Core.map1.setSpace(posX,posY,' ');
	}
	

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

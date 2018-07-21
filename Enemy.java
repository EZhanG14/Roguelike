package mondayDemo;

public class Enemy extends Movers{
	private static int posX ;
	private static int posY;
	private static boolean Enemy;
	private static int EnemyposX=5;
	private static int EnemyposY=5;

	private static int EnemyXcheck=EnemyposX-posX;
	private static int EnemyYcheck=EnemyposY-posY;
	
	public static void moveEnemy(){
		
		
	if(EnemyXcheck>0&&EnemyYcheck>0)
	{ 
	    
			Core.map1.setSpace(EnemyposX-1,EnemyposY-1,'X');
			Core.map1.setSpace(EnemyposX,EnemyposY,' ');
			EnemyposX--;
			EnemyposY--;
			
	}else if (EnemyYcheck>0&&EnemyXcheck<=0) {
		Core.map1.setSpace(EnemyposX-1,EnemyposY+1,'X');
		Core.map1.setSpace(EnemyposX,EnemyposY,' ');
		EnemyposY--;
		EnemyposX++;
		
		}
	else if (EnemyYcheck<=0&&EnemyXcheck>0) {
		Core.map1.setSpace(EnemyposX,EnemyposY-1,'X');
		Core.map1.setSpace(EnemyposX,EnemyposY,' ');
		EnemyposY++;
		EnemyposX--;
		
		}
	else if (EnemyYcheck<0&&EnemyXcheck<0) {
		Core.map1.setSpace(EnemyposX+1,EnemyposY+1,'X');
		Core.map1.setSpace(EnemyposX,EnemyposY,' ');
		EnemyposY++;
		EnemyposX++;
		
		}
	else {
		Core.map1.setSpace(EnemyposX,EnemyposY,'X');
	}
	if(EnemyXcheck+EnemyYcheck==0||EnemyXcheck+EnemyYcheck==-1||EnemyXcheck+EnemyYcheck==-2||EnemyXcheck+EnemyYcheck==1||EnemyXcheck+EnemyYcheck==2)
	{
		Core.map1.setSpace(posX,posY,'X');
		Core.map1.setSpace(EnemyposX,EnemyposY,' ');
		EnemyposX=posX;
		EnemyposY=posY;
	}
	
	
	
	
	
	
	if(posX==EnemyposX&&posY==EnemyposY) {
		Enemy=true;
	}

}

}
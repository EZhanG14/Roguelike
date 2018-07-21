package noslick2D;
import java.util.Scanner;
public class EnemyandFinalpointmover {
	private static int posX ;
	private static int posY;
	private static boolean Enemy;
	private static int EnemyposX;
	private static int EnemyposY;

	private static int EnemyXcheck=EnemyposX-posX;
	private static int EnemyYcheck=EnemyposY-posY;
	if(EnemyXcheck>0&&EnemyYcheck>0)
	{
		
	     
	
			core.map1.setSpace(EnemyposX-1,EnemyposY-1,'X');
			core.map1.setSpace(EnemyposX,EnemyposY,' ');
			EnemyposX--;
			EnemyposY--;
			
	}else if (EnemyYcheck>0&&EnemyXcheck<=0) {
		core.map1.setSpace(EnemyposX-1,EnemyposY,'X');
		core.map1.setSpace(EnemyposX,EnemyposY,' ');
		EnemyposY--;
		
		}
	else if (EnemyXcheck<=0&&EnemyXcheck>0) {
		core.map1.setSpace(EnemyposX,EnemyposY-1,'X');
		core.map1.setSpace(EnemyposX,EnemyposY,' ');
		EnemyposY--;
		
		}
	else if (EnemyYcheck<=0&&EnemyXcheck<=0) {
		core.map1.setSpace(EnemyposX+1,EnemyposY+1,'X');
		core.map1.setSpace(EnemyposX,EnemyposY,' ');
		EnemyposY++;
		EnemyposX++;
		
		}
	
	
	
	
	
	
	
	if(posX==EnemyposX&&posY==EnemyposY) {
		Enemy=true;
	}

}

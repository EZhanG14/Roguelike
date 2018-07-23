package mondayDemo;

import mondayDemo.Core;

public class Enemy{
	
		
		
		private static int EnemyposX=4;
		private static int EnemyposY=4;
		private static int randomvalue;
		
		
	
		
		

	
		
		public static void moveEnemy(){
			
			
			if (Player.enemyalive=false) {
				randomvalue=0;
			}else {
				randomvalue=(int)(1+Math.random()*(4));
			}
			if (randomvalue==1&&(Core.map1.getPos(EnemyposX-1,EnemyposY)==' ')) {
				Core.map1.setSpace(EnemyposX-1,EnemyposY,'x');
				Core.map1.setSpace(EnemyposX,EnemyposY,' ');
				EnemyposX--;
				
			}else if(randomvalue==2&&(Core.map1.getPos(EnemyposX+1,EnemyposY)==' ')) {
				Core.map1.setSpace(EnemyposX+1,EnemyposY,'x');
				Core.map1.setSpace(EnemyposX,EnemyposY,' ');
				EnemyposX++;
				
			}else if(randomvalue==3&&(Core.map1.getPos(EnemyposX,EnemyposY+1)==' ')) {
				Core.map1.setSpace(EnemyposX,EnemyposY+1,'x');
				Core.map1.setSpace(EnemyposX,EnemyposY,' ');
				EnemyposY++;
				
			}else if(randomvalue==4&&(Core.map1.getPos(EnemyposX,EnemyposY-1)==' ')) {
				Core.map1.setSpace(EnemyposX,EnemyposY-1,'x');
				Core.map1.setSpace(EnemyposX,EnemyposY,' ');
				EnemyposY--;
				
			}else if (randomvalue==0)
					{
				Core.map1.setSpace(EnemyposX,EnemyposY,' ');
					}
			else {
				Core.map1.setSpace(EnemyposX,EnemyposY,'x');
				
			}
			
					
		
		
		
		
		
		
		
		
		
  
	}
		}


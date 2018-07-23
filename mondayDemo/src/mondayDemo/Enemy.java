package mondayDemo;

import mondayDemo.Core;

public class Enemy extends Movers{
		
		
		private static int EnemyposX=4;
		private static int EnemyposY=4;
		private static int randomvalue;
// int the location of enemy and randomvalue
		/**
		 * EnemyposX is the x position and EnemyposY is the y position.
		 */
	
		//use the randomvalue to randomly choose the action of enemy
		public static void moveEnemy(){
			
			randomvalue= (int)(1+Math.random()*(4-1+1));
			if (randomvalue==1&&(Core.map1.getPos(EnemyposX-1,EnemyposY)!='#') ) {
				Core.map1.setSpace(EnemyposX-1,EnemyposY,'x');
				Core.map1.setSpace(EnemyposX,EnemyposY,' ');
				EnemyposX--;
				
			}else if(randomvalue==2&&(Core.map1.getPos(EnemyposX+1,EnemyposY)!='#')) {
				Core.map1.setSpace(EnemyposX+1,EnemyposY,'x');
				Core.map1.setSpace(EnemyposX,EnemyposY,' ');
				EnemyposX++;
				
			}else if(randomvalue==3&&(Core.map1.getPos(EnemyposX,EnemyposY+1)!='#')) {
				Core.map1.setSpace(EnemyposX,EnemyposY+1,'x');
				Core.map1.setSpace(EnemyposX,EnemyposY,' ');
				EnemyposY++;
				
			}else if(randomvalue==4&&(Core.map1.getPos(EnemyposX,EnemyposY-1)!='#')) {
				Core.map1.setSpace(EnemyposX,EnemyposY-1,'x');
				Core.map1.setSpace(EnemyposX,EnemyposY,' ');
				EnemyposY--;
				
			}
			else {
				Core.map1.setSpace(EnemyposX,EnemyposY,'x');
				
			}
			/**
			 * if the random value is 1, enemy will move left.
			 * if the random value is 2, enemy will move right.
			 * if the random value is 3, enemy will move down.
			 * if the random value is 4, enemy will move up.
			 * if the way which they are going to move get blocked, enemy will stay.
			 */
			
			
		
		
		
		
		
		
		
		
		
  
	}
		}
	


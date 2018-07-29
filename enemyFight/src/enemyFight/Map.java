package enemyFight;

import javafx.scene.Group;

import javafx.scene.image.ImageView;

public class Map {
	 int size=12;
	 ImageView[][] map = new ImageView[size][size];
	 Group walls= new Group();
	 Group chests= new Group();
	
	
	 public void createMap(String layout) {
		  		int posX = 0;
		  		int posY=0;
		  		
		  		for (int i = 0; i < layout.length(); i++){
		  			System.out.println(layout.length());
		  			/*System.out.println("yWalls "+yWalls); 
					System.out.println("xWalls "+xWalls); 
					System.out.println("xPos"+posX);
					System.out.println("yPos"+posY);
					System.out.println();*/
		  			
		  			if(i%size==0 &&i!=0){
		  				posY++;
		  				posX=0;
		  			}
		  			else if (i!=0)posX++;	
		  			
		  			if( layout.charAt(i)=='#'){
		  			
		
						
		  					map[posX][posY]= new ImageView();   
		  		      		map[posX][posY].setImage(Core.brick);
		  		      		
		  		      		map[posX][posY].setLayoutX(posX*50);//map[i][j].getLayoutBounds().getWidth());
		  		      		map[posX][posY].setLayoutY(posY*50);//map[i][j].getLayoutBounds().getHeight());
		  		      		walls.getChildren().add(map[posX][posY]);
		  	  			}
		  			else if( layout.charAt(i)=='!'){
		  				map[posX][posY]= new ImageView();   
		  				map[posX][posY].setImage(Core.chest);
		  				map[posX][posY].setFitHeight(50);
		  				map[posX][posY].setFitWidth(50);
		  				map[posX][posY].setLayoutX(posX*50);//map[i][j].getLayoutBounds().getWidth());
		  				map[posX][posY].setLayoutY(posY*50);//map[i][j].getLayoutBounds().getHeight());
		  				chests.getChildren().add(map[posX][posY]);
		  			
		  
	
		}
		  			 
	 }
		  		}
	 }


		  		
	 


/**/



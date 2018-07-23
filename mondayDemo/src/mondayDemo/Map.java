package mondayDemo;

/**
 * Map class creates an instance of a tile based map using a 2 dimensional array
 * includes methods for modifying the map to move characters around
 * 
 * @authorT01 Group 4
 * @author Gavin Guinn
 * @since July 22, 2018
 * @version 1.0
 */
public class Map {
	/**
	 * mSizeX Size of the map in the x dimension
	 */
	private static int mSizeX=8;
	
	/**
	 * mSizeY Size of the map in the y dimension
	 */
	private static int mSizeY=8;
	
	/**
	 * map 2 dimensional char array that holds the map data
	 */
	private char[][] map = new char[mSizeY][mSizeX];
	
	/**
	 * createMap fills the map array with the String passed to it 
	 * @param layout String of size mSizeX*mSizeY populates the map
	 * 
	 * bugs: if layout is the wrong length the map is not created properly
	 */
	public void createMap(String layout) {
		int posX = 0;
		int posY=0;
		for (int i = 0; i < layout.length(); i++){
		
			if (i % mSizeX==0 && i !=0) { // i!=0 because i only want the counter to iterate on multiples of mSizeX.  0%(mSizeX)=0 unintentionally satisfying the if condition
				posY++;
				posX=0;
			}
			
			map[posY][posX] = layout.charAt(i);
			posX++;
		}
	}
	/**
	 * printMap prints the map array to the terminal in a nicely formatted way 
	 */
	public void printMap() {
		for(int i=0; i<mSizeY; i++) {
			for(int j=0; j<mSizeX; j++){
				System.out.print(map[i][j]);
				System.out.print(" ");
			}
		System.out.println();
		}
	}
	
	/**
	 * getPos checks the tile indicated by the parameters and returns the char
	 * @param xPos x coordinate to be checked
	 * @param yPos y coordinate to be checked
	 * @return char held in that position 
	 */
	public char getPos(int xPos,int yPos) {
		char tile;
		tile=map[yPos][xPos];
		return tile;
	}
	/**
	 * setSpace changes a character in the map array
	 * @param xPos x coordinate to be changed
	 * @param yPos y coordinate to be changed
	 * @param character to change the position to 
	 */
	public void setSpace(int xPos, int yPos, char tile){
		map[yPos][xPos]= tile;
	}
	
}
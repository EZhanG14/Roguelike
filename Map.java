package mondayDemo;



public class Map {
	private static int mSizeX=8;
	private static int mSizeY=8;
	private char[][] map = new char[mSizeY][mSizeX];
	
	
	
	public  void createBlankMap(char fill){
		for(int i=0; i<mSizeY; i++) {
			for(int j=0; j<mSizeX; j++) {
				map[i][j]=fill;
				
			}
		}
	}
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
	
	public void printMap() {
		for(int i=0; i<mSizeY; i++) {
			for(int j=0; j<mSizeX; j++){
				System.out.print(map[i][j]);
				System.out.print(" ");
			}
		System.out.println();
		}
	}
	
	public char getPos(int xPos,int yPos) {
		char tile;
		tile=map[yPos][xPos];
		return tile;
		
	}
	public void setSpace(int xPos, int yPos, char tile){
		map[yPos][xPos]= tile;
	}
	
}

package mondayDemo;



public class map {
	static int mSizeX=8;
	static int mSizeY=8;
	static char[][] map = new char[mSizeY][mSizeX];
	
	public static void main(String[] args) {
			createMap();
			printMap();
		}
	

	
	public static void createMap(){
		for(int i=0; i<mSizeY; i++) {
			for(int j=0; j<mSizeX; j++) {
				map[i][j]='#';
			}
		}
	}
	
	public static void printMap() {
		for(int i=0; i<mSizeY; i++) {
			for(int j=0; j<mSizeX; j++){
				System.out.print(map[i][j]);
				System.out.print(" ");
			}
		System.out.println();
		}
	}
	
}




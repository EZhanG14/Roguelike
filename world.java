package mondayDemo;

import java.util.Arrays;

public class world {
	public static void main(String[] args) {
		int mSizeX=8;
		int mSizeY=8;
		char[][] map;
		map= new char[mSizeY][mSizeX];
		
		for(int i=0; i<mSizeY; i++) {
			for(int j=0; j<mSizeX; j++) {
				map[i][j]='#';
			}
		}
		for(int i=0; i<mSizeY; i++) {
			for(int j=0; j<mSizeX; j++){
				System.out.print(map[i][j]);
				System.out.print(" ");
				
			}
			System.out.println();
		}
	}
}

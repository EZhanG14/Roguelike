package mondayDemo;
import java.util.Scanner;
//sorry for the bad documentation everyone!
public class Core {
	Scanner myScan=new Scanner(System[] args)
	{
		player p1=new player();
		p1.power=1;
		System.out.println("Player set your Name");
		String p1.Name=myScan.nextline();
		p1.setname(p1.Name);
//Get Sword Change power to 3	
		 p1.setpower(3);
		
		
	}
	public static void main(String[] args) {
	Map map1 = new Map();
	
	String map = "########" +
			     "#______#" +
			     "#______#" +
			     "#______#" +
			     "#______#" +
			     "#______#" +
			     "#______#" +
			     "########" ;
	map1.createMap(map);
	map1.printMap();
	
	}
}

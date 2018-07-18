package mondayDemo;
//sorry for the bad documentation everyone!
public class Core {
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

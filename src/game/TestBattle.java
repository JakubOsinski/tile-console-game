package game;

public class TestBattle 
{
	static String map[][] = new String[8][8];
	public static void main(String [] args) {
		
	//	String map[][] = new String[8][8];
		for(int i =0; i < 8; i++) 
		{
			for(int j =0; j < 8; j++)  {
				map[i][j] = "X";
			}
		}
		
	
		checkMap();
		System.out.println();
		map[0][5] = "Z";
		map[0][2] = "C";
		checkMap();
		
	}
	

	
	public static void checkMap() {
		for(int i =0; i < map.length;i++) 
		{
			for(int j =0; j < map.length;j++) {
				System.out.print(map[i][j] + " ");
			}
System.out.println();
		}
	}
	
}

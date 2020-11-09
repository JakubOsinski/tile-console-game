package mapelements;
import java.util.ArrayList;

public class Monsters 
{

	public static ArrayList<int[]> getMonstersByID(int zone)
	{
		ArrayList<int[]> monsters = new ArrayList<int[]>();
		int monsterArrayDetails = 5;
		int[]monster1 = new int[monsterArrayDetails];
		int[]monster2 = new int[monsterArrayDetails];
		int[]monster3 = new int[monsterArrayDetails];
		
	//	int []m = {1,1,1,1,1}; //add.(m); int []m = {1,1,1,2,2};.addm
		switch(zone)
		{// index of map, element type, monster interactionN, monster location(y,x)
		case 1: monster1[0] = zone; monster1[1] = 2;monster1[2] = 1;  monster1[3] = 4; monster1[4] = 0; // index of map, id of chest, chest location(y,x)
		monsters.add(monster1);  
		        break;
		case 2:
			monster1[0] = zone; monster1[1] = 2;monster1[2] = 2;  monster1[3] = 4; monster1[4] = 3;
			monsters.add(monster1); 
			monster2[0] = zone; monster2[1] = 2;monster2[2] = 2;  monster2[3] = 6; monster2[4] = 2;
			monsters.add(monster1); 
			monster3[0] = zone; monster3[1] = 2;monster3[2] = 2;  monster3[3] = 1; monster3[4] = 5;
			monsters.add(monster1);  	monsters.add(monster2);  	monsters.add(monster3); 
		        break;
		case 0:
			monster1[0] = zone; monster1[1] = 2;monster1[2] = 3;  monster1[3] = 1; monster1[4] = 3; // y, x
			monsters.add(monster1); 
		        break;
		
		}
		return monsters;
	
	}
	
	//check if coordinates passed here don't overlap with other elements in this zone;;; elementIndex = monster or chest
//	public static void checkSpace(int zone, int elementIndex, int x, int y) 
	public static void checkSpace(int zone) 
	{
		ArrayList<int[]> usedCoordinates = new ArrayList<int[]>();		
		 ArrayList<int[]> mapChests = Chests.getChestsByID(zone);
		 
		for(int i =0;i < mapChests.size(); i++) {
		//	usedCoordinates.add(mapChests.get(i)[3]);
			int[] aa = {mapChests.get(i)[2],mapChests.get(i)[3]};
			usedCoordinates.add(aa);
		}
		
		System.out.println("testing map coordinates, should print out all chest coordinates from desired zone");
		 for(int i = 0; i < usedCoordinates.size(); i++) {
				System.out.println("X : " +usedCoordinates.get(i)[0]); System.out.println("Y : " +usedCoordinates.get(i)[1]);
		 }
		 
		//mapExits = Maps.getZoneExitsByID(zone);
	//	private ArrayList<int[]> mapChests = Chests.getChestsByID(zone);
	//	this.mapMonsters = Monsters.getMonstersByID(zone);
		
		

	}
	
		
	//public static ArrayList<Integer> chestsLooted = new ArrayList<Integer>();
	
	
	//fill map zone with monsters

	

	
}

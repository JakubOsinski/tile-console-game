package game;

import java.util.ArrayList;

public class RandomMaps {

	/**
	 * @return number of each map elements
	 */
		public static int[] getMapElementsN(int mapLevel, int mapElementTypes) {
			int []mapElementsN = new int[mapElementTypes];
			for(int i =0; i < mapElementTypes; i++) {
				mapElementsN[i] = getElementsN(mapLevel, i);
			}
			return mapElementsN;
		}
	public static int getElementsN(int mapLevel, int type) {
		int elementsN =0;
		switch(type) {
		case 0: elementsN =getExitNByMapLevel(mapLevel); 
			break;
		case 1: elementsN =getChestNByMapLevel(mapLevel);
			break;
		case 2: elementsN =getMonstersNByMapLevel(mapLevel); 
			break; 
//		case 3: elementsN =getObstacleNByMapLevel(mapLevel); 
//		break; 
		}
		return elementsN;
	}
	
	public static int[] getMapSizeByMapLevel(int mapLevel)
	{
		int[] mapSize = new int[2];
		switch(mapLevel) {
		case 1: mapSize[0] = 5; mapSize[1]	= 5	;
		break;
		case 2: mapSize[0] = 7; mapSize[1]	= 7	;
		break;
		case 3: mapSize[0] = 9; mapSize[1]	= 9	;
		break;
		case 4: mapSize[0] = 11; mapSize[1]	= 11;
		break;
		case 5: mapSize[0] = 12; mapSize[1]	= 12;
		break;
		case 6: mapSize[0] = 12; mapSize[1]	= 12;
		break;
		case 7: mapSize[0] = 12; mapSize[1]	= 12;
		break;
				}
		return mapSize;
	}
	public static int getChestNByMapLevel(int mapLevel)
	{
		switch(mapLevel) {
		case 0: return 0;
		case 1: return 2;
		case 2: return 4;
		case 4: return 8;
		case 5: return 10;
		case 6: return 12;
		case 7: return 12;
		default: return 0;
		}
	}
	public static int getExitNByMapLevel(int mapLevel) {
		int exitN = 1;
		return exitN;
	}
	public static int getMonstersNByMapLevel(int mapLevel)
	{
		switch(mapLevel) {
		case 0: return 0;
		case 1: return 2;
		case 2: return 6;
		case 4: return 8;
		case 5: return 8;
		case 6: return 8;
		default: return 0;
		}
	}

	public static int[] getRNGpos(int mapLevel, ArrayList<int[]> occupiedSpaces) 
	{
		boolean pass = false; int tryCount = 0;
		while(!pass) {
		int []rngPos = getRGEpos(getMapSizeByMapLevel(mapLevel));
		if(!spaceIsOccupied(occupiedSpaces, rngPos[0],rngPos[1])) {
			return rngPos;
		} 
			tryCount++;
			System.out.println(tryCount);
			if(tryCount > (1000 * mapLevel)) {
				System.out.println(tryCount+ " :  tryCount is above " + (1000 * mapLevel) + " exiting program");
			System.exit(0);
			}
		}
		return null;
	}
	
	public static ArrayList<int[]> getRandomMapElements(int mapLevel, ArrayList<int[]> occupiedSpaces, ArrayList<int[]> randomElements) {
		int[] elementsN = getMapElementsN(mapLevel, 3);
		for(int i =0; i < elementsN.length; i++) {
			for(int j =0; j < elementsN[i]; j++) {
				int[] rngPos = getRNGpos(mapLevel, occupiedSpaces);
				int[] randomElement = {mapLevel, i, -1, rngPos[0],rngPos[1]};
				randomElements.add(randomElement);
				occupiedSpaces.add(rngPos);
				}
		}
		return randomElements;
	}

	public static ArrayList<int[]> getRGMapElements(int mapLevel)
	{
		//int[] mapElementsN = getMapElementsN(mapLevel);
		ArrayList<int[]> randomElements = new ArrayList<int[]>(); //to be returned to fill the map with
		ArrayList<int[]> occupiedSpaces = new ArrayList<int[]>(); // AL containing size 2 int[] with y,x space being already used on the map
		boolean obstacle = true;                                   
	    if(obstacle) {
	    	getRandomObstacles(mapLevel, occupiedSpaces, randomElements);
	    }    
	    getRandomMapElements(mapLevel, occupiedSpaces, randomElements);
	//	ArrayList<int[]> occupiedSpaces = getOccupiedSpaces(mapElementsN, mapLevel);
	//	ArrayList<int[]> mapElements = getRandomElements6(mapLevel, occupiedSpaces, mapElementsN);
		return randomElements;
	}
           private static void getRandomObstacles(int mapLevel,ArrayList<int[]> occupiedSpaces,ArrayList<int[]> randomElements )
           {
        	   int[] mapSize = getMapSizeByMapLevel(mapLevel);
        	   int y = mapSize[0]/2; // 2
        		int x = mapSize[1]/2;
        	//	int reAddCount = 0;
        		//pattern 1 aka map cross
        		for(int i =1 ; i< mapSize[1]-1; i++) {
        			int[] randomElement = {mapLevel, 3, -3, y,i};
        			if(!spaceIsOccupied(occupiedSpaces, y,i)) {
        		//	reAddCount++;
        			addOccupiedSpaces(occupiedSpaces, y, i);
        			randomElements.add(randomElement);
        			}
        		}
        		for(int i =1 ; i< mapSize[0]-1; i++) {
        			int[] randomElement = {mapLevel, 3, -3, i,x};
        			if(!spaceIsOccupied(occupiedSpaces, i,x)) {
            	//		reAddCount++;
            			addOccupiedSpaces(occupiedSpaces, i, x);
        			randomElements.add(randomElement);
        		}
        		}
	}
		private static void addOccupiedSpaces(ArrayList<int[]> occupiedSpaces, int y, int x) {
		   int [] newOccupiedSpace = {y,x};
		   occupiedSpaces.add(newOccupiedSpace);
		}
	
/**
 * @param mapSize 
 * generate random y,x coordiantes for map in range 0 to mapSize-1
 */
public static int[] getRGEpos(int[] mapSize) 
{
	int newY = rng(0,mapSize[0]-1);
	int newX = rng(0,mapSize[1]-1);
	int[] elementPos = {newY,newX}; 	
	return elementPos;
}
	public static boolean spaceIsOccupied(ArrayList<int[]> occupiedSpaces, int y, int x)
			//int[] elementPos) 
			{
			// returns true if coordinates on the map are already taken by other element
				if(occupiedSpaces.size() == 0) {
					return false;
				}
				for(int i =0; i < occupiedSpaces.size(); i++) 
				{
				//    if(elementPos[0] == occupiedSpaces.get(i)[0] && elementPos[1] == occupiedSpaces.get(i)[1]) {
					 if(y == occupiedSpaces.get(i)[0] && x == occupiedSpaces.get(i)[1]) {
				    	return true;
				    }
				}
				return false;
			}
	
	public static int rng(int min, int max) {
		int n = (int) (Math.random() * (max - min + 1) + min); 	
	//	System.out.println("rng() returning : " + n);
		return n;
	}
	//get all elements from map into ArrayList<int[]> of occupied spaces
	public static ArrayList<int[]> getOccupiedSpaces(ArrayList<int[]> mapElements) 
	{
		ArrayList<int[]> occupiedSpaces = new ArrayList<int[]>();
		for(int i =0; i < mapElements.size(); i++) {
			int[] occupiedSpace = {mapElements.get(i)[3], mapElements.get(i)[4]};
			occupiedSpaces.add(occupiedSpace);
		}
		// TODO Auto-generated method stub
		return occupiedSpaces;
	}
	public static boolean getRandomInteraction(int mapLevel, Player player, Field interactionField, int type) {
      int randomInteractionType = interactionField.getElementDetails()[1];
	switch(randomInteractionType) 
	{
	case 0:// mapLevel++;// enter new random zone
		return true;
	case 1: // 1 pick up chest based on mapLevel, 2 add to player inventory. 3 delete chest.
		return true;
	case 2: // 1 fight() monster based on maplevel, 2 add loot, add exp, update player. 3 delete monster.
		return true;
	case 3: System.out.println("RandomMaps randomInteractionType = 3");
		return true;
	default: System.out.println("RandomMaps randomInteractionType = returning default");
	return false;
	}
		//return false;
	}
}

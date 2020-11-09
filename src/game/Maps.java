package game;


import java.awt.List;
import java.util.ArrayList;

import mapelements.Chests;
import mapelements.Element;
import mapelements.Letter;
import mapelements.Monsters;

public class Maps 
{	

public static ArrayList<int[]> getZoneExitsByID(int zone) 
{
	int zoneDetails = 5; // // index of map, what index heading to?, y,x
	int[] map1 = new int[zoneDetails]; //second is rows\/ 
	int[] map2 = new int[zoneDetails]; 
	ArrayList<int[]> zoneExits = new ArrayList<int[]>();

	switch(zone)
	{ // interactionIndex 0 == mapLevel--;, interactionIndex 1 == mapLevel++;
	case 1://ARRAY ELEMENTS = index of a map, type, interactionIndex, y,x

	 map1[0] = 1; 	map1[1] = 0; map1[2] = 1; map1[3] = 2; map1[4] = 4; 
	 map2[0] = 1; 	map2[1] = 0; map2[2] = 0; map2[3] = 2; map2[4] = 0; // y,x
	        zoneExits.add(map1);  	zoneExits.add(map2);    
	        break;
	case 2:
	     	map1[0] = 2; 	map1[1] = 0; map1[2] = 1;  map1[3] = 3; map1[4] = 6;
	     	map2[0] = 2; 	map2[1] = 0; map2[2] = 0;  map2[3] = 4; map2[4] = 0;
	     	zoneExits.add(map1);  	zoneExits.add(map2); 
	        break;
	case 0:	 map1[0] = 0; 	map1[1] = 0; map1[2] = 1; map1[3] = 3; map1[4] = 0; //y,x
	      //   map2[0] = 1; 	map2[1] = 0; map2[2] = 0; map2[3] = 3; map2[4] = 3;// error can't go below lvl 0
     zoneExits.add(map1); 
 	//zoneExits.add(map2);
		break;
	case 3:
     	map1[0] = 3; 	map1[1] = 0; map1[2] = 0;  map1[3] = 3; map1[4] = 0;
     	zoneExits.add(map1); 
        break;
	}
	return zoneExits;
}


public static int[] getMapSizeByIndex(int mapIndex) 
{
	int []mapSize = new int[2];
	switch(mapIndex)
	{
	case 0: mapSize[0] = 4;  mapSize[1] = 4; 
	break;
	case 1: mapSize[0] = 5;  mapSize[1] = 5; //mapsize index 0 = y, 1 = x.
	break;
	case 2: mapSize[0] = 8;  mapSize[1] = 8; 
	break;
	case 3: mapSize[0] = 4;  mapSize[1] = 4; 
	break;
	}
	return mapSize;
}

public static ArrayList<int[]> getMapElements(int mapIndex, int state) {
	if(state < 1) {//generate random elements based on mapIndex
	return RandomMaps.getRGMapElements(mapIndex);		
	} else {
		return getMapElements1(mapIndex);
	}}
//
public static ArrayList<int[]> getMapElements1(int mapLevel) 
{// standard map
	ArrayList<int[]> exits = getZoneExitsByID(mapLevel);
	ArrayList<int[]> chests = Chests.getChestsByID(mapLevel);	
	ArrayList<int[]> monsters = Monsters.getMonstersByID(mapLevel);
	ArrayList<int[]> obstacles = Obstacles.getObstaclesByID(mapLevel);
ArrayList<ArrayList<int[]>> allMapElements = new ArrayList<ArrayList<int[]>>();
allMapElements.add(exits); allMapElements.add(chests); allMapElements.add(monsters); allMapElements.add(obstacles);

ArrayList<int[]> mapElements = getMapElements2(allMapElements);	
return mapElements;
}
public static ArrayList<int[]> getMapElements2(ArrayList<ArrayList<int[]>> allMapElements) 
{
	ArrayList<int[]> mapElements = new ArrayList<int[]>();
	ArrayList<int[]> occupiedSpaces = new ArrayList<int[]>();
	for(int i =0; i < allMapElements.size(); i++) {
		for(int j = 0; j <allMapElements.get(i).size(); j++) 
		{
			int y = allMapElements.get(i).get(j)[3]; int x = allMapElements.get(i).get(j)[4];
			if(!RandomMaps.spaceIsOccupied(occupiedSpaces, y,x)) {
				mapElements.add(allMapElements.get(i).get(j));
				int []os = {allMapElements.get(i).get(j)[3], allMapElements.get(i).get(j)[4]};
				occupiedSpaces.add(os);
			} else {
				System.out.println("getMapElements2() in Maps Critical error.");
				System.out.println("y: " + y + " x: " + x +" According to occupiedSpaces -"
						+ " another element already uses those coordinates");
			}}}
	return mapElements;
}
//finished 1
public static int[] getMapSize(int state, int mapIndex) {
	if(state < 1) {
		return RandomMaps.getMapSizeByMapLevel(mapIndex);
	} else {
		return getMapSizeByIndex(mapIndex);
	}
}
public static Letter getLetterByI(int i) {
	Letter l = null;
	switch(i) {
	case 0: l = Constants.MAP_LETTER_EXIT;
	break;
	case 1: l = Constants.MAP_LETTER_CHEST;
	break;
	case 2: l = Constants.MAP_LETTER_MONSTER;
	break;
	case 3: l = Constants.MAP_LETTER_OBSTACLE;
	break;
	case 4: l = Constants.MAP_LETTER_PLAYER;
	break;
	default: l = Constants.MAP_LETTER_EMPTY;
	break;
	}
	return l;
}

public static Element getElementByI(int i) {
	Element e = null;
	switch(i) {
	case 0: e = Element.EXIT;
	break;
	case 1: e = Element.CHEST;
	break;
	case 2: e = Element.MONSTER;
	break;
	case 3: e = Element.OBSTACLE;
	break;
	case 4: e = Element.PLAYER;
	break;
	default: e = Element.EMPTY;
	break;
	}
	return e;
}

public static int[] getPlayerElement(ArrayList<int[]> mapElements) 
{
	for(int i =0; i < mapElements.size(); i++) {
		if(mapElements.get(i)[1] == 4) {
			return mapElements.get(i);
		}
}
	return null;
}

public static int getInteraction(Player player, Field interactionField, ArrayList<int[]> mapElements)
{               //map index, type, interactionIndex
		int elementType = interactionField.getElementDetails()[1];;
	int interactionIndex = interactionField.getElementDetails()[2];
	ArrayList<int[]> mapElementsAfterInteraction = new ArrayList<int[]>();
	switch(interactionField.getElementDetails()[1]) {
case 0: // return getExitInteraction(player, interactionIndex, elementType, mapElements); //System.out.println(isLeapYear?"yes":"no");
	case 1: //Chests.getChestInteraction();
		break;
	case 2://Monsters.getMonsterInteraction();
		break;
	}
	return -999;
}

//public static boolean getInteraction(int mapIndex, Player player, Field interactionField, int interactionIndex) {
//	// TODO Auto-generated method stub
//	return false;
//}


} // end class Maps

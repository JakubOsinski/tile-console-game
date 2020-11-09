package game;

import java.util.ArrayList;

public class Obstacles {

	public static ArrayList<int[]> getObstaclesByID(int mapLevel) 
	{
		int zoneDetails = 5; 
	//	int[] obstacle1 = new int[zoneDetails]; 
		//int[] obstacle2 = new int[zoneDetails]; 
		ArrayList<int[]> obstacles = new ArrayList<int[]>();
		switch(mapLevel)
		{// index of map, element type, obstacle interactionN, obstacle location(y,x)
		case 1: int[] obstacle1 = {mapLevel, 3, 1, 1,4}; 
		int[] obstacle2 = {mapLevel, 3, 1, 0,3}; 
		obstacles.add(obstacle1); 	obstacles.add(obstacle2);
		break;
		case 2: int[] obstacle3 = {mapLevel, 3, 2, 3,4}; 
		obstacles.add(obstacle3);
		}
		return obstacles;
	}

}

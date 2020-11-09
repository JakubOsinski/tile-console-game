package tests;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fight.Devil;
import fight.Goblin;
import fight.Minotaur;
import fight.Monster;
import fight.Skeleton;
import game.Map;
import game.RandomMaps;
import junit.framework.Assert;

class MapTest {

	@Test
	void test() {
		//assertTrue(false,  true);
		
	}
	//   @Test
	    public void testGetChestNByMapLevel() {
		   Map map = new Map(1,2);
		 //  Map map = new Map(1);
		 //test mapsize in accordance to mapLevel
	        Assert.assertEquals(map.getMapSize()[0], 4); 
	        Assert.assertEquals(map.getMapSize()[1], 4);
	        int[] mapSize = {5,5};
	        map.setMapSize(mapSize);
	        Assert.assertEquals(map.getMapSize()[0], 5); 
	        Assert.assertEquals(map.getMapSize()[1], 5);
	        mapSize[0] = 6; mapSize[1] = 6;
	        map.setMapSize(mapSize);
	        Assert.assertEquals(map.getMapSize()[0], 6); 
	        Assert.assertEquals(map.getMapSize()[1], 6);
	        //random chests n
	        int chestN = RandomMaps.getChestNByMapLevel(1);
	        Assert.assertEquals(1, chestN);
	         chestN = RandomMaps.getChestNByMapLevel(2);
	         Assert.assertEquals(1, chestN);
	         chestN = RandomMaps.getChestNByMapLevel(3);
	         Assert.assertEquals(2, chestN);
	        chestN = RandomMaps.getChestNByMapLevel(4);
	        Assert.assertEquals(2, chestN);
	        chestN = RandomMaps.getChestNByMapLevel(5);
	        Assert.assertEquals(3, chestN);
	        chestN = RandomMaps.getChestNByMapLevel(6);
	        Assert.assertEquals(3, chestN);
	    }
	   
	   @Test
	    public void testMonsters() {
Monster d = new Devil(); 
Monster g = new Goblin();
Monster s = new Skeleton();
Monster m = new Minotaur();
int[] dAtk = Monster.getMonsterAttack("Devil");
Assert.assertEquals(d.getmAttack()[2], dAtk[2]); 
int devilInitiative = d.getMonsterStats().get("Initiative");
Assert.assertEquals(devilInitiative, 20); 
	   }



		
	}



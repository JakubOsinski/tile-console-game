package mapelements;
import java.util.ArrayList;

import game.Field;
import game.Player;
import game.RandomMaps;
import item_package.Armor;
import item_package.Armors;
import item_package.Helmets;
import item_package.Item;
import item_package.Weapon;
import item_package.Weapons;

public class Chests 
{
	
	public static ArrayList<Integer> chestsLooted = new ArrayList<Integer>();
	
	
	//fill map zone with chests
	public static ArrayList<int[]> getChestsByID(int zone) 
	{
		ArrayList<int[]> chests = new ArrayList<int[]>();
		int chestDetails = 5;
		int[]chest1 = new int[chestDetails];
		int[]chest2 = new int[chestDetails];
		int[]chest3 = new int[chestDetails];
		
		switch(zone)
		{// 0=index of map, 1=type, chest 2=interaction id,  chest location(3=y,4=x)
		case 1: chest1[0] = 1; 	chest1[1] = 1; chest1[2] = 1; chest1[3] = 4; chest1[4] = 2; // index of map, id of chest, chest location(y,x)
		        chests.add(chest1);  
		        chest2[0] = 1; 	chest2[1] = 1; chest2[2] = 2; chest2[3] = 1; chest2[4] = 1; // index of map, id of chest, chest location(y,x)
		        chests.add(chest2);   
		        break;
		case 2:
			chest1[0] = 2; 	chest1[1] = 1; chest1[2] = 3;chest1[3] = 4; chest1[4] = 3;
		     	chests.add(chest1); 
		        break;
		case 0:
			chest1[0] = 0; 	chest1[1] = 1; chest1[2] = 4; chest1[3] = 2; chest1[4] = 2; // y, x
		     	chests.add(chest1); 
		        break;
//18051322O
		        //offedner 14017697L
	}//160767
		return chests;
	}
	
	//a player picks up contents of chest by chestId
	public static void getLootByChestId(Player player, int chestId) 
	{
		switch(chestId) 
		{ 
		case 1 : if( addLootedChest(chestId)) { System.out.println("chest 1"); player.setGold(player.getGold() + 10);  System.out.println(player.getGold() + " : player gold \n"); player.addItem(Armors.getArmorById(new Armor(), 1));
		player.addItem(Armors.getArmorById(new Armor(), 2)); player.addItem(Armors.getArmorById(new Armor(), 3)); player.addItem(Armors.getArmorById(new Armor(), 4)); player.addItem(Armors.getArmorById(new Armor(), 5)); 
		player.addItem(Armors.getArmorById(new Armor(), 6)); player.addItem(Armors.getArmorById(new Armor(), 7));  player.addItem(Armors.getArmorById(new Armor(), 8));

		player.addItem(Helmets.getHelmetById(new Armor(), 1));
		player.addItem(Helmets.getHelmetById(new Armor(), 2)); player.addItem(Helmets.getHelmetById(new Armor(), 3));};
		player.addItem(Weapons.getWeaponById(new Weapon(), 1));	player.addItem(Weapons.getWeaponById(new Weapon(), 2)); 	player.addItem(Weapons.getWeaponById(new Weapon(), 3)); //add weapon here  
	//	case 1 : addLootedChest(chestId) ? System.out.println("chest 1") : System.out.println("chest 1"); //; System.out.println("chest 1"); player.setGold(player.getGold() + 10);  System.out.println(player.getGold() + " : player gold \n");
		break;
		case 2 : if( addLootedChest(chestId)) { System.out.println("chest 2"); player.setGold(player.getGold() + 20);  System.out.println(player.getGold() + " : player gold \n"); player.addItem(Armors.getArmorById(new Armor(), 2));};
		break;
		case 3 : if( addLootedChest(chestId)) { System.out.println("chest 3"); player.setGold(player.getGold() + 30);  System.out.println(player.getGold() + " : player gold \n"); player.addItem(Armors.getArmorById(new Armor(), 3));};
		break;
		}
	}
	//player can only pick up chest once
	public static boolean addLootedChest(int chestId)
	{
		if(!chestsLooted.contains(chestId)) {
			chestsLooted.add(chestId); 
			return true;
		}
		System.out.println(chestId + " : chest ID is already opened");
		return false;
	}

	public static ArrayList<Item> openChest(int mapIndex, int interactionIndex) 
	{
		ArrayList<Item> chestLoot = new ArrayList<Item>();
		//chestLoot = getRandomItems(mapIndex);
		
	//	ArrayList<Weapon> allWeapons = Weapon.getAllWeapons();
//		chestLoot.add(allWeapons.get(0)); chestLoot.add(allWeapons.get(1));
//		chestLoot.add(allWeapons.get(2));
//		chestLoot.add(allWeapons.get(3)); 	chestLoot.add(allWeapons.get(4));
		ArrayList<Item> allItems = Item.getAllItems();
		allItems.remove(allItems.size()-1);
		allItems.remove(allItems.size()-1);
		allItems.remove(allItems.size()-1);
		return allItems;
		//chestLoot = allItems;
//		chestLoot.add(allItems.get(0)); chestLoot.add(allItems.get(1));
//		chestLoot.add(allItems.get(2)); chestLoot.add(allItems.get(3));
//		chestLoot.add(allItems.get(4)); chestLoot.add(allItems.get(5));
//		chestLoot.add(allItems.get(6)); chestLoot.add(allItems.get(7));
//		chestLoot.add(allItems.get(8)); chestLoot.add(allItems.get(9));
//		chestLoot.add(allItems.get(10)); chestLoot.add(allItems.get(11));
//		chestLoot.add(allItems.get(12)); chestLoot.add(allItems.get(13));
//		chestLoot.add(allItems.get(14)); chestLoot.add(allItems.get(15));
//		chestLoot.add(allItems.get(16)); chestLoot.add(allItems.get(17));
//		chestLoot.add(allItems.get(18)); chestLoot.add(allItems.get(19));
//		chestLoot.add(allItems.get(20));  	chestLoot.add(allItems.get(21)); 
		
//		if(interactionIndex == -1) {
//			chestLoot = getRandomItems(mapIndex);
//		} else {
//			chestLoot =	getChest(mapIndex, interactionIndex);
//		}
	//	Item.checkItems(chestLoot);  
	//	return chestLoot; //add chest loot to player inventory
	}
	public static ArrayList<Item> getRandomItems(int mapIndex) {
		ArrayList<Item> allItems = Item.getAllItems();
		ArrayList<Item> sortedItems = Item.getSortedItems(mapIndex, allItems);//give me all items up to this mapLevel
		//System.out.println("sortedItems.size: " + sortedItems.size());
        if(mapIndex ==0) {return getRandomItems1(mapIndex, 1, sortedItems);}
        
		int maxItems = 100 + (25 * (mapIndex-1)); //125 = lvl 2
		int items = maxItems / 100;
		//System.out.println("items being loot randomly " + items);
		int itemChance = maxItems % 100;
	//	System.out.println(itemChance + " item chance");
		int rngAnotherItemLuck = RandomMaps.rng(0, 100);System.out.println(rngAnotherItemLuck + " rngAnotherItemLuck");
		if(rngAnotherItemLuck <= itemChance) {
			System.out.println("another item looted!");
			items++;
		}
		return getRandomItems1(mapIndex, items, sortedItems);
	}
	
	

	private static  ArrayList<Item>  getRandomItems1(int mapIndex, int items, ArrayList<Item> sortedItems) {
		ArrayList<Item> yourRandomChestItems = new ArrayList<Item>();
		//this range is fine, covers all sortedItems.
		 while(items != 0) {
				int listI = RandomMaps.rng(0, sortedItems.size()-1); //listI = list index
			 if(sortedItems.get(listI).getItemLevel() > 0) {
				 yourRandomChestItems.add(sortedItems.get(listI));
				 items--;
				 sortedItems.remove(listI);
			 }
		 }
		return yourRandomChestItems;
	}

	private static ArrayList<Item> getChest(int mapIndex, int interactionIndex) {
		
		return null;
	}
///////////////test
	public void testRandomChest(int mapIndex, int items, ArrayList<Item> sortedItems) 
		 {
		int listI =- 9;
		//this range is fine, covers all sortedItems.
		while(listI != 18) {
		 listI = RandomMaps.rng(0, sortedItems.size()-1);
		 System.out.println(listI + " :ListI [][][ " + "sortedItems.size:" + " " + sortedItems.size());
		}
		System.out.println(sortedItems.get(listI).getItemName() + " item nameh");
		System.exit(0);
	}
	
}

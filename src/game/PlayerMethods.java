package game;

import java.awt.List;
import java.util.ArrayList;

import item_package.*;

public class PlayerMethods {

	public static int[] getPlayerPosRNG(int moveCount, int mapLevel, ArrayList<int[]> mapElements)
	{                    
		ArrayList<int[]> occupiedSpaces = RandomMaps.getOccupiedSpaces(mapElements);
         return RandomMaps.getRNGpos(mapLevel, occupiedSpaces);
	}

	public static int[] getInitialPlayerPos(int i, int mapLevel, ArrayList<int[]> mapElements, ArrayList<Field> moveHistory) {
		ArrayList<int[]> occupiedSpaces = RandomMaps.getOccupiedSpaces(mapElements);
		
		return getInitialPlayerPos1(mapLevel, occupiedSpaces, moveHistory);
	}

	private static int[] getInitialPlayerPos1(int mapLevel, ArrayList<int[]> occupiedSpaces, ArrayList<Field> moveHistory) 
	{
		int[] playerPos = getStartingPlayerPos(mapLevel, moveHistory);//previously set up player pos after entering new zone.
		if(!RandomMaps.spaceIsOccupied(occupiedSpaces, playerPos[0],playerPos[1])) {
			return playerPos;
		} else {
System.out.println("PlayerMethods. getInitialPlayerPos1() found player space that is already occupied. Error."); System.out.println("Returning null.");
		return null;
		}
	}
	/**
	 *  where on the map is the player firstly placed after he enters new zone? 
	 * @param mapLevel = new zone
	 * @return size 2 int array with player position
	 */
	//player positions after entering new zone
	private static int[] getStartingPlayerPos(int mapLevel,ArrayList<Field> moveHistory) 
	{ // where is player placed first thing after he enters new zone of mapLevel
		int[] playerPos = new int[2];
		int whereYouComeFrom1 = 1;
		//int interactionIndex = getInteractionIndex() 
	try {
		Field whereYouComeFrom = moveHistory.get(moveHistory.size()-1);
         whereYouComeFrom1 = whereYouComeFrom.getElementDetails()[2]; //1 for going +1 a mapLvl or 0 for going -1 mapLvl
	  }  catch(Exception e) {
        	
        }
        if(whereYouComeFrom1 == 1) {
	switch(mapLevel) 
	{
//	case 0: playerPos[0] = 0; playerPos[1] = 1;
//	break;
	case 1: playerPos[0] = 0; playerPos[1] = 0;//
	break;
	case 2: playerPos[0] = 4; playerPos[1] = 1;//
	break;
	case 3: playerPos[0] = 2; playerPos[1] = 0;
	break;
	default: playerPos[0] = 0; playerPos[1] = 1;
	break;
	}} else {
		switch(mapLevel) 
		{
		case 0: playerPos[0] = 2; playerPos[1] = 0;//
		break;
		case 1: playerPos[0] = 2; playerPos[1] = 3;//
		break;
		case 2: playerPos[0] = 3; playerPos[1] = 5;//
		break;
		}
	}
	return playerPos;
	}
	
	
/**
 * equips best eq for player based on their defensive and attack stats.
 * @param inventory equip best items out of ArrayList<Item> inventory
 * @param eq int array of size 4 representing player eq. helmet, armor, weapon, jewelry.
 */
	public static void equipBestEq2(Player player) 
	{
		ArrayList<Item> inventory = player.getInventory(); Item[] eq=player.getEq();
		Item[] playerEq = new Item[4]; 
		try {
		
//		Armor bestHelmet  = null; playerEq[0] = bestHelmet;
//		Armor bestArmor   = null; playerEq[1] = bestArmor;
//		Weapon bestWeapon = null; playerEq[2] = bestWeapon;
//		Armor bestJewelry = null; playerEq[3] = bestJewelry;
		System.out.println("inventory size" + inventory.size());
		for(int i = 0; i< inventory.size(); i++) {
	//		System.out.println(inventory.get(i).getItemId().substring(0,1) + " paf");
			if(reqsPass(player, inventory.get(i))) {
		switch(Integer.parseInt(inventory.get(i).getItemId().substring(0,1))) {
		case 1: eq[0] = findBestArmor("def", inventory.get(i), (Armor)eq[0]);
			break;
		case 2:  eq[1] = findBestArmor("def", inventory.get(i), (Armor)eq[1]);
			break;
		case 3: eq[2] = findBestWeapon("atk", inventory.get(i), (Weapon)eq[2]);
			break;
		case 4:  eq[3] = findBestArmor("def", inventory.get(i), (Armor)eq[3]);
			break;
		}}
		}
//		System.out.println("BEST helmet : " + bestHelmet.getItemName() );
//		System.out.println("BEST ARMORRERERER : " + bestArmor.getItemName() );
//		System.out.println("BEST weapon : " + bestWeapon.getItemName() );
//		System.out.println("BEST jewelry : " + bestJewelry.getItemName() );
//		for(int i =0; i <eq.length;i++) {
//			if(playerEq[i] != null) {
//				System.out.println(" i is not null : " + i);
//			eq[i] = playerEq[i];
//		}else { System.out.println("SPRUTASPRUTASPRUTASPRUTASPRRUTASPRUTA:  " + i);
//			}}
//		player.setEq(eq);
//		eq[0] = bestHelmet;
//		eq[1] = bestArmor;
//		eq[2] = bestWeapon;
//		eq[3] = bestJewelry; 
		}catch(Exception e) {
			System.out.println("PlayerMethods.equipBestEq2(player) exception. : " + e);
		}
	}
	/**
	 * check if player passes item requirements, if yes they can wear that item.
	// *check if playerAttributes like Strength, Dexterity or level are high enough for player to equip this item.
	 */
	public static boolean reqsPass(Player player, Item item) //itemType 1 = armor, itemType 2 = weapon
	{ 
		Object[] attsKeyArray  =  player.getAtts().keySet().toArray();	
		for(int i = 0; i < attsKeyArray.length; i++)
		{
			if(item.getItemAttsReqs().containsKey(attsKeyArray[i])) {
				
				if(item.getItemAttsReqs().get(attsKeyArray[i]) >  player.getAtts().get(attsKeyArray[i])) {
				return false;	
				}	
			}
		}
		return true;
	}

	private static Armor findBestArmor(String criteria, Item item, Armor bestSomething)
	{       
	  if(bestSomething == null) {
		  return   bestSomething = (Armor) item;
	  }
	if(higherDef(item, bestSomething)) {
		  bestSomething = (Armor)item;
	}
return bestSomething;
}
	
	//tbd? findBest instead of findBestWeapon/findBestArmor-
	private static Item findBest(String criteria, Item item, Item bestItem) {
//		Item bestItem = null;
//		Item i = findBest("def", inventory.get(1), bestItem);
//		bestItem = new Weapon();
		if(bestItem == null) {
			  return   bestItem =  item;
		  }
		if(criteria.equals("def")) {
			if(higherDef(item, bestItem)) {
				bestItem = (Armor)item;
			}
		}
		return bestItem;
	}
	
	private static Weapon findBestWeapon(String criteria, Item item, Weapon bestSomething)
	{       
	  if(bestSomething == null) {
		  return   bestSomething = (Weapon) item;
	  }
	if(higherAtk(item, bestSomething)) {
		  bestSomething = (Weapon)item;
	}
return bestSomething;
}
	//does the item have higher def than best armor up to this point?
public static boolean higherDef(Item item, Item bestSomething) {
	if(getArmorDef((Armor)item) > getArmorDef((Armor)bestSomething)) {
		return true;
	} 
	return false;
}
//does the item have higher attack than best weapon up to this point?
public static boolean higherAtk(Item item, Item bestSomething) {
	if(getWeaponDmg((Weapon)item) > getWeaponDmg((Weapon)bestSomething)) {
		return true;
	} 
	return false;
}
	public static void equipBestEq1(ArrayList<Item> inventory, Item[] eq) 
	{
		ArrayList<ArrayList<Item>> sortedItems = sortEq(inventory);
		//equip armor based on total armor
		//equip weapon based on combined atk value
		Weapon bestWeapon = null; 	Armor bestArmor = null;
		for(int i =0;i < sortedItems.size(); i++) {
			for(int j = 0; j < sortedItems.get(i).size();j++) {
			//	if(sortedItems.get(i).get(j).getItemId().substring(0).equals("3")) 
				if(i == 2){
					eq[i] = bestWeapon = equipBestWeapon(bestWeapon, i, sortedItems.get(i).get(j));//get best weapon
				} else {	
					bestArmor = equipBestArmor(bestArmor, i, sortedItems.get(i).get(j)); // equip armor based on critieria, in this case it's def
					if(j == sortedItems.get(i).size()-1) {
						eq[i] = bestArmor;
						System.out.println("BEST ARMORRERERER : " + bestArmor.getItemName() + " index " + i);
					}
				}
			} 
		}
		System.out.println("BEST WEAPONOASKDAKSDAKDAK : " + bestWeapon.getItemName());
	}

	private static Armor equipBestArmor(Armor bestArmor, int i, Item item) 
	{
	    if(bestArmor == null) {
	        return bestArmor = (Armor) item;
	        } else {
	        	int armorDef = getArmorDef(bestArmor);
	        	int newArmorDef = getArmorDef((Armor)item);
	        	if(newArmorDef > armorDef) {
	        		return (Armor) item;
	        	}
	        }
			return bestArmor;
	}

	private static Weapon equipBestWeapon(Weapon bestWeapon, int i, Item item) {

        if(bestWeapon == null) {
        return bestWeapon = (Weapon) item;
        } else {
        	int weaponDmg = getWeaponDmg(bestWeapon);
        	int newWeaponDmg = getWeaponDmg((Weapon)item);
        	if(newWeaponDmg > weaponDmg) {
        		return (Weapon) item;
        	}
        }
		return bestWeapon;
	}
	public static int getWeaponDmg(Weapon weapon) {
		int weaponDmg = 0;
		for(int i =0; i <weapon.getWeaponAttack().length; i++) {
			weaponDmg = weaponDmg + weapon.getWeaponAttack()[i];
		}
		return weaponDmg;
	}
	public static int getArmorDef(Armor armor) {
		int armorDef = 0;
	//	for(int i =0; i <weapon.getWeaponAttack().length; i++) {
		for(int i =0; i <armor.getArmorDef().length; i++) {
			armorDef = armorDef + armor.getArmorDef()[i];
		}
		return armorDef;
	}

	private static ArrayList<ArrayList<Item>> sortEq(ArrayList<Item> inventory) {
		ArrayList<Item> helmets = new ArrayList<Item>(); ArrayList<Item> armors = new ArrayList<Item>();
		ArrayList<Item> weapons = new ArrayList<Item>(); ArrayList<Item> jewelry = new ArrayList<Item>();
		ArrayList<Item> otherItems = new ArrayList<Item>();
			ArrayList<ArrayList<Item>> sortedItems =  new ArrayList<ArrayList<Item>>();// items sorted into theirr types, i0 = helm,armor,weapon,jewelry
sortedItems.add(helmets); sortedItems.add(armors); sortedItems.add(weapons); sortedItems.add(jewelry);

            for(int i =0; i < inventory.size(); i++) {
				switch(Integer.parseInt(inventory.get(i).getItemId().substring(0,1)))
			{
				case 1: helmets.add(inventory.get(i));
				break;
				case 2: armors.add(inventory.get(i));
				break;
				case 3: weapons.add(inventory.get(i));
				break;
				case 4: jewelry.add(inventory.get(i));
				break;
				default: otherItems.add(inventory.get(i));
				break;
			}}
		return sortedItems;
	}
	/**
	 *Print current eq of player to the console
	 */
	public static void checkPlayerEq(Player player) 
	{//check player eq. if no item equipped, equip standard eq. fist for weapon, naked for armors(0 armor)
	   Item[] eq = player.getEq();
		System.out.println("Player EQ");
		System.out.println("Helmet : " + eq[0].getItemName());
		System.out.println("Armor : " + eq[1].getItemName());
		System.out.println("Ring : " + eq[3].getItemName());

//		System.out.println( "jewelry Def : " + ((Armor)eq[3]).getArmorDef[0]() );
//		System.out.println( "Helmet Def : " + ((Armor)eq[0]).getArmorDefence() );
//		System.out.println( "Armor Def :D : " + ((Armor)eq[1]).getArmorDefence() );
		
		System.out.println( "Strongest weapon name  : " + eq[2].getItemName());
		System.out.println( "Strongest weapon Pierce : " + ((Weapon)eq[2]).getWeaponAttack()[0] );
		System.out.println( "Strongest weapon Slash : " + ((Weapon)eq[2]).getWeaponAttack()[1] );
		System.out.println( "Strongest weapon Bash : " + ((Weapon)eq[2]).getWeaponAttack()[2] );	
		System.out.println( "Strongest weapon Magic : " + ((Weapon)eq[2]).getWeaponAttack()[3] );
	}

	public static int[] getPlayerAtk(Player player) { //note player atk + player def getting use same code
		Item[] eq = player.getEq();
		int[] pAtk = new int[4];
		for(int i =0; i <eq.length; i++)
				{
                   if(isWeapon(eq[i])) { // note: some armors should have attack too
                	   //some armors should have attack too
                	   for(int j = 0;  j < ((Weapon) eq[i]).getWeaponAttack().length; j++) {
                		   pAtk[j] = ((Weapon) eq[i]).getWeaponAttack()[j];
                	   }
                   }
				}
		return pAtk;
	}
//lol
	private static boolean isWeapon(Item item) {
	    try {
	    	int []eqDef = ((Weapon)item).getWeaponAttack(); {
	return true;
}
	    }catch(Exception e) {
	    	return false;
	    }}
	
	//lol
	private static boolean isArmor(Item item) {
	    try {
	    	int []eqDef = ((Armor)item).getArmorDef(); {
	return true;
}
	    }catch(Exception e) {
	    	return false;
	    }
	}

	public static int[] getPlayerDef(Player player) {
		Item[] eq = player.getEq();
		int[] pDef = new int[4];
		for(int i =0; i <eq.length; i++)
				{
                   if(isArmor(eq[i])) { // note: some armors should have attack too
                	   //some armors should have attack too
                	   for(int j = 0;  j < ((Armor) eq[i]).getArmorDef().length; j++) {
                		   pDef[j] =  pDef[j] + ((Armor) eq[i]).getArmorDef()[j];
                	   }
                   }
				}
		return pDef;
	}

}

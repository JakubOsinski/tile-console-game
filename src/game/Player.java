package game;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import fight.Monster;
import item_package.Armor;
import item_package.Armors;
import item_package.Helmets;
import item_package.Item;
import item_package.Jewelry;
import item_package.Weapon;
import item_package.WeaponType;
import item_package.Weapons;
import mapelements.Letter;

/*
 * Endurance, Intelligence, Strength, Dexterity will be 4 main attributes in my game
endurance = max health + little bonus to defence
intelligence = mana + spell power
strength = physical damage bonus + armor/weapon requirements
dex = dodge + (accuracy? maybe?) + some weapon requirements
 */

public class Player extends Fighter
{
	//ArrayList<Unit> units;
	//ArrayList<Item> items;
	private int[] position;
	private int[] screenRadius;
	private ArrayList<Item> inventory;
	private Item [] eq;

	//private int[] playerAttributes; // Endurance, Intelligence, Strength, Dexterity, Luck
	private HashMap<String, Integer> pAtts; // Endurance, Intelligence, Strength, Dexterity, Luck


	private HashMap<String, Integer> pStats; // max health, max mana, initiative, spell power, avoid, defence? accuracy?
	private HashMap<String, Integer> pCurrent; // current health etc
	private ArrayList<Integer> pInfo; // level, current exp, exp to nxt lvl
	/**
	 * starting Endurance, Intelligence, Strength, Dexterity, Luck stats of player at level 1
	 */
		public Player() 
	{
		inventory = new ArrayList<Item>();
		eq = new Item[4]; 
		setPlayer();
	}
	/**
	 * set up level 1 player, called in Player constructor
	 */
	public void setPlayer() {
		pAtts = new HashMap<String, Integer>(); // Endurance, Intelligence, Strength, Dexterity, Luck
		pStats = new HashMap<String, Integer>(); // max health, max mana, initiative, spell power, avoid, defence? accuracy?
		pCurrent = new	HashMap<String, Integer>(); // current health after combat, ??? etc
		pInfo =  new ArrayList<Integer>(); //lvl, gold, exp etc

		//hashmaps allow for easy adding and deleting of elements but arrays might be easier to manage if I will be 100% decided on what I want in the game
		//pAtts.put("Endurance", lvl1PAtts[0]); // player health = 10 + (5 * end) ()if warrior vocation (8*end) [5 * lvl-1]
		//pAtts.put("Intelligence", 2); // player mana = 10 + (5 * int) ()if sorc vocation (10*end), spellpower = 10 + (2 * int, 5 if sorc)
		//pAtts.put("Dexterity", 2);//player avoid = 2 + (2*dex) (5 if rogue)
		//set up lvl 1 attributes for lvl 1 player
		for(int i =0; i < Constants.ATTS_STRING.length; i++) {
			pAtts.put(Constants.ATTS_STRING[i], Constants.LVL1_P_ATTS[i]);
		}//set up LVL1_P_STATS for lvl 1 player
		for(int i =0; i < Constants.STATS_STRING.length; i++) {
			pStats.put(Constants.STATS_STRING[i], Constants.LVL1_P_STATS[i]);
		}
		for(int i =0; i < Constants.CURRENT_STRING.length; i++) {
			pCurrent.put(Constants.CURRENT_STRING[i], Constants.LVL1_P_CURRENT[i]);
		}
		pInfo.add(Constants.LVL1_P_INFO[0]); 	 pInfo.add(Constants.LVL1_P_INFO[1]);  pInfo.add(getExpToNextLVL(pInfo.get(0))); pInfo.add(Constants.LVL1_P_INFO[2]); // level, current exp, exp req nxt lvl, gold
		setFighter(pAtts, pStats, pCurrent, pInfo);

		int[] pAtk = PlayerMethods.getPlayerAtk(this);
		int[] pDef = PlayerMethods.getPlayerDef(this);
		setAtk(pAtk); // player needs to call setAtk and setDef after equipping any eq
		setDef(pDef);

		setSide(2);
		setTurn(false);
	}
	/**
	 * How much experience does player require for next level?
	 * @param level = current player level
	 * @return exp needed for next lvl
	 */
	public int getExpToNextLVL(int level) {
		int currentPlayerLevel = level;
		int nextLVLExpReq = 0;
		switch(currentPlayerLevel) 
		{
		case 1: nextLVLExpReq = 100;
		break;
		case 2: nextLVLExpReq = 300;
		break;
		case 3: nextLVLExpReq = 700;
		break;
		case 4: nextLVLExpReq = 2400;
		break;
		}
		return nextLVLExpReq - this.pInfo.get(1);
	}
	/**
	 * add exp to total player exp, update player level if exp conditions are met.
	 * @param exp exp gained from doing action like defeating an enemy or completing a quest
	 */
	public void addPlayerExp(int exp) 
	{
		int level = pInfo.get(0);
		int currentExp =pInfo.get(1);
		int expForNextLvl = getExpToNextLVL(pInfo.get(2));
	
		
		if(currentExp + exp >=  expForNextLvl) {
			pInfo.set(0, level+1);
			pInfo.set(1, (currentExp + exp));
			pInfo.set(2, getExpToNextLVL(level+1));
		}
	}
	/**
	 * print out player level, current experience, and experience to next level in the console
	 */
	public void showPlayerExp()  
	{
		System.out.println("Player level is : " + pInfo.get(0));
		System.out.println("Player Current Exp is : " + pInfo.get(1));
		System.out.println("Exp to next Level is : " + pInfo.get(2));
	}
	

	public void setScreenRadius(int[] screenRadius) 
	{
		this.screenRadius = screenRadius;
	}
	public int[] getScreenRadius() 
	{
		return screenRadius;
	}
	
	public void setPos(int []position) {
	this.position = position;
}

public int[] getPos() {
	return position;
}
	
	
/**
 *changes player stats
 *@param key - stat key in the playerStats hash map
 *@param val - new value of stay key in playerStats hashMap
 */
	public void changePlayerStats(String key, int val)  // setPlayerStats
	{
	//	this.playerStats.get(key) = val;
		int newVal = val + this.pStats.get(key);
		this.pStats.remove(key);
		pStats.put(key, newVal);
	}
////INVENTORY  INVENTORY INVENTORY INVENTORY INVENTORY INVENTORY

//	}
	public void setInventory(ArrayList<Item> inventory) 
	{
		this.inventory = inventory;
	}
	public ArrayList<Item> getInventory() 
	{
		return inventory;
	}
	public Item[] getEq() {
		return eq;
	}
	public void setEq(Item[] eq) {
		this.eq = eq;
	}
	
	/**
	 * adds type Item item to player inventory whenever player acquires a new item.
	 */
	public void addItem(Item item) 
	{
		inventory.add(item);
	}	
	public void addItems(ArrayList<Item> items) 
	{
		for(int i = 0; i < items.size(); i++) {
			inventory.add(items.get(i));
		}
	}	

	/**
	 * loop through player inventory and print each item name and id to the console
	 */
	public void checkPlayerInventory() 
	{
		for(int i = 0; i < inventory.size(); i++) 
		{
			System.out.println("Item " + (i+1) + " :" + inventory.get(i).getItemName());
			System.out.println("Item ID : " +inventory.get(i).getItemId());
		}
		System.out.println();
	}

	/**
	 * equip starting equipment for player.
	 */
	public void equipBaseEq() {
		eq[0] = Helmets.getHelmetById(new Armor(), 0);
		eq[1] = Armors.getArmorById(new Armor(), 0);
		eq[2] = Weapons.getWeaponById(new Weapon(), 0);
		eq[3] = Jewelry.getJewelryById(new Armor(), 0);
		int[] pAtk = PlayerMethods.getPlayerAtk(this);
		int[] pDef = PlayerMethods.getPlayerDef(this);
		setAtk(pAtk);
		setDef(pDef);
	}
	
	
	
	/**
	 *Find strongest weapon based on their one strongest attack type from array.
	 */
	public Item findStrongestWeapon1(ArrayList<Item> tempItemStyle)  {
		int [] highestDmgWeaponsIndex = new int[tempItemStyle.size()]; // index in player weapons,
		int strongestWeaponDMGsum = 0;
		Item strongestWeapon = null;
		for(int i =0; i < tempItemStyle.size();i++) 
		{
			for(int j = 0; j < ((Weapon)tempItemStyle.get(i)).getWeaponAttack().length; j++)
			{
			
				highestDmgWeaponsIndex[i] = highestDmgWeaponsIndex[i] + ((Weapon)tempItemStyle.get(i)).getWeaponAttack()[j];
			  
			}
			  if(checkItemAttsReqs(tempItemStyle.get(i), 2))	{//
			if(highestDmgWeaponsIndex[i] > strongestWeaponDMGsum) 
			{
				strongestWeaponDMGsum = highestDmgWeaponsIndex[i];
				strongestWeapon = tempItemStyle.get(i);
			}
			  }
		} 
		return strongestWeapon;
	}	
	
	/**
	 *check if playerAttributes like Strength, Dexterity or level are high enough for player to equip this item.
	 */
	public boolean checkItemAttsReqs(Item item, int itemType) //itemType 1 = armor, itemType 2 = weapon
	{ //returns false if the player does not meet item requirements
		Object[] attsKeyArray  =  pAtts.keySet().toArray();	
		for(int i = 0; i < attsKeyArray.length; i++)
		{
			if(item.getItemAttsReqs().containsKey(attsKeyArray[i])) {
				
				if(item.getItemAttsReqs().get(attsKeyArray[i]) > this.pAtts.get(attsKeyArray[i])) {
				return false;	
				}	
			}
		}
		return true;
	}
	public void equipBestEq() {
	PlayerMethods.equipBestEq2(this);
	int[] pAtk = PlayerMethods.getPlayerAtk(this);
	int[] pDef = PlayerMethods.getPlayerDef(this);
	setAtk(pAtk);
	setDef(pDef);
	}
	public void equipBestEq(Player player) {
	PlayerMethods.equipBestEq2(player);
	}
	public int getTotalPDef() {
		int totalDef = 0;
		for(int i =0;i < eq.length;i++) {
			if(i != 2) {
			int []eqDef = ((Armor) eq[i]).getArmorDef();
			for(int j = 0;j <eqDef.length;j++) {
				totalDef = totalDef + eqDef[j];
			}}
		
		}
	//		System.out.println("Exception in Player.getTotalPDef() :" + e) ;
		System.out.println("Total Player def : " + totalDef);
		return totalDef;
	}
}

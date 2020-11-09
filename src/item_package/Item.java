package item_package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Item 
{
	private int itemLevel;
	private String itemId;
	private String itemName;
	private HashMap<String, Integer> itemAttsReqs;

	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemLevel() {
		return itemLevel;
	}
	public void setItemLevel(int itemLevel) {
		this.itemLevel = itemLevel;
	}

	public HashMap<String, Integer> getItemAttsReqs() {
		return itemAttsReqs;
	}
	public void setItemAttsReqs(HashMap<String, Integer> itemAttsReqs) {
		this.itemAttsReqs = itemAttsReqs;
	} 
	
	public static ArrayList<Item> getSortedItems(int mapIndex, ArrayList<Item> allItems)
	{if(mapIndex ==0) {mapIndex=1;};
		 ArrayList<Item> sortedItems = new ArrayList<Item>();
		 for(int i =0; i < allItems.size(); i++) {
			 if(allItems.get(i).getItemLevel() <= mapIndex) {
				 sortedItems.add(allItems.get(i));
			 }
		 }
		// TODO Auto-generated method stub
		return sortedItems;
	}
	public static ArrayList<Item> getAllItems( ) 
	{
		ArrayList<Item> allItems = new ArrayList<Item>();;
		ArrayList<Armor> allArmors = Armors.getAllArmors();
		ArrayList<Armor> allHelmets = Helmets.getAllHelmets();
		ArrayList<Weapon> allWeapons = Weapon.getAllWeapons();
		ArrayList<Armor> alljewelry = Jewelry.getAllJewelry();
allItems.addAll(allArmors); allItems.addAll(allHelmets); allItems.addAll(allWeapons);allItems.addAll(alljewelry);  

		System.out.println(allItems.size() + ": getAllItems() all items size.");
		return allItems;
	}
	public static void checkItems(ArrayList<Item> chestLoot) {
	for(int i =0; i < chestLoot.size(); i++) {
		System.out.println(chestLoot.get(i).getItemLevel() + ": itemLevel");
		System.out.println(chestLoot.get(i).getItemName()+ ": item name");
	}
		
	}

	

}

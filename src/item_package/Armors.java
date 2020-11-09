package item_package;

import java.util.ArrayList;
import java.util.HashMap;

public class Armors 
{
     private final static int ARMORIDPREFIX = 2;
	
	public static Armor getArmorById(Armor armor, int armorId) 
	{
		 armor.setItemId(ARMORIDPREFIX +" " + armorId);
		 armor.setArmorId(armorId);
		 armor.setArmorDef(getArmorsDefById(armorId));
		 armor.setItemAttsReqs(getArmorAttsReqById(armorId)); 

		switch(armorId) 
		{
		case 0:  armor.setItemLevel(0);  armor.setItemName("No Armor"); 
		break;
		case 1:  armor.setItemLevel(1);  armor.setItemName("Cape"); 
		break;
		case 2:  armor.setItemLevel(1);  armor.setItemName("Leather Armor");
		break;
		case 3:  armor.setItemLevel(1);  armor.setItemName("Steel Armor");
		break;
		case 4:  armor.setItemLevel(2);  armor.setItemName("Scale Armor");
		break;
		case 5:  armor.setItemLevel(2);  armor.setItemName("Plate Armor");
		break;
		case 6:  armor.setItemLevel(2);  armor.setItemName("Bronze Armor");
		break;
		case 7:  armor.setItemLevel(3);  armor.setItemName("Royal Armor");	
		break;
		case 8:  armor.setItemLevel(3);  armor.setItemName("Metal Armor"); 
		break;
		}
		return armor;
	}
	
 	private static int[] getArmorsDefById(int itemId) {
		int[] armorDef = new int[4];
		switch(itemId) {
		case 0: armorDef[0] = 2; armorDef[1] = 2; armorDef[2]= 2; armorDef[3]= 2;//no armor
		break;
		case 1: armorDef[0] = 2; armorDef[1] = 4; armorDef[2]= 4; armorDef[3]= 2; //cape
		break;
		case 2: armorDef[0] = 4; armorDef[1] = 5; armorDef[2]= 4; armorDef[3]= 2; //leather armor
		break;
		case 3: armorDef[0] = 6; armorDef[1] = 5; armorDef[2]= 5; armorDef[3]= 2; //steel armor
		break;
		case 4: armorDef[0] = 8; armorDef[1] = 8; armorDef[2]= 8; armorDef[3]= 2; //scale armor
		break;
		case 5: armorDef[0] = 15; armorDef[1] = 6; armorDef[2]= 10; armorDef[3]= 2;//plate armor
		break;
		case 6: armorDef[0] = 16; armorDef[1] = 10; armorDef[2]= 10; armorDef[3]= 2;//bronze armor
		break;
		case 7: armorDef[0] = 20; armorDef[1] = 20; armorDef[2]= 12; armorDef[3]= 8;//royal armor;
		break;
		case 8: armorDef[0] = 20; armorDef[1] = 8; armorDef[2]= 6; armorDef[3]= 10;//metal armor
		break;
		}
		return armorDef;
	}

	public static HashMap<String, Integer> getArmorAttsReqById(int armorId) 
 	{
 		HashMap<String, Integer> attsReq = new HashMap<String, Integer>();

 		switch(armorId) 
 		{
 		case 0: attsReq.put("Strength", 0);  attsReq.put("Dexterity", 0);
 		break;
 		case 1: attsReq.put("Strength", 2);  attsReq.put("Dexterity", 0); attsReq.put("Intelligence", 2); 
		break;
 		case 2: attsReq.put("Strength", 5);  attsReq.put("Dexterity", 0);
		break;
 		case 3: attsReq.put("Strength", 4);  attsReq.put("Dexterity", 0);
 		break;
 		case 4: attsReq.put("Strength", 6);  attsReq.put("Dexterity", 0);
		break;
 		case 5: attsReq.put("Strength", 4);  attsReq.put("Dexterity", 0);
		break;
 		case 6: attsReq.put("Strength", 4);  attsReq.put("Dexterity", 0);
 		break; 	
 		case 7: attsReq.put("Strength", 6);  attsReq.put("Dexterity", 0);
 		break; 	
 		case 8: attsReq.put("Strength", 12);  attsReq.put("Dexterity", 0);
 		break; 	
 		}
 		return attsReq; 
 	}
 	
 	public static ArrayList<Armor> getAllArmors() {
 		ArrayList<Armor> allArmors = new ArrayList<Armor>();
 		allArmors.add(getArmorById(new Armor(),0)); allArmors.add(getArmorById(new Armor(),1)); allArmors.add(getArmorById(new Armor(),2));
 		allArmors.add(getArmorById(new Armor(),3)); allArmors.add(getArmorById(new Armor(),3)); allArmors.add(getArmorById(new Armor(),4));
 		allArmors.add(getArmorById(new Armor(),6)); allArmors.add(getArmorById(new Armor(),7)); allArmors.add(getArmorById(new Armor(),8));
 		return allArmors;
 	}

}

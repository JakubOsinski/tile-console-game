package item_package;
import java.util.ArrayList;
import java.util.HashMap;
public class Jewelry {

     private final static int ARMORIDPREFIX = 4;
	
	public static Armor getJewelryById(Armor jewelry, int jewelryId) 
	{
		jewelry.setItemId(ARMORIDPREFIX +" " + jewelryId);
		jewelry.setArmorId(jewelryId);
		jewelry.setArmorDef(getJewelryDefById(jewelryId));
		jewelry.setItemAttsReqs(getArmorAttsReqById(jewelryId)); 
		switch(jewelryId) 
		{
case 0: jewelry.setItemLevel(0);  jewelry.setItemName("No Jewelry");
		break;
case 1:jewelry.setItemLevel(1);jewelry.setItemName("Protection Ring");
		break;
case 2:jewelry.setItemLevel(2);  jewelry.setItemName("Ruby Ring");
		break;
		}
		return jewelry;
	}
	
 	private static int[] getJewelryDefById(int itemId) {
 		int[] jewelryDef = new int[4];
			switch(itemId) { //lvl 0 no Jewelry
			case 0: jewelryDef[0] = 0; jewelryDef[1] = 0; jewelryDef[2]= 0; jewelryDef[3]= 2;
			break;   // lvl 1 Protection Ring
			case 1: jewelryDef[0] = 4; jewelryDef[1] = 2; jewelryDef[2]= 2; jewelryDef[3]= 2; 
			break; // lvl 2 Ruby Ring
			case 2: jewelryDef[0] = 4; jewelryDef[1] = 6; jewelryDef[2]= 6; jewelryDef[3]= 8;
			break;
//			case 3:
//			break; 
//			case 4:
//			break;
			}
			return jewelryDef;
	}

	public static HashMap<String, Integer> getArmorAttsReqById(int armorId) 
 	{
 		HashMap<String, Integer> attsReq = new HashMap<String, Integer>();
 		switch(armorId) 
 		{
 		case 0: attsReq.put("Strength", 0);  attsReq.put("Dexterity", 0);
 		break;
 		case 1: attsReq.put("Strength", 3);  attsReq.put("Dexterity", 2); 
		break;
 		}
 		return attsReq; 
 	}
 	
 	public static ArrayList<Armor> getAllJewelry() {
 		ArrayList<Armor> allJewelry = new ArrayList<Armor>();
 		allJewelry.add(getJewelryById(new Armor(),0)); allJewelry.add(getJewelryById(new Armor(),1)); allJewelry.add(getJewelryById(new Armor(),2));
 			return allJewelry;
 	}

}

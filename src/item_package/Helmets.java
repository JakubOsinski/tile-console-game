package item_package;

import java.util.ArrayList;
import java.util.HashMap;

public class Helmets 
{
     private final static int ARMORIDPREFIX = 1;
	
 	public static Armor getHelmetById(Armor helmet, int helmetId) 
	{
 		helmet.setItemId(ARMORIDPREFIX +" " + helmetId);
 		helmet.setArmorId(helmetId);
 	//	helmet.setArmorDef(getHelmetsDefById(helmet.getItemId()));
 		helmet.setArmorDef(getHelmetsDefById(helmetId));
 		helmet.setItemAttsReqs(getHelmetAttsReqById(helmetId));
 		
		switch(helmetId) 
		{
		case 0: helmet.setItemLevel(0); helmet.setItemName("No Helmet");
		break;
		case 1: helmet.setItemLevel(1); helmet.setItemName("Steel Helmet");
		break;
		case 2: helmet.setItemLevel(2); helmet.setItemName("Viking Helmet");
		break;
		case 3 :helmet.setItemLevel(2); helmet.setItemName("Knight Helmet");
		break;
		case 4: helmet.setItemLevel(4); helmet.setItemName("Spell Breaker Helmet");
		break;
		}
		return helmet;
	}
 	
 	private static int[] getHelmetsDefById(int itemId) {
 			int[] helmetDef = new int[4];
// 			int armorId = Integer.parseInt(itemId.substring(0,itemId.length()-1));
 			switch(itemId) { //lvl 0 No Helmet
 			case 0: helmetDef[0] = 2; helmetDef[1] = 2; helmetDef[2]= 2; helmetDef[3]= 2;
 			break;  //lvl 1 Steel Helmet
 			case 1: helmetDef[0] = 5; helmetDef[1] = 4; helmetDef[2]= 4; helmetDef[3]= 2; 
 			break; //lvl 2 Viking Helmet
 			case 2: helmetDef[0] = 8; helmetDef[1] = 8; helmetDef[2]= 20; helmetDef[3]= 2;
 			break; //lvl 2 Knight Helmet
 			case 3: helmetDef[0] = 16; helmetDef[1] = 10; helmetDef[2]= 6; helmetDef[3]= 2;
 			break; //lvl 4 Spell Breaker Helmet
 			case 4: helmetDef[0] = 20; helmetDef[1] = 6; helmetDef[2]= 6; helmetDef[3]= 30;
 			break;
 			} 
 			return helmetDef;
 		}

	public static HashMap<String, Integer> getHelmetAttsReqById(int helmetId) 
 	{
 		HashMap<String, Integer> attsReq = new HashMap<String, Integer>();

 		switch(helmetId) 
 		{
 		case 0: attsReq.put("Strength", 0);  attsReq.put("Dexterity", 0);
 		break;
 		case 1: attsReq.put("Strength", 5);  attsReq.put("Dexterity", 0);
		break;
 		case 2: attsReq.put("Strength", 3);  attsReq.put("Dexterity", 0);
		break;
 		case 3: attsReq.put("Strength", 3);  attsReq.put("Dexterity", 0);
 		break;
 		case 4: attsReq.put("Strength", 10);  attsReq.put("Intelligence", 20);
 		break;
 		}
 		return attsReq; 
 	}

 	public static ArrayList<Armor> getAllHelmets() {
 		ArrayList<Armor> allHelmets = new ArrayList<Armor>();
 		allHelmets.add(getHelmetById(new Armor(),0)); allHelmets.add(getHelmetById(new Armor(),1)); allHelmets.add(getHelmetById(new Armor(),2));
 		allHelmets.add(getHelmetById(new Armor(),3)); 	allHelmets.add(getHelmetById(new Armor(),4));
 		return allHelmets;
 	}
 	
}
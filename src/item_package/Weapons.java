package item_package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Weapons 
{
	   public final static int WEAPONIDPREFIX = 3;
		
	 	public static Weapon getWeaponById(Weapon weapon, int weaponId) 
		{
	 		weapon.setItemId(WEAPONIDPREFIX +" " + weaponId);
	 		weapon.setWeaponId(weaponId);
	 		weapon.setWeaponAttack(getWeaponAttackById(weaponId));
	 		weapon.setItemAttsReqs(getWeaponAttsReqById(weaponId));
			switch(weaponId) 
			{
case 0:  weapon.setItemLevel(0); weapon.setWeaponType(WeaponType.FIST); 
weapon.setItemName("Fists");
	        break; 
case 1: weapon.setItemLevel(1); weapon.setWeaponType(WeaponType.SWORD); 
weapon.setItemName("Short Sword");
			break;
case 2:weapon.setItemLevel(1); weapon.setWeaponType(WeaponType.AXE);
weapon.setItemName("Short Axe"); 
			break;
case 3: weapon.setItemLevel(1);   weapon.setWeaponType(WeaponType.BATTLEAXE);
weapon.setItemName("Ogre Axe"); 
			break;
case 4: weapon.setItemLevel(1);  weapon.setWeaponType(WeaponType.STAFF);
			weapon.setItemName("Lunar Staff"); 
			break;
			}
			return weapon;
		}
	 	
	 	public static int[] getWeaponAttackById(int weaponId)
	 	{
	 		int[] weaponAttack = new int[4];
	 		switch(weaponId) 
	 		{  //pierce, slash, bash, magic
	 		case 0: weaponAttack[0] = 5; weaponAttack[1] = 3; weaponAttack[2] = 2; weaponAttack[3] = 5;
	 		break;
	 		case 1: weaponAttack[0] = 4; weaponAttack[1] = 16; weaponAttack[2] = 1; weaponAttack[3] = 0;
	 		break;
	 	case 2: weaponAttack[0] = 51; weaponAttack[1] = 22; weaponAttack[2] = 200; weaponAttack[3] = 0;
	 	break;
	 	case 3: weaponAttack[0] = 355; weaponAttack[1] = 35; weaponAttack[2] = 45; weaponAttack[3] = 0;
	 	break;
		case 4: weaponAttack[0] = 20; weaponAttack[1] = 2; weaponAttack[2] = 5; weaponAttack[3] = 100;
	 	break;
 		}	
	 		return weaponAttack;
	 	}
	 	
	 	public static HashMap<String, Integer> getWeaponAttsReqById(int weaponId) 
	 	{
	 		HashMap<String, Integer> attsReq = new HashMap<String, Integer>();
	 	//	ArrayList<HashMap<String,Integer>> weaponAttsReqs = new ArrayList<HashMap<String,Integer>>();
	 		switch(weaponId) 
	 		{
	 		case 0: attsReq.put("Strength", 0);  attsReq.put("Dexterity", 0);
	 		break;
	 		case 1: attsReq.put("Strength", 1);  attsReq.put("Dexterity", 1);
			break;
	 		case 2: attsReq.put("Strength", 1);  attsReq.put("Dexterity", 1);
			break;
	 		case 3: attsReq.put("Strength", 15);  attsReq.put("Dexterity", 1);
	 		break;
	 		case 4: attsReq.put("Intelligence", 6);  attsReq.put("Dexterity", 3);
	 		break;
	 		}
	 		return attsReq; 
	 	}
	 	
}

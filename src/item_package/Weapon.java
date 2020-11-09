package item_package;

import java.util.ArrayList;

public class Weapon extends Item
{
	  private int weaponId;
	  private int []weaponAttack;
	  private WeaponType weaponType;
	  private int []specialWeaponBonus; //fire, earth, ice, water
	  
	  public Weapon()
	  {
		  
	  }  
	  
	public Weapon(int weaponId, int []weaponAttack, WeaponType weaponType) 
	{
		this.weaponId = weaponId;
		this.weaponAttack = weaponAttack;
		this.weaponType = weaponType;
	//	this.specialWeaponBonus = specialWeaponBonus;
	}

	public int getWeaponId() {
		return weaponId;
	}

	public void setWeaponId(int weaponId) {
		this.weaponId = weaponId;
	}

	public int[] getWeaponAttack() {
		return weaponAttack;
	}

	public void setWeaponAttack(int[] weaponAttack) {
		this.weaponAttack = weaponAttack;
	}

	public WeaponType getWeaponType() {
		return weaponType;
	}

	public void setWeaponType(WeaponType weaponType) {
		this.weaponType = weaponType;
	}

	public static ArrayList<Weapon> getAllWeapons() {
		ArrayList<Weapon> allWeapons = new ArrayList<Weapon>();
		allWeapons.add(Weapons.getWeaponById(new Weapon(),0)); allWeapons.add(Weapons.getWeaponById(new Weapon(),1));
		allWeapons.add(Weapons.getWeaponById(new Weapon(),2)); allWeapons.add(Weapons.getWeaponById(new Weapon(),3));
		allWeapons.add(Weapons.getWeaponById(new Weapon(),4));
		return allWeapons;
	}
   

}

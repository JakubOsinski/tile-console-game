package item_package;


public class Armor extends Item
{
  private int armorId;
//  private int armorName;
  private int[] armorDefence;
  
  
  public Armor()
  {
	  
  }
  
	public Armor(int armorId, int[] armorDefence) {
		super();
		this.armorId = armorId;
//		this.armorName = armorName;
		this.armorDefence = armorDefence;
	}
	
	public Armor(Item item) {
	    
	}
  
  
	public int getArmorId() {
		return armorId;
	}
	public void setArmorId(int armorId) {
		this.armorId = armorId;
	}


//	public int getArmorName() {
//		return armorName;
//	}
//
//	public void setArmorName(int armorName) {
//		this.armorName = armorName;
//	}


	public int[] getArmorDef() {
		return armorDefence;
	}


	public void setArmorDef(int[] armorDefence) {
		this.armorDefence = armorDefence;
	}
//      
	
	
	
}

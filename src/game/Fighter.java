package game;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Fighter 
{
	private HashMap<String, Integer> atts; // Endurance, Intellicurrentce, Strength, Dexterity, Luck
	private HashMap<String, Integer> stats; // max health, max mana, initiative, spell power, avoid, defence? accuracy?
	private HashMap<String, Integer> current; // current health etc
	private ArrayList<Integer> info; // level, current exp, exp to nxt lvl
	private int side;
	private boolean turn;
	//atk[] def[]
	private int[] atk;
	private int[] def;
	protected void setFighter(HashMap<String, Integer> atts, HashMap<String, 
			Integer> stats, HashMap<String, Integer> current, ArrayList<Integer> info) {	
		setAtts(atts); setStats(stats); setCurrent(current); setInfo(info); 
	}

	protected void setFighterAtkDef() {
		
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}
	
	public HashMap<String, Integer> getAtts() {
		return atts;
	}

	public void setAtts(HashMap<String, Integer> atts) {
		this.atts = atts;
	}

	public HashMap<String, Integer> getStats() {
		return stats;
	}

	public void setStats(HashMap<String, Integer> stats) {
		this.stats = stats;
	}

	public HashMap<String, Integer> getCurrent() {
		return current;
	}

	public void setCurrent(HashMap<String, Integer> current) {
		this.current = current;
	}

	public ArrayList<Integer> getInfo() {
		return info;
	}

	public void setInfo(ArrayList<Integer> info) {
		this.info = info;
	}

	public boolean getTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	public int[] getAtk() {
		return atk;
	}

	public void setAtk(int[] fighterAtk) {
		this.atk = fighterAtk;
	}

	public int[] getDef() {
		return def;
	}

	public void setDef(int[] fighterDef) {
		this.def = fighterDef;
	}
	
	public static int coampreByIniThenDexThenLuck(Fighter lhs, Fighter rhs) {// find the fastest fighter
		if(lhs.getStats().get("Initiative") == rhs.getStats().get("Initiative")) 
		{ 
			if(lhs.getAtts().get("Dexterity") == rhs.getAtts().get("Dexterity")) {
				return lhs.getAtts().get("Luck") - rhs.getAtts().get("Luck"); // final
			} else {
				return lhs.atts.get("Dexterity").compareTo(rhs.atts.get("Dexterity"));
			}		
		} else {
			return lhs.stats.get("Initiative").compareTo(rhs.stats.get("Initiative"));
		}
	}
	
	
	
	public static int coampreByIniThenDexThenLuckThenSide(Fighter lhs, Fighter rhs) {// find the fastest fighter
	
		
		
		if(lhs.getStats().get("Initiative") == rhs.getStats().get("Initiative")) 
		{ 
			if(lhs.getAtts().get("Dexterity") == rhs.getAtts().get("Dexterity")) 
			{
				if(lhs.getAtts().get("Luck") == rhs.getAtts().get("Luck")) {
					return lhs.getSide() - rhs.getSide(); // final
				} else {
					return lhs.atts.get("Luck").compareTo(rhs.atts.get("Luck"));
				}
			} else {
				return lhs.atts.get("Dexterity").compareTo(rhs.atts.get("Dexterity"));
			}
				
		} else {
			return lhs.stats.get("Initiative").compareTo(rhs.stats.get("Initiative"));
		}
	}// end coampreByIniThenDexThenLuckThenSide
	public static int compareByMaxHealth(Fighter f1, Fighter f2)
	{
		return f1.getStats().get("Max Health") - f2.getStats().get("Max Health") ; // final
	}
}

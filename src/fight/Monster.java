package fight;

import java.util.ArrayList;
import java.util.HashMap;

import game.Constants;
import game.Fighter;
import item_package.Item;

public abstract class Monster extends Fighter
{
	private int mId;
	private String mName;
//	private int[] mAttack;//player attack calculated in method like calculatePDamage or something, 
	//this is because if played was to have pAttack then i'd need to be updated every time 
	//every small thing changes, like debuff or new item equipped,-maybe I still need to make it like this
	//private int[] mDefence;
	//not set up 
	//private Faction mFaction;
	
	public void setmId(int mId) {
		this.mId = mId;
	}
	public int getmId() {
		return mId;
	}

	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	
	public static int[] getMonsterAttack(String mName) 
	{int[] mAtk = new int[4];
		switch(mName) { // pierce, slash, bash, magic attack
		case "Skeleton":  mAtk[0] = 2; mAtk[1] = 2; mAtk[2] = 2; mAtk[3] = 0;
			break; 
		case "Goblin":  mAtk[0] = 1; mAtk[1] = 2; mAtk[2] = 3; mAtk[3] = 2;
			break; 
		case "Minotaur":  mAtk[0] = 3; mAtk[1] = 8; mAtk[2] = 5; mAtk[3] = 2;
			break;
		case "Devil":   mAtk[0] = 20; mAtk[1] = 4; mAtk[2] = 4; mAtk[3] = 26;
			break;
		}
		return mAtk;
	}

	public static int[] getMonsterDefence(String mName) {
		int[] mDef = new int[4];
		switch(mName) { // pierce, slash, bash, magic defence
		case "Skeleton":  mDef[0] = 3; mDef[1] = 2; mDef[2] = 1; mDef[3] = 1;
			break; 
		case "Goblin":  mDef[0] = 3; mDef[1] = 2; mDef[2] = 5; mDef[3] = 2;
			break; 
		case "Minotaur":  mDef[0] = 6; mDef[1] = 8; mDef[2] = 12; mDef[3] = 12;
			break; 
		case "Devil":   mDef[0] = 8; mDef[1] = 10; mDef[2] = 16; mDef[3] = 30;
			break;
		}
		return mDef;
	}
	/*
	 *monsters currently have attributes. 
	 */
//// Endurance, Intelligence, Strength, Dexterity, Luck //
	public static HashMap<String, Integer> getMonsterAtts(String mName) {
		HashMap<String, Integer> monsterAttributes = new HashMap<String, Integer>();
		int[] mAts = getMonsterAtts2(mName);
		for(int i =0; i < Constants.ATTS_STRING.length; i++) {
			monsterAttributes.put(Constants.ATTS_STRING[i], mAts[i]);
		}
		return  monsterAttributes;
	}
		private static int[] getMonsterAtts2(String mName) {
			int[] mAtts = new int[Constants.ATTS_STRING.length];
			switch(mName) {// Endurance, Strength, Dexterity, Intelligence, Luck //
			case "Skeleton": mAtts[0] = 7; mAtts[1] = 7; mAtts[2] = 6; mAtts[3] = 7; mAtts[4] = 6;  
				break; 
			case "Goblin":  mAtts[0] = 7; mAtts[1] = 7; mAtts[2] = 6; mAtts[3] = 7; mAtts[4] = 6; 
				break; 
			case "Minotaur": mAtts[0] = 5; mAtts[1] = 14; mAtts[2] = 8; mAtts[3] = 6; mAtts[4] = 6; 
				break;
			case "Devil":   mAtts[0] = 10; mAtts[1] = 16; mAtts[2] = 14; mAtts[3] = 12; mAtts[4] = 7; 
				break;
			}
		return mAtts;
	}
	//max health, max mana, initiative, spell power, avoid, defence? accuracy?
	public static HashMap<String, Integer> getMonsterStats(String mName) {
		HashMap<String, Integer> mAtts = new HashMap<String, Integer>();
		//	String [] statsN = {"Max Health", "Initiative", "Spell Power", "Avoid"};
		String [] statsText = Constants.STATS_STRING;
			int[] mStats = getmStats(mName, statsText);
			for(int i =0; i < statsText.length; i++) {
				mAtts.put(statsText[i], mStats[i]);
			}
			return mAtts;	
	}
	//max health, max mana, initiative, spell power, avoid, defence? accuracy?
	// get stats n of some of those things above^
	private static int[] getmStats(String mName, String[] statsN) {
		int[] mStats = new int[statsN.length];
		switch(mName) {
		case "Skeleton": mStats[0] = 20; mStats[1] = 4; mStats[2] = 6; mStats[3] = 2; mStats[4] = 5;
			break; 
		case "Goblin":  mStats[0] = 15; mStats[1] = 2; mStats[2] = 6; mStats[3] = 4; mStats[4] = 5;
			break; 
		case "Minotaur": mStats[0] = 30; mStats[1] = 6; mStats[2] = 8; mStats[3] = 6; mStats[4] = 8;
			break;
		case "Devil":   mStats[0] = 50; mStats[1] = 20; mStats[2] = 8; mStats[3] = 12; mStats[4] = 10;
			break;
		}
		return mStats;
	}
	
	public static HashMap<String, Integer> getMonsterCurrent(String mName) 
	{
		HashMap<String, Integer> mCurrent = new HashMap<String, Integer>();
		int mMaxHealth = getMonsterStats(mName).get("Max Health");
		mCurrent.put("current health", mMaxHealth);
	
		return mCurrent;
	}
	
	/**
	 * @return monsterInfo containing monster level as index 0
	 */
	public static ArrayList<Integer> getMonsterInfo(String mName) {
		ArrayList<Integer> monsterInfo = new ArrayList<Integer>();
		switch(mName) {
		case "Skeleton": monsterInfo.add(1);
			break; 
		case "Goblin":  monsterInfo.add(1);
			break; 
		case "Minotaur": monsterInfo.add(3);
			break;
		case "Devil":  monsterInfo.add(5);
			break;
		}
		return monsterInfo;
	}
	
	/**
	 * @return all monsters into ArrayList<Monster>
	 */
	public static ArrayList<Monster> getAllMonsters() {
		ArrayList<Monster> allMonsters = new ArrayList<Monster>();
        Monster skeleton = new Skeleton(); Monster goblin = new Goblin();
        Monster minotaur = new Minotaur(); Monster devil = new Devil();
        allMonsters.add(skeleton);    allMonsters.add(goblin);    allMonsters.add(minotaur);
        allMonsters.add(devil);
        return allMonsters;
	}
	/**
	 * @param mapLevel
	 * @return all monsters according to mapLevel
	 */
	public static ArrayList<Monster> getSortedMonsters(int mapLevel) {
		ArrayList<Monster> allMonsters = Monster.getAllMonsters();
		 ArrayList<Monster> sortedMonsters = new ArrayList<Monster>();
		 if(mapLevel ==0) {mapLevel=1;}
		 for(int i =0; i < allMonsters.size(); i++) {
		//	 if(allMonsters.get(i).getmLevel() <= mapLevel) {
			 if(allMonsters.get(i).getInfo().get(0) <= mapLevel) {//getInfo().get(0)=monster lvl
				 sortedMonsters.add(allMonsters.get(i));
			 }
		 }
		return sortedMonsters;
	}
	
	
}

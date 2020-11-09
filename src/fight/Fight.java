package fight;

import java.util.ArrayList;
import java.util.HashMap;

import game.Field;
import game.Fighter;
import game.Player;
import game.RandomMaps;
import item_package.Item;
import item_package.Weapon;

public class Fight 
{
	private Player player;
	private ArrayList<int[]> mapElements;
	public Fight(Player player, ArrayList<int[]> mapElements)
	{
		this.player = player;
		this.mapElements= mapElements;
	}

	public static void fight(int mapLevel, Player player, Field interactionField, ArrayList<int[]> mapElements) {
		//generate random enemy based on mapLevel
		ArrayList<Monster> sortedMonsters = Monster.getSortedMonsters(mapLevel);
		int monsterN = RandomMaps.rng(0, sortedMonsters.size()-1);
		//Monster monster = sortedMonsters.get(monsterN); // rng enemy
		Monster monster = sortedMonsters.get(0);
		Monster monster2 = sortedMonsters.get(1);
		Monster monster3 = sortedMonsters.get(1);
		ArrayList<Fighter> fighters = new ArrayList<Fighter>(); 
		fighters.add(player); fighters.add(monster); fighters.add(monster2);fighters.add(monster3);
		
	//fightTurn1(fighters);
		fight(fighters);
	}


	
	private static void fightTurn1(ArrayList<Fighter> fighters) {
		int turns = 0;
		Fighter fastestFighter = FightMethods.gestBest(fighters, turns);
		Fighter weakestFighter = FightMethods.getWeakest(fastestFighter.getSide(), fighters);
        FightMethods.hit(fastestFighter, weakestFighter, fighters);
		
		 fastestFighter = FightMethods.gestBest(fighters, turns+1);
		 weakestFighter = FightMethods.getWeakest(fastestFighter.getSide(), fighters);
		FightMethods.hit(fastestFighter, weakestFighter, fighters);
		// to do,1) delete dead fighter, pass indexes of fighters for easy access?
		 fastestFighter = FightMethods.gestBest(fighters, turns+2);
		 weakestFighter = FightMethods.getWeakest(fastestFighter.getSide(), fighters);
		FightMethods.hit(fastestFighter, weakestFighter, fighters);
		
		 fastestFighter = FightMethods.gestBest(fighters, turns);
		 weakestFighter = FightMethods.getWeakest(fastestFighter.getSide(), fighters);
        FightMethods.hit(fastestFighter, weakestFighter, fighters);
        
        if (FightMethods.getFightStatus(fighters)) {
        	System.out.println("fight IS NOT over");
        } else {
        	System.out.println("fight is over");
        }
        
   	 fastestFighter = FightMethods.gestBest(fighters, turns+1);
	 weakestFighter = FightMethods.getWeakest(fastestFighter.getSide(), fighters);
    FightMethods.hit(fastestFighter, weakestFighter, fighters);
    
    if (FightMethods.getFightStatus(fighters)) {
    	System.out.println("fight IS NOT over");
    } else {
    	System.out.println("fight is over");
    }

	}
// FightMethods returns true if fight is not over
	private static void fight(ArrayList<Fighter> fighters) 
	{
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		boolean fight = true;
		int turns = 0; 
		while(fight) {
		while(turns != fighters.size()) {
			Fighter fastestFighter = FightMethods.gestBest(fighters, turns);
			Fighter weakestFighter = FightMethods.getWeakest(fastestFighter.getSide(), fighters);
	        FightMethods.hit(fastestFighter, weakestFighter, fighters);	
	        turns++;

			System.out.println(fighters.size() + " size of fighters before cheacking fight status");
			if (!FightMethods.getFightStatus(fighters)) {// if only one side remains fight over
				fight = false; // winner
				System.out.println(fighters.get(0).getSide() + " : side of the winner");
                 return;
				}
		}
		turns = 0;
		}
		System.out.println(fighters.size());
	}

	private static void playerHit(ArrayList<Fighter> fighters) {
		//checkSpecial() what special does player have? 1 = for example atack against below 20% health m always kills 
		// pull all player eq to check dmg here? or call get atk? hmmm?
		/*str * get.playerWeapon + dex,luck, if magic atk check int, spellpower, checkmana, 
		 * check m defence, avoid, max health, 
		 * Endurance, Intelligence, Strength, Dexterity, Luck
		pStats = new HashMap<String, Integer>(); // max health, max mana, initiative, spell power, avoid, defence? accuracy?
		pCurrent = new	HashMap<String, Integer>(); // current health after combat, ??? etc
		 */
	//	Weapon pWeapon = ((Player)fighters.get(0)).((Player)getEq[2]);
		int[] playerAtkTotal = new int[4];
		int[] playerAtkWeapon = new int[4];
			Item w =((Player)fighters.get(0)).getEq()[2];
			for(int i =0;i < ((Weapon) w).getWeaponAttack().length; i++) {
				 
			}
		int wAtkSlash = ((Weapon) w).getWeaponAttack()[1];
		int wMagAtk = ((Weapon) w).getWeaponAttack()[3];
		System.out.println("weapon slash attack " + wAtkSlash);
		System.out.println("weapon magic atk " + wMagAtk);
		System.out.println();
		
	}
}

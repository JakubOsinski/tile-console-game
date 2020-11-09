package fight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.DoubleToIntFunction;

import game.*;
import game.Fighter;
import item_package.*;
import game.Player;

public class FightMethods  {

	/**
	 * if the criteria fails player is choosen as the best by default.
	 * this means that if for example, monster and player initiative, dex and luck are all the same 
	 * -player is choosen by default.
	 * @param gestBest fighter out of fighters
	 * @return gest the best fighter out of fighters.
	 */
	public static Fighter gestBest(ArrayList<Fighter> fighters, int turn) { 
fighters.sort(Fighter::coampreByIniThenDexThenLuckThenSide);// after sort fighters.size()-1) = best

	//	System.out.println(fighters.get((fighters.size()-1) - turn).getSide() + " is the side of the best"); 
		return fighters.get((fighters.size()-1) - turn);
	}
	public static Fighter getWeakest(int attackerSide, ArrayList<Fighter> fighters) {
		fighters.sort(Fighter::compareByMaxHealth);
		int count = 0;
		System.out.println(fighters.get(0).getSide() + " is the side");
			while(fighters.get(0 + count).getSide() == attackerSide) {
			count++;
		}
			System.out.println(fighters.get(0+ count).getStats().get("Max Health") + " weakest fighter health");
			System.out.println(fighters.get(0+ count).getSide() + " weakest fighter side");
		return fighters.get(0+ count);
	}
	public static boolean hit(Fighter fastestFighter, Fighter weakestFighter, ArrayList<Fighter> fighters) 
	{
		System.out.println("\nHIT START");
	int []atk = fastestFighter.getAtk();
	int []def = weakestFighter.getDef();
	
int damage = getDmg(atk, def);

	  System.out.println("side " + fastestFighter.getSide() + " hits for " + damage + " damage");
int currentHealth = weakestFighter.getCurrent().get("current health");
if(currentHealth - damage <= 0) {
	weakestFighter.getCurrent().replace("current health", 0);
System.out.println("death : current health " + 	weakestFighter.getCurrent().get("current health"));
	System.out.println(weakestFighter.getSide() + " this side just died...");
	removeFighter(fighters, weakestFighter);
	return true;
} else {
	weakestFighter.getCurrent().replace("current health", (currentHealth - damage));
	System.out.println(weakestFighter.getSide() + " this side survives with health : " + weakestFighter.getCurrent().get("current health"));
	return false;
}
	
	}

	private static void removeFighter(ArrayList<Fighter> fighters, Fighter weakestFighter)
	{
	   for(int i =0; i < fighters.size(); i++) {
		//   if (fighters.get(i) == weakestFighter) {
		   if (fighters.get(i).getSide() == weakestFighter.getSide()) {
			   if (0 == weakestFighter.getCurrent().get("current health")) {
			   System.out.println("WEakest fighter spottedspottedspottedspotted!!" + weakestFighter.getSide());
			   fighters.remove(i);
		   }}
	   }
		
	}

public static int getDmg(int[]atk, int[]def) 
{int damage = 0;
	  for(int i =0; i < atk.length; i++) {
		  if(atk[i] > def[i]) {
			  damage = damage + (atk[i] - def[i]);
			//  System.out.println("jeden atk[i] " + i + " : " + atk[i]);
			//  System.out.println("jeden def[i] " + i + " : " + def[i]);
		  } else {
			  damage = damage + 1;
			//  System.out.println("dwa atk[i] " + i + " : " + atk[i]);
			//  System.out.println("dwa def[i] " + i + " : " + def[i]);
		  }
	  }
	  return damage;
}
/*
 * for(int i =0; i < fighters.size(); i++) {
	if(fastestFighter == fighters.get(i) ) {
	System.out.println(fighters.get(i).getSide() + " fast");}
	if(weakestFighter == fighters.get(i) ) {
	System.out.println(fighters.get(i).getSide() + " weak");}
}System.exit(0);
 */

	/**
	 * if 2 sides still remaining within fighters - fight is still ongoing.
	 * @return true if fight is ongoing, false if fight over.
	 */
	public static boolean getFightStatus(ArrayList<Fighter> fighters) 
	{
		int side = fighters.get(0).getSide();
	for(int i =0; i < fighters.size(); i++) {
		if (fighters.get(i).getSide() != side) {
			System.out.println(fighters.get(i).getSide() + " side checked : side : " + side);
			return true;
		}
	}
		return false;
	}




}

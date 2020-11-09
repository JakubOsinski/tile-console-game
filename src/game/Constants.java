package game;

import mapelements.Letter;

public class Constants 
{                                      //EMPTY_ELEMENT, MAP_EXIT_ELEMENT
 public static final Letter MAP_LETTER_EMPTY = Letter.X;
 public static final Letter MAP_LETTER_EXIT = Letter.E;
 public static final Letter MAP_LETTER_CHEST = Letter.C;
 public static final Letter MAP_LETTER_MONSTER = Letter.M;
 public static final Letter MAP_LETTER_OBSTACLE = Letter.O;
 public static final Letter MAP_LETTER_PLAYER = Letter.P;
 
//used in setUpPlayer()  to set up new level 1 player.
 public static final String[] ATTS_STRING = {"Endurance", "Strength", "Dexterity", "Intelligence", "Luck"};
 public static final int[] LVL1_P_ATTS= {2,2,6,3,6}; //lvl 1 player attributes
 public static final String[] STATS_STRING = {"Max Health", "Max Mana", "Initiative", "Spell Power", "Avoid"};
 public static final int[] LVL1_P_STATS= {10,4,6,4,4}; //lvl 1 player stats
 public static final String[] CURRENT_STRING = {"current health"};
 public static final int[] LVL1_P_CURRENT= {10}; //lvl 1 player current
 public static final int[] LVL1_P_INFO= {1,0,50}; // level, current exp, gold 
 //^^ no string for info as its values are stored in aList<int> ^^\\
}

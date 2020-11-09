package game;
import java.util.Date;

import javax.swing.JOptionPane;

import mapelements.Element;
import mapelements.Letter;
/**
 * This is my rough code for 2d RPG game. There is no user interface yet. Currently game is based on calling methods in Map and Player class.
 * @author Jakub
 */
public class Game extends Thread
{
	public int moves;
	public int movesLimit;
	private int [] gameDetails;
	private Map map;
	

	/**
	 * gameDetails is param passed from the main class and contains zone index of initial map.
	 */
	public Game(int[] gameDetails) //pass parameters here to load game too! gameDetails[0] = map index, [0.1] = player pos, [0,2] = exits
	{
		this.gameDetails = gameDetails;
	//	generateMap(gameDetails[0]);
	//	map = new Map(gameDetails[0], 2);
int mapLevel = 0;
int state = 1; // random map = state = 0
//map = new Map(1,mapLevel);
map = new Map(mapLevel, state);
		map.checkMap();
		//int []playerPosition = {2,2}; 
		//Player player = new Player(playerPosition, Letter.P, null);	
		Player player = new Player();
		   map.positionPlayer1(player); // create player
		   ////1 up, 2 down, 3 right , 4 left
		   map.checkMap();
		//   int[] elementDetails = {mapLevel, 0, -1, 1,2};
	//	   Field field = new Field(1,2,Letter.E, Element.EXIT, elementDetails);
		//   map.addField(field);
		   player.equipBaseEq();
		   gameStart(map, player);
	//8888888
		   
      //     player.checkPlayerInventory();

	
     //   Monsters.checkSpace(1);
         
//         Date date = new Date();
//         //This method returns the time in millis
//         long timeMilli = date.getTime();
//         System.out.println("Time in milliseconds using Date class: " + timeMilli);
         
	}
	public static void gameStart(Map map, Player player) 
	{
		int moves = 54;
		while (moves != 0) {
		 String[] options = new String[] {"Up", "Down", "Right", "Left", "Check Inventory", "equip best eq", "check eq", "pDEF"};
		    int response = JOptionPane.showOptionDialog(null, "Message", "Title",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
		        null, options, options[0]);
		    if(response+1 == 5) {
		    	player.checkPlayerInventory();
		    } else {
		    map.movePlayer1(player, (response+1));
		    map.checkMap();
		    moves--;
		}
		    if(response+1 == 6) {
		    	player.equipBestEq(); // works on weapons, not on armor or helmet. jewelry = null pointer exception in checkPlayerEq
		    }
		    if(response+1 == 7) {
		    	PlayerMethods.checkPlayerEq(player);
		    }
		    if(response+1 == 8) {
		    	player.getTotalPDef();
		    }
		 System.out.println();
		}

	}
		
	public static void main(String [] args)
	{
		int []gameDetails = {1,1,1,1}; //first zone index, 
		Game g = new Game(gameDetails);
	}
}

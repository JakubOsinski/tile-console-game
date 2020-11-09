package game;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import fight.Fight;
import mapelements.Chests;
import mapelements.Element;
import mapelements.Letter;
/**
 * The game takes place on map. entering specific coordinates in a map triggers action like battle, chest pick up or enter/exit to new map(zone)
 * Map is represented as 2d array of Strings and its elements are represented by letters. C = chest, P = Player, X = empty space, E = previous/next map
 * @author Jakub
 */
public class Map
{
	/**
	 * fieldMap[][] is the player's current map
	 */
	private Field fieldMap[][];

	private int mapIndex;
	private int []mapSize;
	private int state;
	
	private ArrayList<int[]> mapExits;
	private ArrayList<int[]> mapChests;
	private ArrayList<int[]> mapMonsters;
	//gameplay
	private ArrayList<int[]> prevPlayerPos;
    private ArrayList<int[]> playerMoves;
    public boolean bypassCheat = false;
	//private ArrayList<ArrayList<int[]>> mapElements;
	
	private ArrayList<int[]> mapElements;
	private Player player;
	
	private ArrayList<Field> moveHistory; //move history stored as previous mapElements with its details so it always traces back to every position, every interaction at its mapIndex
	private ArrayList<Field> interactionElementHistory; // can also create somigge for elke move history too
	//private Fight fight;
	/**
	 * Each map zone and its elements is set up in the Maps class.
	 * pass the zone int to the Map constructor in order to create new map zone by pulling details from the Maps class.
	 */
	public Map(int mapIndex, int state) //state 1 = start game, 2 = create custom, 3 = load
	{
		interactionElementHistory = new ArrayList<Field>(); //tbd
		moveHistory = new ArrayList<Field>(); 
		setThePlay(mapIndex, state);
//		this.state = state;
//		   this.mapIndex = mapIndex;	 
//		   this.mapSize = Maps.getMapSize(state, mapIndex);
//			fieldMap = new Field[mapSize[0]][mapSize[1]];
//		   
//		   this.mapElements = Maps.getMapElements(mapIndex, state);  
//		updateMap();
	}
	public Map(int mapIndex, int state, Player player) //state 1 = start game, 2 = create custom, 3 = load
	{
		this.player = player;
		setThePlay(mapIndex, state);
	}
	public void setThePlay(int mapIndex, int state) {
		this.state = state;
		   this.mapIndex = mapIndex;	 
		   this.mapSize = Maps.getMapSize(state, mapIndex);
			fieldMap = new Field[mapSize[0]][mapSize[1]];
		   
		   this.mapElements = Maps.getMapElements(mapIndex, state);
		//    fight = new Fight(this.player, this.mapElements);
		updateMap();
	}

	public void testRandomizedMapElements(int counter, ArrayList<int[]> occupiedSpaces) {
	System.out.println(counter + "counter");
		
		System.out.println("occupied space size : " + occupiedSpaces.size());
		for(int i=0; i < occupiedSpaces.size(); i++) {
		System.out.println("\n Y: " +	occupiedSpaces.get(i)[0]  + "\n X: " +  	occupiedSpaces.get(i)[1]);
		}
	}
	
//start Map getters and setters
	public Field[][] getFieldMap() {
		return fieldMap;
	}

	public void setFieldMap(Field[][] fieldMap) {
		this.fieldMap = fieldMap;
	}

	public int getMapIndex() {
		return mapIndex;
	}

	public void setMapIndex(int mapIndex) {
		this.mapIndex = mapIndex;
	}
	public int[] getMapSize() {
		return mapSize;
	}

	public void setMapSize(int []mapSize) {
		this.mapSize = mapSize;
	}
	public ArrayList<int[]> getMapExits() {
		return mapExits;
	}
	public void setMapExits(ArrayList<int[]> mapExits) {
		this.mapExits = mapExits;
	}
	//end Map getters and setters

	public void checkMap() {
		System.out.println("checkMap called\n");
		for(int i = 0; i < mapSize[0];i++) 
		{
			for(int j = 0; j < mapSize[1];j++) {
				System.out.print(fieldMap[i][j].getLetter() + " "); // check map
			}
			System.out.println();
		}
	}
	public void updateMap() //updateMap();
	{
		System.out.println("UPDATE MAP CALLED UPDATE MAP CALLED UPDATE MAP CALLED UPDATE MAP CALLED UPDATE MAP CALLED UPDATE MAP CALLED ");
		//if fieldMap == null, create new one. if not null, (delete previous?) create new one by calling updateMap()
		for(int i = 0; i < mapSize[0];i++)
			{
				for(int j = 0; j < mapSize[1];j++)
				{
					createEmptyElement(i,j);//place X on a map	
				}
			} 
		for(int i = 0; i < mapElements.size();i++) 
		{
			int fieldY = mapElements.get(i)[3]; 	int fieldX = mapElements.get(i)[4];
		
			int elementType = mapElements.get(i)[1];
//als ik wil elements to reset in any maplevel once I leave it, I can delete picked element types 1 and 2 from moveHistory.
			if(!elementVisited(this.mapIndex, fieldY,fieldX, elementType)) {
			fieldMap[fieldY][fieldX] = new Field(fieldY,fieldX, 
			Maps.getLetterByI(elementType), 
			Maps.getElementByI(elementType), mapElements.get(i) );	
			}
		}
		//test
		//checkRNGElementsIndex();
		for(int i =0; i < 5; i++) {
		//	System.out.println(fieldMap[1][0].getElementDetails()[i]);
		}
	}
	/**
	 *Was interaction element like monster or chest visited before?
	 **/
	private boolean elementVisited(int mapLevel, int y, int x, int elementType) 
	{
		if(elementType == 1 || elementType == 2) {//only monster + chest are important to us
		//	System.out.println("element type is 1 or 2: " + elementType);
	   for(int i =0; i < moveHistory.size(); i++) 
	   { //make sure you are still in the same zone
		   if(moveHistory.get(i).getElementDetails()[0] == mapLevel) { //
			   if(moveHistory.get(i).getElementDetails()[3] == y && moveHistory.get(i).getElementDetails()[4] == x)  // position
			   {
			//   System.out.println("Element visited ");
				   return true;
			   }
		   }

	   }}
	//	System.out.println("ELEMENT NOT YET VISITED");
	   return false;
	}
 	/**
	 * place empty (X) element on a field Map
	 */
	private void createEmptyElement(int y, int x) 
	{
		int []emptyElement = {this.mapIndex, -1, -2, y,x};
		fieldMap[y][x] = new Field(y,x, Constants.MAP_LETTER_EMPTY, Element.EMPTY, emptyElement);		
	}
	/**
	 * replace old field in fieldMap with param newField
	 * @param newField 
	 *///not in use + not working?
	public void addField(Field newField) {
		int y =newField.getY(); int x =newField.getX(); int elementType = newField.getElementDetails()[1];
		fieldMap[y][x] = new Field(y,x, 
				Maps.getLetterByI(elementType), 
				Maps.getElementByI(elementType), newField.getElementDetails());
	}
	
	//test test test test test test test test test test test test test test test 
	public void checkRNGElementsIndex() {
		for(int i = 0; i < mapElements.size();i++) 
		{    
			System.out.println("mapElements index: " + mapElements.get(i)[2]);
			//if rng element doesn't have -1 index and it isn't empty field...
			if(mapElements.get(i)[2] != -1) {
				if(mapElements.get(i)[1] != 3) {
			System.out.println("error, program sluithering. checkRNGElementsIndex");
			System.exit(0);
			}}
		}
	}
	/**
	 * this method should only be called in main once to position the player on the map. =???
	 *position player on the map and check if he is interacting with any object after successful movement.
	 */
	public void positionPlayer1(Player player) 
	{ // state 0 = rng map mode, state 1 = normal map mode.	
		int []playerPos = new int[2];
		if(state == 0) {
			playerPos =	PlayerMethods.getPlayerPosRNG(1, this.mapIndex, this.mapElements);// 1=first move 
		}else if(state == 1) {
			playerPos = PlayerMethods.getInitialPlayerPos(1, this.mapIndex, this.mapElements, this.moveHistory);// tip : interactionElementHistory can be used as as blueprint for moveElementHistory, storing every move
		}
	    int[] pElement = {mapIndex, 4, -4, playerPos[0], playerPos[1]};
			mapElements.add(pElement); 
			player.setPos(playerPos);
            updateMap();
	}

	public ArrayList<int[]> getMapElements() 
	{
		return mapElements;
	}
	public void setMapElements(ArrayList<int[]> mapElements) {
		this.mapElements = mapElements;
	}

	public void movePlayer1(Player player, int move)
	{// obstacles can't be randomly placed because player can't access E in this example
		//O E 
		//P O 
        int []playerElement = Maps.getPlayerElement(this.mapElements); 
        int []playerPos = {playerElement[3], playerElement[4]};

        movePlayer(move, playerPos);
        // if obstacles make it so you can't move, check for it() and find solution for it() TBC
        Field interactionField = fieldMap[playerPos[0]][playerPos[1]]; 
        HashMap<String, String> capitalCities = new HashMap<String, String>();
        modifyMoveHistory(interactionField);
   
       System.out.println("moveHistory size :" + moveHistory.size());//tbc useless moves if go up and can't go up
        byPassObstaclesCheat(playerPos);
	
//if(fieldMap[playerPos[0]][playerPos[1]].getLetter() != Letter.P) { wrong as this field is always player here
		if(interactionField.getElementDetails()[1] != -1 && interactionField.getElementDetails()[1] != 3) {
interactionElementHistory.add(interactionField); //tbd not used
		assessInteraction(player,interactionField); //IF NOT X OR O ^
		}//test
	//	testMoveHistory();
	}

private void modifyMoveHistory(Field interactionField) {
	if(moveHistory.size() == 0) {
		  moveHistory.add(interactionField);
		  return;
	}
	int lastMoveMap = moveHistory.get(0).getElementDetails()[0];
int lastY = moveHistory.get(moveHistory.size()-1).getElementDetails()[3]; int lastX = moveHistory.get(moveHistory.size()-1).getElementDetails()[4];
if(interactionField.getElementDetails()[3] == lastY && interactionField.getElementDetails()[4] == lastX) {
	    	 System.out.println("same shit");
	      } else {
	    	  System.out.println("IF added");
	    	  moveHistory.add(interactionField);
	      }
	}
/**
 *test move history 
 **/
	private void testMoveHistory() {
		System.out.println("important test XXXmoveHistory");
		for(int i =0; i < moveHistory.size();i++) {
			String[] text = {"mapIndex","element type","intraction index", "y","x"};
			for(int j =0;j<text.length;j++) {
			System.out.println(moveHistory.get(i).getElementDetails()[j] + " " + text[j]+" mapIndex of move N" + (i+1));
			}
			System.out.println();
		}
	}
	public void movePlayer2(int[] newPlayerPos) {
		editPlayerPosition(newPlayerPos);
		updateMap();
		return;
	}
	//TBD
	public boolean checkInteraction(Player player,  Field interactionField) {
		int elementType = interactionField.getElementDetails()[1];
		System.out.println("stepping on type: " + elementType);
		
		String interaction = "" +interactionField.getElementDetails()[0] +interactionField.getElementDetails()[1] +interactionField.getElementDetails()[2];
		System.out.println("Interaction string = " + interaction);
		assessInteraction(player, interactionField); //check if player is on interaction field,if so do the action
			return false;
	}
	/**
	 * //check if player is on interaction field,if so do the action
	 * @param player - doing the action
	 * @param interactionField - interacting with this field
	 */
	public void assessInteraction(Player player,  Field interactionField) 
	{
		String interaction = "" +interactionField.getElementDetails()[0] +interactionField.getElementDetails()[1] +interactionField.getElementDetails()[2];
		System.out.println("Interaction string = " + interaction);
		
		int interactionIndex = interactionField.getElementDetails()[2]; 
		int interactionType = interactionField.getElementDetails()[1]; 
		System.out.println("stepping on type: " + interactionType);
		mapInteraction(player, interactionField, interactionType, interactionIndex);
//		if(interactionIndex == -1) { //assess map interaction
//			randomMapInteraction(player, interactionField, interactionType);
//		} else {
//			mapInteraction(player, interactionField, interactionType, interactionIndex);
//		}
	}

//	1 pick up chest based on mapLevel, 2 add to player inventory. 3 delete chest.
//case 2: // 1 fight() monster based on maplevel, 2 add loot, add exp, update player. 3 delete monster.
	public void mapInteraction(Player player,  Field interactionField, int interactionType, int interactionIndex)
	{System.out.println("interactionIndex in mapinteraction : : : " + interactionIndex);
		switch(interactionType) { //setThePlay(this.mapIndex+1, state); positionPlayer1(player);
		case 0: //if(interactionIndex == 1) {setThePlay(this.mapIndex+1, state); } else {setThePlay(this.mapIndex-1, state);} positionPlayer1(player); 
			int mls = 1; if(interactionIndex == 0) {mls=-1;}  	//mls = map level state
			setThePlay(this.mapIndex+mls, state); positionPlayer1(player); 
		break;
		case 1: player.addItems(Chests.openChest(this.mapIndex, interactionField.getElementDetails()[2])); 
		System.out.println("adding items");
			break;
		case 2:   Fight.fight(this.mapIndex, player, interactionField, this.mapElements);//fight.fight(player, interactionField);      
			break;
		default:
		    break;
		}
	}

    /**
     * change params pPos y,x +1 depending on the move param. can't go out of the map
     */
	public void movePlayer(int move, int[]pPos)
	{
		switch(move) 
		{
		case 1: if(pPos[0] > 0) { pPos[0]--;} // up
		break;
		case 2: if(pPos[0] < (mapSize[0] -1))  {pPos[0]++;} // down
		break;
		case 3: if(pPos[1] < (mapSize[1] -1)) { pPos[1]++;} // right
		break;
		case 4: if(pPos[1] > 0) { pPos[1]--;} // left
		break;
		}
	}
	/**
	 * find player based on index element index(4), delete him and 
	 * @param newPlayerPos - add new player to mapElements with newPlayerPos
	 * @return true if player position has changed successfully
	 */
	public boolean editPlayerPosition(int[] newPlayerPos)
	{
		//find p
		for(int i =0; i < this.mapElements.size(); i++) {
			if(mapElements.get(i)[1] == 4) {
				int[] newPElement = {this.mapIndex, mapElements.get(i)[1], mapElements.get(i)[2], newPlayerPos[0], newPlayerPos[1]};
				mapElements.remove(i);
				mapElements.add(newPElement);
				return true;
			}
		}
		return false;
	}
	private void byPassObstaclesCheat(int[] playerPos) {
		  // bypassCheat = true;
				if(bypassCheat) 
				{
					movePlayer2(playerPos); // bypass obstacles on the map
				} else if(fieldMap[playerPos[0]][playerPos[1]].getLetter() != Letter.O && fieldMap[playerPos[0]][playerPos[1]] != null)  {
					movePlayer2(playerPos); // go everywhere but into obstacles on the map
				}
		}

}
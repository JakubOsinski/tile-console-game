package fight;

import java.util.ArrayList;
import java.util.function.BiFunction;

import game.Fighter;
import game.*;

class Arithmetic{  
public static Fighter check(ArrayList<Fighter> fighters, int criteria)
{  
	switch(criteria) {
	case 1: if(fighters.get(0).getAtts().get("Dexterity") > fighters.get(1).getAtts().get("Dexterity") ) {
return fighters.get(0);} else {	return fighters.get(1);}
	case 2: if(fighters.get(0).getStats().get("Initiative") > fighters.get(1).getStats().get("Initiative") ) {
return fighters.get(0);} else {	return fighters.get(1);}
	}
return null;  
}  
}  
public class MethodReference3 {  
public static void main(String[] args) {  
BiFunction<ArrayList<Fighter>, Integer, Fighter>adder = Arithmetic::check;  
ArrayList<Fighter> fighters = new ArrayList<Fighter>();
Fighter p = new Player(); Fighter m = new Goblin(); fighters.add(p); fighters.add(m);
Fighter bestFighter = adder.apply(fighters, 1); 
System.out.println(bestFighter.getSide());  
 bestFighter = adder.apply(fighters, 2);  
System.out.println(bestFighter.getSide());  
}  
}  
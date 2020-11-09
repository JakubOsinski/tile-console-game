package fight;

import java.util.ArrayList;

public class Devil extends Monster
{
public Devil() {
	//Monster methods setting up start
	setmId(4);
	setmName("Devil");
	
	int[] monsterAttack = Monster.getMonsterAttack(getmName());
	int[] monsterDefence = Monster.getMonsterDefence(getmName());
	setAtk(monsterAttack);
	setDef(monsterDefence);
	//Monster methods setting up end
	//Fighter methods setting up start
//	setStats(getMonsterStats(getmName()));       
//	setCurrent(getMonsterCurrent(getmName()));
//	setInfo(getMonsterInfo(getmName()));
	setFighter(getMonsterAtts(getmName()), getMonsterStats(getmName()), getMonsterCurrent(getmName()), getMonsterInfo(getmName()));
	//Fighter methods setting up end
	setSide(1);
	setTurn(true);
}


	
}

package fight;

public class Goblin extends Monster
{
	public Goblin() {
		//Monster methods setting up start
		setmId(2);
		setmName("Goblin");
		
		int[] monsterAttack = Monster.getMonsterAttack(getmName());
		int[] monsterDefence = Monster.getMonsterDefence(getmName());
		setAtk(monsterAttack);
		setDef(monsterDefence);
		//Monster methods setting up end
		//Fighter methods setting up start
//		setStats(getMonsterStats(getmName()));       
//		setCurrent(getMonsterCurrent(getmName()));
//		setInfo(getMonsterInfo(getmName()));
		setFighter(getMonsterAtts(getmName()), getMonsterStats(getmName()), getMonsterCurrent(getmName()), getMonsterInfo(getmName()));
		//Fighter methods setting up end
		setSide(1);
		setTurn(true);
	}
}

package fight;

public class Minotaur extends Monster
{
	public Minotaur() {
		//Monster methods setting up start
		setmId(3);
		setmName("Minotaur");
		
		int[] monsterAttack = Monster.getMonsterAttack(getmName());
		int[] monsterDefence = Monster.getMonsterDefence(getmName());
		setAtk(monsterAttack);
		setDef(monsterDefence);;
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

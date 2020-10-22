package enemies;

import mapStates.Map;

public class SimpleEnemyFactory {
	public Enemy createEnemy(String type, int x, int y, Map map)
	{
		Enemy enemy = null;
		if(type.equals("esbelto"))
			enemy = new EnemigoEsbelto(x, y, map);
		return enemy;
	}
}

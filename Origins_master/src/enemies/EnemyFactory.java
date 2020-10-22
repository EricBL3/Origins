package enemies;

import mapStates.Map;

public class EnemyFactory {
	private SimpleEnemyFactory enemyFactory;
	
	public EnemyFactory()
	{
		enemyFactory = new SimpleEnemyFactory();
	}
	
	public Enemy createEnemy(String tipo, int x, int y, Map map)
	{
		Enemy enemigo = enemyFactory.createEnemy(tipo, x, y, map);
		
		return enemigo;
	}
}

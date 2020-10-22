package enemyStates;

import java.awt.Graphics2D;
import java.util.ArrayList;

import enemies.Enemy;
import logic.GameObject;
import logic.Player;
import mapStates.Map;

public class EnemyDead implements EnemyState {
	private Enemy enemy;
	private int direction;
	public EnemyDead(Enemy enemy) {
		this.enemy = enemy;
		
		switch(enemy.getDir())
		{
			case 1: case 3:
				direction = 1;
				break;
			case 2: case 4:
				direction = -1;
				break;
		}
		enemy.getSp().reset();
		setSprites();
		enemy.getSp().setAnimSpd(8);
	}
	
	@Override
	public void setSprites()
	{
		enemy.getBuilder().empty();
		enemy.getBuilder().addImage(0, 3);
		enemy.getBuilder().addImage(1, 3);
		enemy.getBuilder().addImage(2, 3);
		enemy.getBuilder().addImage(3, 3);
		enemy.getBuilder().addImage(4, 3);
	}

	@Override
	public void searchPlayer(Player p, Map map, ArrayList<GameObject> objects) {

	}

	@Override
	public void attack(Player p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Player p, Map map, ArrayList<GameObject> objects) {
		// TODO Auto-generated method stub
		
		if(direction == -1)
			enemy.getSp().setX(enemy.getX()+enemy.getSize());
		else
			enemy.getSp().setX(enemy.getX());
		enemy.getSp().setY(enemy.getY());
		enemy.getSp().update();
		if(enemy.getSp().hasReachedEnd())
			enemy.destroy();
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		enemy.getSp().render(g);
	}
	
	@Override
	public boolean collides(ArrayList<GameObject> objects)
	{
		return false;
	}
}

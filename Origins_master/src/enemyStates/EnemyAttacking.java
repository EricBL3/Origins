package enemyStates;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import enemies.Enemy;
import gameEngine.AudioPlayer;
import logic.GameObject;
import logic.Player;
import mapStates.Map;

public class EnemyAttacking implements EnemyState {
	private Enemy enemy;
	private Rectangle weapon;
	private int weaponSize, direction;
	public EnemyAttacking(Enemy enemy) {
		this.enemy = enemy;
		weaponSize = 32;
		weapon = null;
		direction = 1;
		enemy.getSp().reset();
		setSprites();
		enemy.getSp().setAnimSpd(32);
		
	}
	
	@Override
	public void setSprites()
	{
		enemy.getBuilder().empty();
		switch(enemy.getDir())
		{
			case 1: case 2:
				
				enemy.getBuilder().addImage(0, 2);
				enemy.getBuilder().addImage(1, 2);
				enemy.getBuilder().addImage(2, 2);
				enemy.getBuilder().addImage(3, 2);
				enemy.getBuilder().addImage(4, 2);
				break;
			case 3:
				enemy.getBuilder().addImage(0, 0);
				enemy.getBuilder().addImage(1, 0);
				enemy.getBuilder().addImage(2, 0);
				enemy.getBuilder().addImage(3, 0);
				enemy.getBuilder().addImage(4, 0);
				break;
			case 4:
				enemy.getBuilder().addImage(0, 1);
				enemy.getBuilder().addImage(1, 1);
				enemy.getBuilder().addImage(2, 1);
				enemy.getBuilder().addImage(3, 1);
				enemy.getBuilder().addImage(4, 1);
				break;
		}
	}
	
	@Override
	public void searchPlayer(Player p, Map map, ArrayList<GameObject> objects) {
		// TODO Auto-generated method stub
	}
	
	public boolean nearPlayer(Player p)
	{
		if(new Rectangle(enemy.getX()-enemy.getOffset(), enemy.getY(), enemy.getSize(), enemy.getSize()).intersects(p.getHitBox()) ||
				new Rectangle(enemy.getX()+enemy.getOffset(), enemy.getY(), enemy.getSize(), enemy.getSize()).intersects(p.getHitBox()) ||
				new Rectangle(enemy.getX(), enemy.getY()-enemy.getOffset(), enemy.getSize(), enemy.getSize()).intersects(p.getHitBox()) ||
				new Rectangle(enemy.getX(), enemy.getY()+enemy.getOffset(), enemy.getSize(), enemy.getSize()).intersects(p.getHitBox()))
				return true;
		else
			return false;
	}

	@Override
	public void attack(Player p) {
		switch(enemy.getDir())
		{
			case 1:
				weapon = new Rectangle(enemy.getX()+enemy.getSize(), enemy.getY(), 12, weaponSize);	
				direction = 1;
				break;
			case 2:
				weapon = new Rectangle(enemy.getX()-12, enemy.getY(), 12, weaponSize);
				direction = -1;
				break;
			case 3:
				weapon = new Rectangle(enemy.getX(), enemy.getY()-12, weaponSize, 12);
				direction = 1;
				break;
			case 4:
				weapon = new Rectangle(enemy.getX(), enemy.getY()+enemy.getSize(), weaponSize, 12);
				direction = -1;
				break;
		}
		
		if(p.getHitBox().intersects(weapon) && !p.getDead())
		{
				p.loseLife();
		}
	}

	@Override
	public void update(Player p, Map map, ArrayList<GameObject> objects) {

		// TODO Auto-generated method stub
		if(enemy.getLives() <= 0)
		{
			AudioPlayer.get().playEffectSound("audios/death_enemy.wav");
			enemy.setEnemyState(new EnemyDead(enemy));
		}
		attack(p);
		if(!nearPlayer(p))
		{
			
			enemy.setEnemyState(new EnemySearching(enemy, map));
		}
		
		enemy.getSp().setScaleX(1f*direction);
		if(direction == -1)
			enemy.getSp().setX(enemy.getX()+enemy.getSize());
		else
			enemy.getSp().setX(enemy.getX());
		enemy.getSp().setY(enemy.getY());
		enemy.getSp().update();
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		enemy.getSp().render(g);

	}

	@Override
	public boolean collides(ArrayList<GameObject> objects) {
		// TODO Auto-generated method stub
		return false;
	}

}

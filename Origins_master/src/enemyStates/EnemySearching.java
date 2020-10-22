package enemyStates;


import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import enemies.Enemy;
import gameEngine.AudioPlayer;
import logic.GameObject;
import logic.Player;
import mapStates.Map;


public class EnemySearching implements EnemyState {
	private Enemy enemy;
	private int colDir, direction;
	public EnemySearching(Enemy enemy, Map map)
	{
		colDir = 0;
		direction = 1;
		this.enemy = enemy;
		enemy.getSp().reset();
		setSprites();
		enemy.getSp().setAnimSpd(8);
	}
	
	@Override
	public void setSprites() {
		// TODO Auto-generated method stub
		enemy.getBuilder().empty();
		enemy.getBuilder().addImage(0, 4);
		enemy.getBuilder().addImage(1, 4);
		enemy.getBuilder().addImage(2, 4);
		enemy.getBuilder().addImage(3, 4);
	}
	
	@Override
	public void searchPlayer(Player p, Map map, ArrayList<GameObject> objects) {
		//mover a la derecha
		boolean aux = collides(objects);
		if(p.getX() > enemy.getX() && canMove(map, 1, enemy) == 1)
		{
			if(colDir != 1)
			{
				enemy.setX(enemy.getX()+enemy.getSpeed());
				direction = 1;
			}

			enemy.getHitBox().x =enemy.getX();
		}
		//mover a la izquierda
		if(p.getX() < enemy.getX() && canMove(map, 2, enemy) == 2 )
		{
			if(colDir != 3)

			{
				enemy.setX(enemy.getX()-enemy.getSpeed());
				direction = -1;
			}

			enemy.getHitBox().x =enemy.getX();
		}
		//mover abajo
		if(p.getY() > enemy.getY() && canMove(map, 3, enemy) == 3)
		{
			if(colDir != 4)
			{
				enemy.setY(enemy.getY()+enemy.getSpeed());
				direction = 1;
			}

			enemy.getHitBox().y =enemy.getY();
				
		}
		//mover arriba
		if( p.getY() < enemy.getY() && canMove(map, 4, enemy) == 4)
		{
			if(colDir != 2)
			{
				enemy.setY(enemy.getY()-enemy.getSpeed());
				direction = -1;
			}

			enemy.getHitBox().y =enemy.getY();
		}

		colDir = 0;
	}
	
	public boolean collides(ArrayList<GameObject> objects)
	{
		for(GameObject obj : objects)
		{
			//update enemy x and y if it's colliding with another enemy
			if(obj instanceof Enemy && obj != enemy)
			{
				Enemy o = ((Enemy)obj);
				//derecha
				if(new Rectangle(enemy.getX()+2, enemy.getY(), enemy.getSize(), enemy.getSize()).intersects(o.getHitBox()))
					{
						colDir = 1;
						return true;
					}
					//arriba
				if(new Rectangle(enemy.getX(), enemy.getY()-2, enemy.getSize(), enemy.getSize()).intersects(o.getHitBox()))
					{
						colDir = 2;
						return true;
					}
				//izquierda
				if(new Rectangle(enemy.getX()-2, enemy.getY(), enemy.getSize(), enemy.getSize()).intersects(o.getHitBox()))
					{
						colDir = 3;
						return true;
					}
				//abajo
				if(new Rectangle(enemy.getX(), enemy.getY()+2, enemy.getSize(), enemy.getSize()).intersects(o.getHitBox()))
					{
						colDir = 4;
						return true;
					}				
			}
		}
		return false;
	}
	
	//esta funcion regresa un entero dependiendo de la direccion a la que se puede mover el enemigo
	public int canMove(Map map, int dir, Enemy enemy)
	{
		//derecha
		if(dir == 1 && !map.getTile(enemy.getY()/enemy.getSize(), (enemy.getX()+enemy.getSize())/enemy.getSize()).isSolid() && !map.getTile((enemy.getY()+enemy.getSize()-1)/enemy.getSize(), (enemy.getX()+enemy.getSize())/enemy.getSize()).isSolid())
			return 1;
		//izquierda
		if(dir == 2 &&!map.getTile(enemy.getY()/enemy.getSize(), (enemy.getX()-enemy.getSpeed())/enemy.getSize()).isSolid() && !map.getTile((enemy.getY()+enemy.getSize()-1)/enemy.getSize(), (enemy.getX()-enemy.getSpeed())/enemy.getSize()).isSolid())
			return 2;
		//abajo
		if(dir == 3 &&!map.getTile((enemy.getY()+enemy.getSize())/enemy.getSize(), enemy.getX()/enemy.getSize()).isSolid() && !map.getTile((enemy.getY()+enemy.getSize())/enemy.getSize(), (enemy.getX()+enemy.getSize()-1)/enemy.getSize()).isSolid())
			return 3;
		//arriba
		if(dir == 4 &&!map.getTile((enemy.getY()-enemy.getSpeed())/enemy.getSize(), enemy.getX()/enemy.getSize()).isSolid()&& !map.getTile((enemy.getY()-enemy.getSpeed())/enemy.getSize(), (enemy.getX()+enemy.getSize()-1)/enemy.getSize()).isSolid())
			return 4;
		
		return 0;
	}
	
	public boolean nearPlayer(Player p)
	{
		//izquierda
		if(new Rectangle(enemy.getX()-enemy.getOffset(), enemy.getY(), enemy.getSize(), enemy.getSize()).intersects(p.getHitBox()))
		{
			enemy.setDir(2);
			direction = -1;
			return true;
		}
		//derecha
		else if(new Rectangle(enemy.getX()+enemy.getOffset(), enemy.getY(), enemy.getSize(), enemy.getSize()).intersects(p.getHitBox()))
		{
			enemy.setDir(1);
			direction = 1;
			return true;
		}
		//arriba
		else if(new Rectangle(enemy.getX(), enemy.getY()-enemy.getOffset(), enemy.getSize(), enemy.getSize()).intersects(p.getHitBox()))
		{
			enemy.setDir(3);
			direction = 1;
			return true;
		}
		//abajo
		else if(new Rectangle(enemy.getX(), enemy.getY()+enemy.getOffset(), enemy.getSize(), enemy.getSize()).intersects(p.getHitBox()))
		{
			enemy.setDir(4);
			direction = -1;
			return true;
		}
		else
			return false;
	}

	@Override
	public void attack(Player p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Player p, Map map, ArrayList<GameObject> objects) {
		// TODO Auto-generated method stub
		if(enemy.getLives() <= 0)
		{
			AudioPlayer.get().playEffectSound("audios/death_enemy.wav");
			enemy.setEnemyState(new EnemyDead(enemy));
		}
		
		if(nearPlayer(p))
			enemy.setEnemyState(new EnemyAttacking(enemy));
		else
			searchPlayer(p, map, objects);
		
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

	

}

package enemies;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import enemyStates.EnemySearching;
import logic.GameObject;
import logic.Player;
import mapStates.Map;
import sprites.AnimationSprite;
import sprites.SpriteBuilder;

public class EnemigoEsbelto extends Enemy {
	
	public EnemigoEsbelto(int x, int y, Map map)
	{
		super(x, y, map);
		lives = 3;
		speed = 1;
		damage = 1;
		size = 32;
		offset = 12;
		hitbox = new Rectangle(x, y, size,size);
		builder = new SpriteBuilder("enemy.png",32,32,0,0);
			
		
		enemySprite = new AnimationSprite(x, y, builder.build(),32,32);
		enemySprite.setAnimSpd(8);
		enemyState = new EnemySearching(this, map);
	}

	@Override
	public void attack(Player p) {
		// TODO Auto-generated method stub
		enemyState.attack(p);
	}

	@Override
	public void update(Player p, Map map, ArrayList<GameObject> objects) {
		// TODO Auto-generated method stub
		enemyState.update(p, map, objects);
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		enemyState.render(g);
	}

	@Override
	public boolean collides(ArrayList<GameObject> objects) {
		return enemyState.collides(objects);
	}

}

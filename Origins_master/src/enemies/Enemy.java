package enemies;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import enemyStates.EnemyState;
import logic.GameObject;
import logic.Player;
import mapStates.Map;
import sprites.AnimationSprite;
import sprites.SpriteBuilder;

public abstract class Enemy extends GameObject{
	protected int lives, speed, damage, size, offset, dir;
	protected EnemyState enemyState;
	protected Rectangle hitbox;
	SpriteBuilder builder;
	AnimationSprite enemySprite;
	
	Enemy(int x, int y, Map map)
	{
		super(x, y);
		dir = 1;
		
	}
	
	public abstract void attack(Player p);
	public abstract void update(Player p, Map map, ArrayList<GameObject> objects);
	public abstract void render(Graphics2D g);
	
	
	public AnimationSprite getSp() {
		return enemySprite;
	}
	
	public SpriteBuilder getBuilder() {
		return builder;
	}
	public void setSp(AnimationSprite s) {
		enemySprite = s;
	}
	
	public EnemyState getEnemyState()
	{
		return enemyState;
	}
	
	public void setEnemyState(EnemyState state)
	{
		enemyState = state;
	}
	
	public void setHitBox(int x, int y)
	{
		hitbox.x = x;
		hitbox.y = y;
	}
	
	public Rectangle getHitBox()
	{
		return hitbox;
	}
	
	public void setLives(int lives)
	{
		this.lives = lives;
	}
	public int getLives()
	{
		return lives;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public int getX()
	{
		return x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public int getOffset()
	{
		return offset;
	}
	
	public void setDir(int dir)
	{
		this.dir = dir;
	}
	
	public int getDir()
	{
		return dir;
	}
	
	public void lessLives() {
		lives--;
	}
}

package logic;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import enemies.Enemy;
import gameEngine.AudioPlayer;
import mapStates.Map;
import playerStates.PlayerDead;
import playerStates.PlayerIdle;
import playerStates.PlayerState;
import sprites.AnimationSprite;
import sprites.SpriteBuilder;
import weaponBehaviors.Mallet;
import weaponBehaviors.WeaponBehavior;

public class Player extends GameObject{
	Map map;
	int w,h;
	float vx,vy;
	int lives, speed, startX, startY, size, dir, deathTime;
	boolean shooting, dead;
	WeaponBehavior weapon;
	PlayerState playerState;
	Rectangle hitbox;
	GameManager gm;
	
	SpriteBuilder builder;
	AnimationSprite playerSprite;
	
	public Player(int x, int y, Map map, GameManager gm){
		super(x, y);
		dead = false;
		vy = vx = 0;
		w = h = 32;
		dir = 1;
		lives = 3;
		startX = x;
		startY = y;
		speed = 4;
		size = 32;
		deathTime = 0;
		
		this.map = map;
		this.gm = gm;
		
		hitbox = new Rectangle(x, y, size,size);
		
		//when the game starts, player only has a mallet
		weapon = new Mallet();
		
		builder = new SpriteBuilder("player.png",32,32,0,0);
			
		
		playerSprite = new AnimationSprite(x, y, builder.build(),32,32);
		playerSprite.setAnimSpd(8);
		//when the game starts, player is in idle
		playerState = new PlayerIdle(this, this.dir);		
	}
	
	public void update(ArrayList<GameObject> objects) {
			if(deathTime-gm.getTimePassed() == 3)
				dead = false;
			playerState.update(objects, map);
	}

	
	
	public void render(Graphics2D g) {
		
		
		playerState.render(g);
	}
	
	public boolean collides(ArrayList<GameObject> objects)
	{
		return false;
	}
	
	public Boolean collides(Enemy enemy) {
		return hitbox.intersects(enemy.getHitBox());
	}
	
	public Boolean collides(ArrayList<GameObject> objects, int x, int y) {
		Rectangle newHitBox = new Rectangle(x-1, y-1, size+1, size+1);
		for(GameObject obj : objects) {
			if(obj instanceof Enemy && newHitBox.intersects(((Enemy)obj).getHitBox())) {
				return true;
			}
		}
		return false;
		
	}
	
	public void loseLife()
	{
		if(!(playerState instanceof PlayerDead))
		{
			dead = true;
			deathTime = gm.getTimePassed();
			AudioPlayer.get().playEffectSound("audios/death_player.wav");
			playerState = new PlayerDead(this, dir);
			lives--;
			if(lives < 0)
				lives = 0;
		}
	}

	
	public void attack() {
		weapon.attack(dir,x,y, gm.getObjects());
	}
	
	public boolean noLivesLeft() {
		return (this.lives==0 ? true:false);
	}
	
	//setters and getters
	
	public boolean getDead()
	{
		return dead;
	}
	
	public void setDead(boolean val)
	{
		dead = val;
	}
	
	public GameManager getGm()
	{
		return gm;
	}
	
	public int getDeathTime()
	{
		return deathTime;
	}
	
	public void setDeathTime(int time)
	{
		deathTime = time;
	}
	
	public boolean getShooting()
	{
		return shooting;
	}
	
	public AnimationSprite getSp() {
		return this.playerSprite;
	}
	
	public SpriteBuilder getBuilder() {
		return this.builder;
	}
	public void setSp(AnimationSprite s) {
		this.playerSprite = s;
	}
	
	public void setMap(Map map)
	{
		this.map = map;
	}
	
	public int getStartX()
	{
		return startX;
	}
	
	public int getStartY()
	{
		return startY;
	}
	
	public int getLives() {
		return this.lives;
	}
	
	public void setLives(int lives) {
		this.lives = lives;
	}
	
	public boolean isShooting() {
		return shooting;
	}
	
	public void setShooting(boolean s) {
		shooting = s;
	}
	
	public WeaponBehavior getWeapon() {
		return weapon;
	}
	
	public Rectangle getHitBox() {
		return this.hitbox;
	}
	
	public void setWeapon(WeaponBehavior weaponB) {
		this.weapon = weaponB;
	}
	
	public void setPlayerState(PlayerState state) {
		this.playerState = state;
	}
	
	public PlayerState getPlayerState() {
		return this.playerState;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public int getDir()
	{
		return dir;
	}
	
	public void setDir(int dir)
	{
		this.dir = dir;
	}
	
	public int getSpeed()
	{
		return speed;
	}

}

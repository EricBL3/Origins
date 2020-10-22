package playerStates;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import gameEngine.Input;
import logic.GameObject;
import logic.Player;
import mapStates.Map;

public class PlayerIdle implements PlayerState {
	
	Player player;
	int dir, direction;
	
	public PlayerIdle(Player player, int dir) {
		super();
		this.player = player;
		this.dir = dir;
		switch (dir) {
			case 1: case 3:
				direction = 1;
				break;
			case 2: case 4:
				direction = -1;
				break;
		}
		
		player.getSp().reset();
		setSprites();
		player.getSp().setAnimSpd(1);
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
				int drawY = player.getY()+100;
				player.getWeapon().render(g, player.getDir(), player.getX(), drawY, player.isShooting());
				player.getSp().render(g);
	}
	
	public void setSprites() {
		
		player.getBuilder().empty();
		player.getBuilder().addImage(2, 4);
	}



	@Override
	public void update(ArrayList<GameObject> objects, Map map) {
		// TODO Auto-generated method stub
		player.setShooting(false);
		if(player.getSp().hasReachedEnd())
			player.setPlayerState(new PlayerIdle(player, player.getDir()));
		Input input = Input.get();
		
		
		if(input.isKeyPressed(KeyEvent.VK_SPACE)) {
			player.setShooting(true);
			player.setPlayerState(new PlayerAttacking(player, player.getDir()));
			
		}
		
		if (input.isKeyPressed(KeyEvent.VK_D) || input.isKeyPressed(KeyEvent.VK_RIGHT)) {
			player.getSp().reset();
			player.setPlayerState(new PlayerMoving(player, 1));
			if(((!map.getTile((player.getY())/player.getSize(), (player.getX()+player.getSize())/player.getSize()).isSolid() && !map.getTile((player.getY()+player.getSize()-1)/player.getSize(), (player.getX()+player.getSize())/player.getSize()).isSolid()) && !player.collides(objects, player.getX()+player.getSpeed(), player.getY())))
			player.setX(player.getX()+ player.getSpeed());
		}
		if (input.isKeyPressed(KeyEvent.VK_A)|| input.isKeyPressed(KeyEvent.VK_LEFT)) {
			player.setPlayerState(new PlayerMoving(player, 2));
			if(!map.getTile(player.getY()/player.getSize(), (player.getX()-player.getSpeed())/player.getSize()).isSolid() && !map.getTile((player.getY()+player.getSize()-1)/player.getSize(), (player.getX()-player.getSpeed())/player.getSize()).isSolid() && !player.collides(objects, player.getX()-player.getSpeed(), player.getY()))
			player.setX(player.getX()- player.getSpeed());
			
		}
					
		if (input.isKeyPressed(KeyEvent.VK_S) || input.isKeyPressed(KeyEvent.VK_DOWN)) {
			player.setPlayerState(new PlayerMoving(player, 3));
			if(((!map.getTile((player.getY()+player.getSize())/player.getSize(), player.getX()/player.getSize()).isSolid() && !map.getTile((player.getY()+player.getSize())/player.getSize(), (player.getX()+player.getSize()-1)/player.getSize()).isSolid()) && !player.collides(objects , player.getX(), player.getY()+player.getSpeed())))
				player.setY(player.getY()+ player.getSpeed());
		}
		if (input.isKeyPressed(KeyEvent.VK_W) || input.isKeyPressed(KeyEvent.VK_UP) )  {
			player.setPlayerState(new PlayerMoving(player, 4));
			if(((!map.getTile((player.getY()-player.getSpeed())/player.getSize(), player.getX()/player.getSize()).isSolid() && !map.getTile((player.getY()-player.getSpeed())/player.getSize(), (player.getX()+player.getSize()-1)/player.getSize()).isSolid()) && !player.collides(objects, player.getX(), player.getY()-player.getSpeed())))
				player.setY(player.getY()- player.getSpeed());
		}
		player.getSp().setScaleX(1f*direction);
		if(direction == -1)
			player.getSp().setX(player.getX()+player.getSize());
		else
			player.getSp().setX(player.getX());
		player.getSp().setY(player.getY());
		player.getSp().update();
		player.getHitBox().x = player.getX();
		player.getHitBox().y = player.getY();
	}




}

package playerStates;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import gameEngine.Input;
import logic.GameObject;
import logic.Player;
import mapStates.Map;

public class PlayerMoving implements PlayerState{
	Player player;
	int dir, direction;
	boolean moving;
	public PlayerMoving(Player player, int dir) {
		super();
		this.player = player;
		this.dir = dir;
		player.setDir(dir);
		moving = true;
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
		player.getSp().setAnimSpd(8);
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
		player.getBuilder().addImage(3, 4);
		player.getBuilder().addImage(4, 4);
		player.getBuilder().addImage(0, 5);

	}
	

	@Override
	public void update(ArrayList<GameObject> objects,Map map) {
		player.setShooting(false);
		
		Input input = Input.get();
	
		
		if (input.isKeyPressed(KeyEvent.VK_D) || input.isKeyPressed(KeyEvent.VK_RIGHT)) {
			direction = 1;
			moving = true;
			dir = 1;
			
			//player.setPlayerState(new PlayerMoving(player, 1));
			if(((!map.getTile((player.getY())/player.getSize(), (player.getX()+player.getSize())/player.getSize()).isSolid() && !map.getTile((player.getY()+player.getSize()-1)/player.getSize(), (player.getX()+player.getSize())/player.getSize()).isSolid()) && !player.collides(objects, player.getX()+player.getSpeed(), player.getY())))
			player.setX(player.getX()+ player.getSpeed());
		}
		if (input.isKeyPressed(KeyEvent.VK_A)|| input.isKeyPressed(KeyEvent.VK_LEFT)) {
			direction = -1;
			moving = true;
			dir = 2;
			//player.setPlayerState(new PlayerMoving(player, 2));
			if(!map.getTile(player.getY()/player.getSize(), (player.getX()-player.getSpeed())/player.getSize()).isSolid() && !map.getTile((player.getY()+player.getSize()-1)/player.getSize(), (player.getX()-player.getSpeed())/player.getSize()).isSolid() && !player.collides(objects, player.getX()-player.getSpeed(), player.getY()))
			player.setX(player.getX()- player.getSpeed());
			
		}
					
		if (input.isKeyPressed(KeyEvent.VK_S) || input.isKeyPressed(KeyEvent.VK_DOWN)) {
			direction = 1;
			moving = true;
			dir = 3;
			//player.setPlayerState(new PlayerMoving(player, 3));
			if(((!map.getTile((player.getY()+player.getSize())/player.getSize(), player.getX()/player.getSize()).isSolid() && !map.getTile((player.getY()+player.getSize())/player.getSize(), (player.getX()+player.getSize()-1)/player.getSize()).isSolid()) && !player.collides(objects , player.getX(), player.getY()+player.getSpeed())))
				player.setY(player.getY()+ player.getSpeed());
		}
		if (input.isKeyPressed(KeyEvent.VK_W) || input.isKeyPressed(KeyEvent.VK_UP) )  {
			direction = -1;
			moving = true;
			dir = 4;
			//player.setPlayerState(new PlayerMoving(player, 4));
			if(((!map.getTile((player.getY()-player.getSpeed())/player.getSize(), player.getX()/player.getSize()).isSolid() && !map.getTile((player.getY()-player.getSpeed())/player.getSize(), (player.getX()+player.getSize()-1)/player.getSize()).isSolid()) && !player.collides(objects, player.getX(), player.getY()-player.getSpeed())))
				player.setY(player.getY()- player.getSpeed());
		}
		player.setDir(dir);
		if(!moving)
			player.setPlayerState(new PlayerIdle(player, player.getDir()));
		
		player.getSp().setScaleX(1f*direction);
		if(direction == -1)
			player.getSp().setX(player.getX()+player.getSize());
		else
			player.getSp().setX(player.getX());
		player.getSp().setY(player.getY());
		player.getSp().update();
		player.getHitBox().x = player.getX();
		player.getHitBox().y = player.getY();
		
		moving = false;
	}



}

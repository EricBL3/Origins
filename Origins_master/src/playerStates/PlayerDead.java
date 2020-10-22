package playerStates;

import java.awt.Graphics2D;
import java.util.ArrayList;

import logic.GameObject;
import logic.Player;
import mapStates.Map;

public class PlayerDead implements PlayerState {
	Player player;
	int dir, direction;
	
	public PlayerDead(Player player, int dir){
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
		player.getSp().setAnimSpd(8);
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		player.getSp().render(g);
	}

	public void setSprites() {
		player.getBuilder().empty();
		player.getBuilder().addImage(0, 2);
		player.getBuilder().addImage(1, 2);
		player.getBuilder().addImage(2, 2);
		player.getBuilder().addImage(3, 2);	
		player.getBuilder().addImage(4, 2);
		player.getBuilder().addImage(0, 3);
		player.getBuilder().addImage(1, 3);
	}
		


	@Override
	public void update(ArrayList<GameObject> objects,Map map) {
		// TODO Auto-generated method stub
		player.getSp().setScaleX(1f*direction);
		if(direction == -1)
			player.getSp().setX(player.getX()+player.getSize());
		else
			player.getSp().setX(player.getX());
		player.getSp().setY(player.getY());
		player.getSp().update();
		if(player.getSp().hasReachedEnd() && !player.noLivesLeft())
		{
			player.setX(player.getStartX());
			player.setY(player.getStartY());
			player.getHitBox().x = player.getX();
			player.getHitBox().y = player.getY();
			player.setPlayerState(new PlayerIdle(player, dir));
		}
	}

}

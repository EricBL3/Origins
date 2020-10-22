package gameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Iterator;

import enemies.Enemy;
import gameEngine.AudioPlayer;
import gameEngine.Game;
import logic.GameManager;
import logic.GameObject;
import logic.Player;

public class Play implements GameState{

	@Override
	public void Update(GameManager gm) {
		
		//check if round is over
		if(gm.getTimePassed() < 0 && !gm.getPlayer().noLivesLeft())
			gm.nextRound();
		else
		{
			if(gm.getPlayer().getLives() <= 0 && gm.getPlayer().getSp().hasReachedEnd())
			{
					gm.setGameOver(true);
					gm.getTimer().stop();
					AudioPlayer.get().stopBackMusic();
					AudioPlayer.get().playBackMusic("audios/gameOver.wav");
			}
			if (gm.isGameOver()) return;
			
			//gm.getPlayer().update(gm.getObjects());
			
			//for each enemy in the arraylist of objects
			for(int i = 0; i < gm.getObjects().size(); i++)
			{
				if(gm.getObjects().get(i) instanceof Enemy)
					((Enemy)gm.getObjects().get(i)).update(gm.getPlayer(), gm.getMap(), gm.getObjects());
				else if(gm.getObjects().get(i)  instanceof Player)
					((Player) gm.getObjects().get(i) ).update(gm.getObjects());
			}
	
			//quitar objetos destruidos
			Iterator<GameObject> itr = gm.getObjects().iterator();
			while(itr.hasNext())
			{
				GameObject obj = itr.next();
				if(obj.getDestroy())
				{
					itr.remove();
					gm.addScore(15);
				}
			}
			
		}
	}

	@Override
	public void render(Graphics2D g, GameManager gm) {
		
		g.fillRect(0,0,Game.HEIGHT, Game.WIDTH);
		
		
		
		gm.getMap().render(g);
		//gm.getPlayer().render(g);
		for(int i = 0; i < gm.getObjects().size(); i++)
		{
			gm.getObjects().get(i).render(g);
		}
		// TODO Auto-generated method stub
		if(gm.isGameOver())
		{
			g.setFont(new Font("Times Roman", Font.BOLD, 50));
			g.setColor(Color.white);
			g.drawString("Game Over", Game.HEIGHT/2, Game.WIDTH/2);
		}
		
		
	}

}

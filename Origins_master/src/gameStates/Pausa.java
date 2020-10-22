package gameStates;

import java.awt.Color;
import java.awt.Graphics2D;

import gameEngine.Game;
import logic.GameManager;

public class Pausa implements GameState{

	@Override
	public void Update(GameManager gm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics2D g,GameManager gm) {
		// TODO Auto-generated method stub
		g.setColor(Color.white);
		g.fillRect(0,0,Game.HEIGHT, Game.WIDTH);
		gm.getMap().render(g);
		//gm.getPlayer().render(g);
		for(int i = 0; i < gm.getObjects().size(); i++)
		{
			gm.getObjects().get(i).render(g);
		}
	}

}

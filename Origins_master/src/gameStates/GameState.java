package gameStates;

import java.awt.Graphics2D;
import logic.GameManager;

public interface GameState{

	
	
	public void Update(GameManager gm);
		
	public void render(Graphics2D g,GameManager gm);
	
	
}

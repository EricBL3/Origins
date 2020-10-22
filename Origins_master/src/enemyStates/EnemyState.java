package enemyStates;

import java.awt.Graphics2D;
import java.util.ArrayList;

import logic.GameObject;
import logic.Player;
import mapStates.Map;

public interface EnemyState {
	public void searchPlayer(Player p, Map map, ArrayList<GameObject> objects);
	public void attack(Player p);
	public void update(Player p, Map map, ArrayList<GameObject> objects);
	public void render(Graphics2D g);
	public boolean collides(ArrayList<GameObject> objects);
	public void setSprites();
}

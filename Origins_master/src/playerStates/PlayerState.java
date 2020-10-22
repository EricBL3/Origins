package playerStates;

import java.awt.Graphics2D;
import java.util.ArrayList;

import logic.GameObject;
import mapStates.Map;

public interface PlayerState {
	public void render(Graphics2D g);
	public void update(ArrayList<GameObject> objects,Map map);
	public void setSprites();
}

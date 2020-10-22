package weaponBehaviors;

import java.awt.Graphics2D;
import java.util.ArrayList;

import logic.GameObject;

public interface WeaponBehavior {
	public void attack(int dir, int x, int y, ArrayList<GameObject> objects);
	public void render(Graphics2D g, int dir, int x, int y, boolean shooting);

}

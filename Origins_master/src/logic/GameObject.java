package logic;

import java.awt.Graphics2D;
import java.util.ArrayList;

public abstract class GameObject {

	protected int x, y;
	protected boolean destroyed;
	
	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
		destroyed = false;
	}
	
	public abstract boolean collides(ArrayList<GameObject> objects);
	public abstract void render(Graphics2D g);
	
	public boolean getDestroy()
	{
		return destroyed;
	}
	
	public void destroy()
	{
		destroyed = true;
	}

}

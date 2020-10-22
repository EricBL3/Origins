package mapStates;

import java.awt.Graphics2D;

import world.Tile;

public interface MapState {
	
	public abstract void init();
	public abstract void render (Graphics2D g);
	public abstract void tick();
	public abstract Tile getTile(int j, int i);
	public abstract int getTileSize();
	public abstract int getGridWidth();
	public abstract int getGridHeight();
}

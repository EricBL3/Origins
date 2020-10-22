package world;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Tile {

	protected boolean solid;
	protected String type;
	protected BufferedImage image;

	public Tile(String type, boolean solid, BufferedImage image) {
		// TODO Auto-generated constructor stub
		this.type = type;
		this.solid = solid;
		this.image = image;
	}
	
	public boolean isSolid() {
		if (type == "rock" || type == "bush") {
			return true;
		} else return false;
	}
	
	public void render (Graphics2D g) {
	}
	
	public BufferedImage getImage() {
		return image;
	}

}

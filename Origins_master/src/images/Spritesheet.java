package images;

import java.awt.image.BufferedImage;

public class Spritesheet {
	private BufferedImage sheet;

	public Spritesheet(BufferedImage sheet)
	{
		this.sheet = sheet;
	}
		
	public BufferedImage crop(int x, int y, int width, int height)
	{
		return sheet.getSubimage(x, y, width, height);
	}
}


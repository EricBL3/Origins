package sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class SpriteBuilder {
	
	private BufferedImage spritesheet;
	private List<BufferedImage> images;
	private int cellW, cellH;
	
	private int xoff, yoff;

	public SpriteBuilder (String fName, int cellW, int cellH) {
		
		this(fName, cellW, cellH, 0, 0);
	}
	
	public SpriteBuilder (String fName, int cellW, int cellH, int xoff, int yoff) {
		try {
		           spritesheet = (BufferedImage)ImageIO.read(getClass().getClassLoader().getResource("./"+fName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		images = new ArrayList<>();
		this.cellW = cellW;
		this.cellH = cellH;
		
		this.xoff = xoff;
		this.yoff = yoff;
	}
	
	public SpriteBuilder addImage(int i, int j) {
		images.add(spritesheet.getSubimage(xoff + i*cellW, yoff + j*cellH, cellW, cellH));
		return this;
	}
	
	public CachedSprite build() {
		return new CachedSprite(images);
	}
	
	public void empty() {
		images.clear();
	}
}



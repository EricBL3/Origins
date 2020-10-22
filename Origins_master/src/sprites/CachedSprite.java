package sprites;

import java.awt.image.BufferedImage;
import java.util.List;

public class CachedSprite {
	private List<BufferedImage> images;
	
	public CachedSprite(List<BufferedImage> images) {
		this.images = images;
	}
	
	public BufferedImage get(int index) {
		return images.get(index);
	}
	
	public int size() {
		return images.size();
	}

}

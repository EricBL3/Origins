package sprites;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class AnimationSprite {
	private int imageIndex;
	private CachedSprite sprite;
	
	private boolean reachedEnd;
	private int animSpd;
	private int animCount;
	private int topCount;
	
	private int x, y;
	
	private int width, height;
	
	private float scaleX, scaleY;
	
	
	public AnimationSprite(int x, int y, CachedSprite sprite) {
		this(x, y, sprite, sprite.get(0).getWidth(), sprite.get(0).getHeight());
	}
	
	public AnimationSprite(int x, int y, CachedSprite sprite, int width, int height) {
		imageIndex = 0;
		this.sprite = sprite;

		this.x = x;
		this.y = y;
		
		this.width  = width;
		this.height = height;
		
		scaleX = 1f;
		scaleY = 1f;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setAnimSpd(int animSpd) {
		this.animSpd = animSpd;
		if (animSpd != 0) {
			topCount = 60 / animSpd;
			animCount = 0;
		}
		reachedEnd = false;
	}
	
	public float getScaleX() {
		return scaleX;
	}
	
	public float getScaleY() {
		return scaleY;
	}
	
	public void setScaleX(float scaleX) {
		this.scaleX = scaleX;
	}
	
	public void setScaleY(float scaleY) {
		this.scaleY = scaleY;
	}
	
	public void update() {
		
		if(animSpd > 0)
		{
			if(animCount < topCount)
			{
				animCount++;
				//reachedEnd = false;
			}
			else
			{
				animCount = 0;
				imageIndex = (imageIndex+1) % sprite.size();
				if(imageIndex == sprite.size()-1)
					reachedEnd = true;
				
			}
			
		}
	}
	
	public void render(Graphics2D g) {
		
		double aspectX = width / sprite.get(0).getWidth();
		double aspectY = height / sprite.get(0).getHeight();
		
		AffineTransform at = AffineTransform.getTranslateInstance(x, y+100);
		at.concatenate(AffineTransform.getScaleInstance(aspectX, aspectY));
		at.concatenate(AffineTransform.getScaleInstance(scaleX, scaleY));
		
		g.drawImage(sprite.get(imageIndex),at, null);
	}
	
	public boolean hasReachedEnd() {
		return reachedEnd;
	}
	
	public int getAnimCount() {
		return animCount;
	}
	
	public void reset() {
		imageIndex = 0;
		animCount = 0;
	}

}

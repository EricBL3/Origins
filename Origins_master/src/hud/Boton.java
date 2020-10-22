package hud;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import logic.GameManager;

public class Boton{

	private int x,y,w,h;
	private boolean pausa=false;
	private Color c=new Color(35, 110, 45);
	GameManager originsGame;

	public Boton(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	public void setSize(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.w = width;
		this.h = height;
	}
	
	//Paint
	public void paint(Graphics g, BufferedImage BI) {
		//g.setColor(c);
		//g.fillRect(x, y, w, h);
		g.drawImage(BI,x,y,w,h,null);
	}
	
	//Click



	public boolean click(int mx, int my) {
		if(mx<1080 && 0>mx && 0<my && 100>my) {
			pausa=true;
		}
		return pausa;	
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;

	}
	
	public boolean getPausa() {
		return pausa;
	}
	public void setPausa(boolean pausa) {
		this.pausa = pausa;
	}
	public Color getC() {
		return c;
	}
	public void setC(Color c) {
		this.c = c;
	}
	public GameManager getOriginsGame() {
		return originsGame;
	}
	public void setOriginsGame(GameManager originsGame) {
		this.originsGame = originsGame;
	}
}
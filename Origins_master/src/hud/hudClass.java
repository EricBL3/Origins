package hud;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import gameEngine.AudioPlayer;
import gameEngine.Game;
import gameEngine.Input;
import gameStates.Pausa;
import gameStates.Play;
import images.Assets;
import logic.GameManager;

public class hudClass {

	private int x,y,width,height, counter;
	private Boton bt1,bt2,live,live2,live3, sound;
	private Input in;
	private Font customFont;
	//private Player player;
	//Map map;
	//int tileSze, mapNum, round;
	public boolean off1=false,off2=false,off3=false, snd = true;
	//Color color=new Color(35, 110, 45);
	Color color=new Color(255, 199, 38);
	public hudClass(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		counter = 1;
		this.width = width;
		this.height = height;
		in = Input.get();
		
		bt1=new Boton(100,40,60,50);
		bt2=new Boton(200,40,60,50);
		live=new Boton(300,25,60,70);
		live2=new Boton(400,25,60,70);
		live3=new Boton(500,25,60,70);
		sound = new Boton(985, 8, 25, 25);
		createFont();
		
	}
	
	public void createFont()
	{
		try
		{
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Image/Orbitron-Regular.ttf")).deriveFont(30f);
			
		}
		catch(FontFormatException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void render(Graphics2D g, GameManager gm) {
		if(gm.getPlayer().getDead() && !gm.getPlayer().noLivesLeft())
		{
			g.setFont(customFont.deriveFont(50f));
			g.setColor(Color.red);
			g.drawString("Invulnerable", Game.WIDTH/2-150, 500);
		}
		
		g.setColor(color);
		g.fillRect(x, y, width, height);
		g.setFont(customFont.deriveFont(28f));
		g.setColor(new Color(255,255,255));
		g.drawString("Pause: ", 20, 30);
		g.drawString("Play: ", 170, 30);
		g.drawString("Lives: ", 390, 22);

		bt1.paint(g, Assets.pause);
		bt2.paint(g, Assets.play);

		switch(gm.getPlayer().getLives())
		{
			case 3:
				live.paint(g, Assets.live);
				live2.paint(g, Assets.live);
				live3.paint(g, Assets.live);
				break;
			
			case 2:
				live.paint(g, Assets.live);
				live2.paint(g, Assets.live);
				live3.paint(g, Assets.die);
				break;
				
			case 1:
				live.paint(g, Assets.live);
				live2.paint(g, Assets.die);
				live3.paint(g, Assets.die);
				break;
				
			case 0:
				live.paint(g, Assets.die);
				live2.paint(g, Assets.die);
				live3.paint(g, Assets.die);
				break;
		}
		if(snd)
			sound.paint(g, Assets.soundOn);
		else
			sound.paint(g,  Assets.soundOff);

		//score
		g.setFont(customFont);
		g.setColor(new Color(82, 107, 45));
		g.drawString(Integer.toString(gm.getScore()), 625, 70);
		g.setColor(Color.WHITE);
		g.drawString("Score: ", 600, 30);

		//time
		g.setColor(Color.white);
		if(gm.getTimePassed() >= 0)
			g.drawString(Integer.toString(gm.getTimePassed()), 775, 70);
		else
		{
			g.drawString("0", 775, 70);
			g.setFont(customFont.deriveFont(50f));
			g.setColor(Color.red);
			g.drawString("Next Round!", (Game.WIDTH/2)-150, Game.HEIGHT/2);
			if((gm.getRound()+1) % 5 == 0)
				g.drawString("1 UP", (Game.WIDTH/2)-25, (Game.HEIGHT/2)+60);
		}
		g.setFont(customFont);
		g.setColor(Color.white);
		g.drawString("Time: ", 755, 30);

		//round
		g.setColor(Color.red);
		g.drawString(Integer.toString(gm.getRound()), 900, 70);
		g.setColor(Color.WHITE);
		g.drawString("Round: ", 860, 30);

	}
	
	public void update(GameManager gm)
	{
		//delay para los botones
		if(counter % 10 == 0)
		{
			if(in.isBtnPressed(1) && (in.getMX() > 100 && in.getMX() < 160) && (in.getMY() > 20 && in.getMY() < 70))
			{
				gm.getTimer().stop();
				AudioPlayer.get().playEffectSound("audios/button.wav");
				AudioPlayer.get().pauseBackMusic();
				gm.setGsm(new Pausa());
			}
			
			if(in.isBtnPressed(1) && (in.getMX() > 200 && in.getMX() < 260) && (in.getMY() > 20 && in.getMY() < 70))
			{
				AudioPlayer.get().playEffectSound("audios/button.wav");
				AudioPlayer.get().restartBackMusic();
				gm.getTimer().start();
				gm.setGsm(new Play());
			}
			if(in.isBtnPressed(1) && (in.getMX() > 985 && in.getMX() < 1010) && (in.getMY() > 8 && in.getMY() < 33))
			{
				AudioPlayer.get().playEffectSound("audios/button.wav");
				if(snd)
				{
					AudioPlayer.get().setMusicVolume(0f);
					snd = false;
				}
				else
				{
					AudioPlayer.get().setMusicVolume(0.7f);
					snd = true;
				}
			}
		}
		counter++;
	}
	
}
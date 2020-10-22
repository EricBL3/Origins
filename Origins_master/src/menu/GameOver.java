package menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import gameEngine.AudioPlayer;
import gameEngine.Input;
import world.worldLoader;

public class GameOver extends JFrame{

	private JButton  back;
	public static int WIDTH, HEIGHT;
	private String title;
	private int score, time, round;
	private JLabel overTitle, scoreTxt, timeTxt;
	private Font customFont;
	
	public GameOver(String title, int width, int height, int score, int time, int round) throws HeadlessException {
		super();
		GameOver.WIDTH=width;
		GameOver.HEIGHT=height;
		this.title = title;
		this.score = score;
		this.time = time;
		this.round = round;
		createFont();
		createWindow();
		
	}
	
	public void createWindow()
	{

		
	
		overTitle = new JLabel();
		scoreTxt = new JLabel("Score");
		timeTxt = new JLabel();
		
		
		

		back=new JButton();
		getContentPane().setBackground(Color.black);
		setResizable(false);
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dims = new Dimension(1024,575);
		setPreferredSize(dims);
		setMinimumSize(dims);
		setMaximumSize(dims);
		
		addKeyListener(Input.get());
		addMouseMotionListener(Input.get());
		addMouseListener(Input.get());
		
		getContentPane().setLayout(null);
		
		overTitle.setIcon(new ImageIcon(worldLoader.loadImage("Image/gameover.png")));
		overTitle.setVisible(true);
		overTitle.setBounds(0, 0, 1100, 550);
		//set buttons
		back.setBackground(Color.black);
		back.setContentAreaFilled(true);
		back.setText("BACK");
		back.setIcon(new ImageIcon(worldLoader.loadImage("Image/backbt.png")));

		back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	backClicked(evt);
            }
        });
		
		//score
		scoreTxt.setFont(customFont);
		scoreTxt.setForeground(Color.yellow);
		scoreTxt.setText(Integer.toString(score) + " points");
		scoreTxt.setBounds(270, 230, 500, 50);
		scoreTxt.setVisible(true);
		//time
		timeTxt.setFont(customFont);
		timeTxt.setForeground(Color.yellow);
		timeTxt.setText(Integer.toString(time) + " seconds left in round " + Integer.toString(round));
		timeTxt.setBounds(230, 325, 500, 50);
		timeTxt.setVisible(true);
		
		
		getContentPane().add(back);
		getContentPane().add(scoreTxt);
		getContentPane().add(timeTxt);
		getContentPane().add(overTitle);
		

		back.setBounds(20, 500,153, 40);
		
		
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void createFont()
	{
		try
		{
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Image/Orbitron-Regular.ttf")).deriveFont(25f);
			
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
	
	
	public void backClicked(MouseEvent evt)
	{
		AudioPlayer.get().playEffectSound("audios/button.wav");
		AudioPlayer.get().stopBackMusic();
		new StartMenu("Origins", 1024, 768);
		dispose();
		
	}
}

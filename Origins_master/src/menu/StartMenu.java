package menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import gameEngine.AudioPlayer;
import gameEngine.Game;
import gameEngine.Input;
import world.worldLoader;


public class StartMenu extends JFrame{
	private JButton  playBtn,help;
	private JLabel gameTitle;

	public static int WIDTH, HEIGHT;
	private String title;
	private Color color;
	//private imagenStart start=new imagenStart();
	
	public StartMenu(String title, int width, int height) throws HeadlessException {
		super();
		StartMenu.WIDTH=width;
		StartMenu.HEIGHT=height;
		this.title = title;
		color=new Color(35,110,45);
		//
		//ImageIcon start=new ImageIcon(Assets.start);
		createWindow();
		if(AudioPlayer.get().getCurrent() == null)
			AudioPlayer.get().playBackMusic("audios/menu_music.wav");
	}

	public void createWindow()
	{
		gameTitle = new JLabel();

		
		getContentPane().setBackground(color);
		playBtn = new JButton();
		help=new JButton();
		setResizable(false);
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension dims = new Dimension(850, 671);
		setPreferredSize(dims);
		setMinimumSize(dims);
		setMaximumSize(dims);
		
		addKeyListener(Input.get());
		addMouseMotionListener(Input.get());
		addMouseListener(Input.get());
		
		getContentPane().setLayout(null);
		
		gameTitle.setIcon(new ImageIcon(worldLoader.loadImage("Image/startmenu.png")));
		gameTitle.setVisible(true);
		gameTitle.setBounds(-98, -10, 1100, 671);
		//gameTitle.resize(WIDTH,HEIGHT);
		//set buttons
		//playBtn.setIcon(start);
		playBtn.setBackground(Color.black);
		playBtn.setContentAreaFilled(true);
		//playBtn.setText("Play");
		playBtn.setIcon(new ImageIcon(worldLoader.loadImage("Image/playmenu.png")));
		help.setBackground(Color.black);
		help.setContentAreaFilled(true);
		//help.setText("Help");
		help.setIcon(new ImageIcon(worldLoader.loadImage("Image/help.png")));
		playBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	playBtnClicked(evt);
            }
           
		});
		help.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	helpClicked(evt);
            }
           
        }
	
				);
	
		//getContentPane().createImage((ImageProducer) Assets.start);
		getContentPane().add(playBtn);
		getContentPane().add(help);
		getContentPane().add(gameTitle);

		playBtn.setBounds(160, 188,230, 60);
		help.setBounds(500, 188,230, 60);

		
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	public void playBtnClicked(MouseEvent evt)
	{
		AudioPlayer.get().playEffectSound("audios/button.wav");
		AudioPlayer.get().stopBackMusic();
		new Game("Origins", 1024, 768).start();
		dispose();
	}
	
	public void helpClicked(MouseEvent evt)
	{
		AudioPlayer.get().playEffectSound("audios/button.wav");
		new Help("Origins", 1024, 768);
		dispose();
	}
	
}



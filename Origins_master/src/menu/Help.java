package menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import gameEngine.Input;
import world.worldLoader;

public class Help extends JFrame{
	private JButton  back;
	public static int WIDTH, HEIGHT;
	private String title;
	private JLabel helpTitle;

	public Help(String title, int width, int height) throws HeadlessException {
		super();
		Help.WIDTH=width;
		Help.HEIGHT=height;
		this.title = title;

		createWindow();
	}
	
	public void createWindow()
	{

		helpTitle = new JLabel();
	
		back=new JButton();
		
		//getContentPane().setBackground(Color.black);
		setResizable(false);
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dims = new Dimension(1024, 575);
		setPreferredSize(dims);
		setMinimumSize(dims);
		setMaximumSize(dims);
		
		addKeyListener(Input.get());
		addMouseMotionListener(Input.get());
		addMouseListener(Input.get());
		
		getContentPane().setLayout(null);
		
		helpTitle.setIcon(new ImageIcon(worldLoader.loadImage("Image/helppage.png")));
		helpTitle.setVisible(true);
		helpTitle.setBounds(0, 0, 1100, 550);
		//set buttons
		back.setBackground(Color.black);
		back.setContentAreaFilled(true);
		back.setIcon(new ImageIcon(worldLoader.loadImage("Image/backbt.png")));
		back.setText("BACK");
		back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	backClicked(evt);
            }
        });

		getContentPane().add(back);
		getContentPane().add(helpTitle);

		back.setBounds(20, 500,153, 40);
		

		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	public void backClicked(MouseEvent evt)
	{
		new StartMenu("Origins", 1024, 768);
		dispose();
	}
}

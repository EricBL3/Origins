package gameEngine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

public class Input implements KeyListener, MouseInputListener{

	
	private static Input instance;
	
	public static Input get() {
		if (instance == null)
			instance = new Input();
		
		return instance;
	}
	
	
	boolean keys[];
	boolean buttons[];
	int mx, my;
	
	private Input() {
		keys = new boolean[256];
		buttons = new boolean[8];
		mx = 0;
		my = 0;
	}
	
	
	public void clear()
	{
		keys = new boolean[256];
		buttons = new boolean[8];
		mx = 0;
		my = 0;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		buttons[e.getButton()] = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		buttons[e.getButton()] = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	
	public boolean isKeyPressed(int keyCode) {
		return keys[keyCode];
	}
	
	public boolean isKeyReleased(int keyCode) {
		return !keys[keyCode];
	}
	
	public int getMX() {
		return mx;
	}
	
	public int getMY() {
		return my;
	}
	
	public boolean isBtnPressed(int mouseBtn) {
		return buttons[mouseBtn];
	}
	
	public boolean isBtnReleased(int mouseBtn) {
		return !buttons[mouseBtn];
	}

}

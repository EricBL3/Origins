package weaponBehaviors;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import enemies.Enemy;
import logic.GameObject;

public class Mallet implements WeaponBehavior {
	
	Rectangle hb;

	@Override
	public void attack(int dir, int x, int y, ArrayList<GameObject> objects) {
		// TODO Auto-generated method stub
		//crear el rectangulo en la posicion que debe estar y checar las colisiones
		switch (dir) {		
		case 1: // to the right
			hb = new Rectangle(x+33, y, 20, 32);
			break;
		case 2: //to the left
			hb = new Rectangle(x-20, y, 20, 32);
			break;
		case 3: // down
			hb = new Rectangle(x, y+33, 32, 20);
			break;
		case 4: //up
			hb = new Rectangle(x, y-20, 33, 20);
			break;
		}
		 collides(objects);

	}
	
	public void render(Graphics2D g, int dir, int x, int y, boolean shooting) {

		
	}
	
	public Boolean collides(ArrayList<GameObject> objects) {
		for(GameObject obj : objects) {
			if(obj instanceof Enemy)
			{
				Enemy en = ((Enemy)obj);
				if(hb.intersects(en.getHitBox())) {
					en.lessLives();//metodo de perder vidas
					return true;
				}
			}
		}
		return false;
		
	}

}

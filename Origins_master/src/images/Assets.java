package images;

import java.awt.image.BufferedImage;
import world.worldLoader;

public class Assets {
	public static BufferedImage[] bush, water, dust;
	public static BufferedImage pause,play,live,die,soundOn, soundOff;
	public static final int WIDTH = 320, HEIGHT = 320, BUTTONSIZE = 200;

	public static void init() {
		// TODO Auto-generated constructor stub
		Spritesheet mapSheet = new Spritesheet(worldLoader.loadImage("Image/textures.png"));
		Spritesheet buttonSheet = new Spritesheet(worldLoader.loadImage("Image/buttons.png"));
		
		pause=worldLoader.loadImage("Image/pause.png");		
		play=worldLoader.loadImage("Image/play.png");
		
		live = buttonSheet.crop(BUTTONSIZE, 0, BUTTONSIZE, BUTTONSIZE);
		die = buttonSheet.crop(0, 0, BUTTONSIZE, BUTTONSIZE);
		soundOn = buttonSheet.crop(BUTTONSIZE * 5, 0, BUTTONSIZE, BUTTONSIZE);
		soundOff = buttonSheet.crop(BUTTONSIZE * 4, 0, BUTTONSIZE, BUTTONSIZE);
		/*
		pause=worldLoader.loadImage("Image/pause.png");
		play=worldLoader.loadImage("Image/play.png");
		
		*/
		live=worldLoader.loadImage("Image/corazon.png");
		die=worldLoader.loadImage("Image/byeVida.png");
		
		//Cada tile mide 320x320
		bush = new BufferedImage[13];
		bush[0] = mapSheet.crop(0, 0, WIDTH, HEIGHT);
		bush[1] = mapSheet.crop(WIDTH, 0, WIDTH, HEIGHT);
		bush[2] = mapSheet.crop(WIDTH * 2, 0, WIDTH, HEIGHT);
		bush[3] = mapSheet.crop(WIDTH * 3, 0, WIDTH, HEIGHT);
		bush[4] = mapSheet.crop(WIDTH * 4, 0, WIDTH, HEIGHT);
		bush[5] = mapSheet.crop(WIDTH * 5, 0, WIDTH, HEIGHT);
		bush[6] = mapSheet.crop(WIDTH * 6, 0, WIDTH, HEIGHT);
		bush[7] = mapSheet.crop(WIDTH * 7, 0, WIDTH, HEIGHT);
		bush[8] = mapSheet.crop(0, HEIGHT, WIDTH, HEIGHT);
		bush[9] = mapSheet.crop(WIDTH, HEIGHT, WIDTH, HEIGHT);
		bush[10] = mapSheet.crop(WIDTH * 3, HEIGHT, WIDTH, HEIGHT);
		bush[11] = mapSheet.crop(WIDTH * 5, HEIGHT, WIDTH, HEIGHT);
		bush[12] = mapSheet.crop(WIDTH * 7, HEIGHT, WIDTH, HEIGHT);
		
		water = new BufferedImage[26];
		water[0] = mapSheet.crop(WIDTH, HEIGHT * 2, WIDTH, HEIGHT);
		water[1] = mapSheet.crop(WIDTH * 3, HEIGHT * 2, WIDTH, HEIGHT);
		water[2] = mapSheet.crop(WIDTH * 5, HEIGHT * 2, WIDTH, HEIGHT);
		water[3] = mapSheet.crop(WIDTH * 7, HEIGHT * 2, WIDTH, HEIGHT);
		water[4] = mapSheet.crop(WIDTH, HEIGHT * 3, WIDTH, HEIGHT);
		water[5] = mapSheet.crop(WIDTH * 3, HEIGHT * 3, WIDTH, HEIGHT);
		water[6] = mapSheet.crop(WIDTH * 5, HEIGHT * 3, WIDTH, HEIGHT);
		water[7] = mapSheet.crop(WIDTH * 7, HEIGHT * 3, WIDTH, HEIGHT);
		water[8] = mapSheet.crop(WIDTH, HEIGHT * 4, WIDTH, HEIGHT);
		water[9] = mapSheet.crop(WIDTH * 3, HEIGHT * 4, WIDTH, HEIGHT);
		water[10] = mapSheet.crop(WIDTH * 5, HEIGHT * 4, WIDTH, HEIGHT); 
		water[11] = mapSheet.crop(WIDTH * 7, HEIGHT * 4, WIDTH, HEIGHT); // AGUA AZUL CIELO
		water[12] = mapSheet.crop(WIDTH * 2, HEIGHT, WIDTH, HEIGHT);//PASTITO CON AGUA A LA IZQUIERDA
		
		water[13] = mapSheet.crop(WIDTH * 4, HEIGHT, WIDTH, HEIGHT);//ROCA
		water[14] = mapSheet.crop(WIDTH * 6, HEIGHT, WIDTH, HEIGHT);//PUNTA ARBOL CON AGUA
		water[15] = mapSheet.crop(0, HEIGHT * 2, WIDTH, HEIGHT);//PUNTA ARBOL IZQ CON AGUA
		water[16] = mapSheet.crop(WIDTH * 2, HEIGHT * 2, WIDTH, HEIGHT);//TRONCO IZQ CON AGUA
		water[17] = mapSheet.crop(WIDTH * 4, HEIGHT * 2, WIDTH, HEIGHT);// TRONCO DER CON AGUA
		water[18] = mapSheet.crop(WIDTH * 6, HEIGHT * 2, WIDTH, HEIGHT);//SIGNO DE INTERROGACION AGUA
		water[19] = mapSheet.crop(0, HEIGHT * 3, WIDTH, HEIGHT);//AGUA A LA IZQ CON TRONCO BASE
		water[20] = mapSheet.crop(WIDTH, HEIGHT * 5, WIDTH, HEIGHT); //AGUA AZUL MAR
		water[21] = mapSheet.crop(WIDTH * 7, HEIGHT * 5, WIDTH, HEIGHT); //ESQUINA CON AGUA 
		water[22] = mapSheet.crop(WIDTH * 5, HEIGHT * 6, WIDTH, HEIGHT); //PUNTA PALMERA AGUA IZQ
		water[23] = mapSheet.crop(WIDTH * 7, HEIGHT * 6, WIDTH, HEIGHT); //PUNTA PALMERA AGUA DER
		water[24] = mapSheet.crop(WIDTH, HEIGHT * 7, WIDTH, HEIGHT);//TRONCO PALMERA IZQ
		water[25] = mapSheet.crop(WIDTH * 3, HEIGHT * 7, WIDTH, HEIGHT); //TRONCO PALMERA DER
		
		
		dust = new BufferedImage[19];
		dust[0] = mapSheet.crop(WIDTH * 2, HEIGHT * 3, WIDTH, HEIGHT);//AGUA ARRIBA
		dust[1] = mapSheet.crop(WIDTH * 4, HEIGHT * 3, WIDTH, HEIGHT);//ROCAS C AGUA IZQ
		dust[2] = mapSheet.crop(WIDTH * 6, HEIGHT * 3, WIDTH, HEIGHT);//DUST
		dust[3] = mapSheet.crop(0, HEIGHT * 4, WIDTH, HEIGHT); //DUST WITH BUSH
		dust[4] = mapSheet.crop(WIDTH * 2, HEIGHT * 4, WIDTH, HEIGHT); //ROCKS WITH DUST UP
		dust[5] = mapSheet.crop(WIDTH * 4, HEIGHT * 4, WIDTH, HEIGHT);//ROCKS W DUST RIGHT
		dust[6] = mapSheet.crop(WIDTH * 6, HEIGHT * 4, WIDTH, HEIGHT);
		dust[7] = mapSheet.crop(0, HEIGHT * 5, WIDTH, HEIGHT);
		dust[8] = mapSheet.crop(WIDTH * 2, HEIGHT * 5, WIDTH, HEIGHT);
		dust[9] = mapSheet.crop(WIDTH * 3, HEIGHT * 5, WIDTH, HEIGHT);
		dust[10] = mapSheet.crop(WIDTH * 4, HEIGHT * 5, WIDTH, HEIGHT);
		dust[11] = mapSheet.crop(WIDTH * 5, HEIGHT * 5, WIDTH, HEIGHT);
		dust[12] = mapSheet.crop(WIDTH * 6, HEIGHT * 5, WIDTH, HEIGHT);
		dust[13] = mapSheet.crop(0, HEIGHT * 6, WIDTH, HEIGHT);
		dust[14] = mapSheet.crop(WIDTH * 2, HEIGHT * 6, WIDTH, HEIGHT);
		dust[15] = mapSheet.crop(WIDTH * 3, HEIGHT * 6, WIDTH, HEIGHT);
		dust[16] = mapSheet.crop(WIDTH * 4, HEIGHT * 6, WIDTH, HEIGHT);
		dust[17] = mapSheet.crop(0, HEIGHT * 7, WIDTH, HEIGHT);
		dust[18] = mapSheet.crop(WIDTH * 2, HEIGHT * 7, WIDTH, HEIGHT);
		
	}
	
	

}

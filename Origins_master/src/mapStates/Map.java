package mapStates;

import java.awt.Color;
import java.awt.Graphics2D;

import gameEngine.Game;
import images.Assets;
import world.Tile;


public class Map implements MapState {
	protected String mapStr;
	protected Tile map[][]; 
	
	protected Tile bush0;
	protected Tile bush1;
	protected Tile bush2;
	protected Tile bush3;
	protected Tile bush4;
	protected Tile bush5;
	protected Tile bush7;
	protected Tile bush8;
	protected Tile bush9;
	protected Tile bushA;
	protected Tile bushB;
	protected Tile bushC;
	protected Tile bushD;
	
	protected Tile waterE;
	protected Tile waterF;
	protected Tile waterG;
	protected Tile waterH;
	protected Tile waterI;
	protected Tile waterJ;
	protected Tile waterK;
	protected Tile waterL;
	protected Tile waterM;
	protected Tile waterN;
	protected Tile waterO;
	protected Tile waterP;
	protected Tile waterAA;
	protected Tile waterQ;
	protected Tile waterBB;
	protected Tile waterCC;
	protected Tile waterDD;
	protected Tile waterEE;
	protected Tile waterFF;
	protected Tile waterGG;
	protected Tile waterHH;
	protected Tile waterT;
	protected Tile waterW;
	protected Tile waterX;
	protected Tile waterY;
	protected Tile waterZ;
	
	protected Tile dustII;
	protected Tile dustJJ;
	protected Tile dustKK;
	protected Tile dustLL;
	protected Tile dustMM;
	protected Tile dustNN;
	protected Tile dustOO;
	protected Tile dustPP;
	protected Tile dustQQ;
	protected Tile dustR;
	protected Tile dustRR;
	protected Tile dustS;
	protected Tile dustSS;
	protected Tile dustTT;
	protected Tile dustUU;
	protected Tile dustV;
	protected Tile dustVV;
	protected Tile dustXX;
	protected Tile dustYY;
	
	
	protected int gridWidth, gridHeight;
	protected final static int tileSize = 32;
	
	public Map()
	{
		gridWidth = Game.WIDTH/tileSize;
		gridHeight = Game.HEIGHT/tileSize;
		
		bush0 = new Tile ("grass", false, Assets.bush[0]);
		bush1 = new Tile ("bush", true, Assets.bush[1]);
		bush2 = new Tile ("bush", true, Assets.bush[2]);
		bush3 = new Tile ("bush", true, Assets.bush[3]);	
		bush4 = new Tile ("bush", true, Assets.bush[4]);
		bush5 = new Tile ("bush", true, Assets.bush[5]);
		bush7 = new Tile ("bush", true, Assets.bush[6]);
		bush8 = new Tile ("bush", true, Assets.bush[7]);
		bush9 = new Tile ("bush", true, Assets.bush[8]);
		bushA = new Tile ("bush", true, Assets.bush[9]);
		bushB = new Tile ("bush", true, Assets.bush[10]);
		bushC = new Tile ("bush", true, Assets.bush[11]);
		bushD = new Tile ("bush", true, Assets.bush[12]);
		
		waterE = new Tile ("grass", true, Assets.water[0]);
		waterF = new Tile ("grass", true, Assets.water[1]);
		waterG = new Tile ("grass", true, Assets.water[2]);
		waterH = new Tile ("grass", true, Assets.water[3]);	
		waterI = new Tile ("grass", true, Assets.water[4]);
		waterJ = new Tile ("grass", true, Assets.water[5]);
		waterK = new Tile ("grass", true, Assets.water[6]);
		waterL = new Tile ("grass", true, Assets.water[7]);
		waterM = new Tile ("grass", true, Assets.water[8]);
		waterN = new Tile ("grass", true, Assets.water[9]);
		waterO = new Tile ("grass", true, Assets.water[10]);
		waterP = new Tile ("grass", true, Assets.water[11]);
		waterQ = new Tile ("grass", true, Assets.water[20]);
		waterT = new Tile ("grass", true, Assets.water[21]);
		waterW = new Tile ("grass", true, Assets.water[22]);
		waterX = new Tile ("grass", true, Assets.water[23]);
		waterY = new Tile ("bush", false, Assets.water[24]);
		waterZ = new Tile ("grass", true, Assets.water[25]);
		waterAA = new Tile ("grass", true, Assets.water[12]);
		waterBB = new Tile ("bush", false, Assets.water[13]);
		waterCC = new Tile ("grass", true, Assets.water[14]);
		waterDD = new Tile ("grass", true, Assets.water[15]);	
		waterEE = new Tile ("bush", false, Assets.water[16]);
		waterFF = new Tile ("grass", true, Assets.water[17]);
		waterGG = new Tile ("bush", false, Assets.water[18]);
		waterHH = new Tile ("grass", true, Assets.water[19]);
		
		dustII = new Tile ("grass", true, Assets.dust[0]);
		dustJJ = new Tile ("bush", false, Assets.dust[1]);
		dustKK = new Tile ("grass", true, Assets.dust[2]);
		dustLL = new Tile ("bush", false, Assets.dust[3]);
		dustMM = new Tile ("grass", true, Assets.dust[4]);
		dustNN = new Tile ("grass", true, Assets.dust[5]);
		dustOO = new Tile ("grass", true, Assets.dust[6]);
		dustPP = new Tile ("grass", true, Assets.dust[7]);
		dustQQ = new Tile ("grass", true, Assets.dust[8]);
		dustR = new Tile ("bush", false, Assets.dust[9]);
		dustRR = new Tile ("bush", false, Assets.dust[10]);
		dustS = new Tile ("bush", false, Assets.dust[11]);
		dustSS = new Tile ("grass", true, Assets.dust[12]);
		dustTT = new Tile ("bush", false, Assets.dust[13]);
		dustUU = new Tile ("bush", false, Assets.dust[14]);
		dustV = new Tile ("grass", true, Assets.dust[15]);	
		dustVV = new Tile ("grass", true, Assets.dust[16]);
		dustXX = new Tile ("bush", false, Assets.dust[17]);
		dustYY = new Tile ("grass", true, Assets.dust[18]);

		map = new Tile[gridHeight][gridWidth];
	}
	
	@Override
	public void init()
	{
		for (int i = 0; i < mapStr.length(); i++) {
			int x = i % gridWidth;
			int y = i / gridWidth;
			
			switch (Character.getNumericValue(mapStr.charAt(i))) {
				case 0:
					map[y][x] = bush0;
					break;
			
				case 1:
					map[y][x] = bush1;
					break;
				
				case 2:
					map[y][x] = bush2;
					break;
					
				case 3:
					map[y][x] = bush3;
					break;
					
				case 4:
					map[y][x] = bush4;
					break;
				case 5:
					map[y][x] = bush5;
					break;
				
				case 7:
					map[y][x] = bush7;
					break;
					
				case 8:
					map[y][x] = bush8;
					break;
					
				case 9:
					map[y][x] = bush9;
					break;		
			}
			
			switch (mapStr.charAt(i)) {
			case 'a':
				map[y][x] = bushA;
				break;
		
			case 'b':
				map[y][x] = bushB;
				break;
			
			case 'c':
				map[y][x] = bushC;
				break;
				
			case 'd':
				map[y][x] = bushD;
				break;
				
			case 'e':
				map[y][x] = waterE;
				break;
			case 'f':
				map[y][x] = waterF;
				break;
			
			case 'g':
				map[y][x] = waterG;
				break;
				
			case 'h':
				map[y][x] = waterH;
				break;
				
			case 'i':
				map[y][x] = waterI;
				break;	
			case 'j':
				map[y][x] = waterJ;
				break;
				
			case 'k':
				map[y][x] = waterK;
				break;
			case 'l':
				map[y][x] = waterL;
				break;
			
			case 'm':
				map[y][x] = waterM;
				break;
				
			case 'n':
				map[y][x] = waterN;
				break;
				
			case 'o':
				map[y][x] = waterO;
				break;	
				
			case 'p':
				map[y][x] = waterP;
				break;
				
			case 'q':
				map[y][x] = waterQ;
				break;
				
			case 't':
				map[y][x] = waterT;
				break;
				
			case 'w':
				map[y][x] = waterW;
				break;
				
			case 'x':
				map[y][x] = waterX;
				break;
				
			case 'y':
				map[y][x] = waterY;
				break;
				
			case 'z':
				map[y][x] = waterZ;
				break;
			
			case 'A':
				map[y][x] = waterAA;
				break;
				
			case 'B':
				map[y][x] = waterBB;
				break;
				
			case 'C':
				map[y][x] = waterCC;
				break;	
				
			case 'D':
				map[y][x] = waterDD;
				break;
				
			case 'E':
				map[y][x] = waterEE;
				break;
				
			case 'F':
				map[y][x] = waterFF;
				break;
				
			case 'G':
				map[y][x] = waterGG;
				break;	
				
			case 'H':
				map[y][x] = waterHH;
				break;
				
			case 'I':
				map[y][x] = dustII;
				break;
				
			case 'J':
				map[y][x] = dustJJ;
				break;
				
			case 'K':
				map[y][x] = dustKK;
				break;
				
			case 'L':
				map[y][x] = dustLL;
				break;
				
			case 'M':
				map[y][x] = dustMM;
				break;
				
			case 'N':
				map[y][x] = dustNN;
				break;
				
			case 'O':
				map[y][x] = dustOO;
				break;
			
			case 'P':
				map[y][x] = dustPP;
				break;
				
			case 'Q':
				map[y][x] = dustQQ;
				break;
				
			case 'r':
				map[y][x] = dustR;
				break;	
				
			case 'R':
				map[y][x] = dustRR;
				break;
				
			case 's':
				map[y][x] = dustS;
				break;
				
			case 'S':
				map[y][x] = dustSS;
				break;
				
			case 'T':
				map[y][x] = dustTT;
				break;	
				
			case 'U':
				map[y][x] = dustUU;
				break;
				
			case 'v':
				map[y][x] = dustV;
				break;
				
			case 'V':
				map[y][x] = dustVV;
				break;
				
			case 'X':
				map[y][x] = dustXX;
				break;
				
			case 'Y':
				map[y][x] = dustYY;
				break;	
		}
			
		}
	}
	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		renderMap(g);
	}
	
	public void renderMap(Graphics2D g) {
		for(int i = 0; i< gridHeight; i++) {
			for(int j = 0; j < gridWidth; j++) {
				g.setColor(Color.black);
				g.drawRect(j*tileSize, i*tileSize+100, tileSize, tileSize);
				if (map[i][j] != null) {
					Tile t = map[i][j];
					g.drawImage(t.getImage(), j*tileSize, i*tileSize+100, tileSize, tileSize, null);
				}
			}
		}
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
	public Tile getTile(int j, int i) {
		return map[j][i];
	}
	
	public int getTileSize()
	{
		return tileSize;
	}
	
	public int getGridWidth()
	{
		return gridWidth;
	}
	
	public int getGridHeight()
	{
		return gridHeight;
	}
	
}

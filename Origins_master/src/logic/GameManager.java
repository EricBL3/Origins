package logic;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

import enemies.EnemyFactory;
import gameEngine.AudioPlayer;
import gameEngine.Input;
import gameStates.GameState;
import gameStates.Play;
import mapStates.ForestState;
import mapStates.LagoonState;
import mapStates.Map;
import mapStates.TenochState;
import mapStates.TeotihuaState;

public class GameManager {
	//agregar objetos que se van a probar
	Map map;
	Random rand;
	EnemyFactory factory;
	ArrayList<GameObject> objects;
	Player player;
	Timer timer;
	boolean gameOver;
	int tileSze, mapNum, round, startTime, roundTime, enemyTime, score, counter;
	int[] enemySpawn = {0,0};
	private GameState gsm;
	
	public void init() {
		// inicializar objetos
		rand = new Random(System.currentTimeMillis());
		counter = 1;
		round = 1;
		score = 0;
		//each round lasts 20 seconds
		startTime = roundTime = 20;
		objects = new ArrayList<GameObject>();
		factory = new EnemyFactory();
		createMap();
		
		player = new Player(16*tileSze, 16*tileSze, map, this);
		objects.add(player);		
		gameOver = false;
		gsm = new Play();
		ActionListener countTime = new ActionListener() 
        {
            public void actionPerformed(ActionEvent evt)
            {
                
                setTimePassed(1);
                addScore(1);
                if((startTime-getTimePassed()) % enemyTime == 0)
                	addEnemy();
                
            }
        };
        timer = new Timer(1000 ,countTime);
        
        timer.start();
	}
	
	public void createMap()
	{
		mapNum = rand.nextInt(40)/10 +1;
		switch(mapNum)
		{
			case 1:
				map = new ForestState();
				AudioPlayer.get().playBackMusic("audios/round1_music.wav");
				break;
			case 2:
				map = new LagoonState();
				AudioPlayer.get().playBackMusic("audios/round2_music.wav");
				break;
			case 3:
				map = new TenochState();
				AudioPlayer.get().playBackMusic("audios/round4_music.wav");
				break;
			case 4:
				map = new TeotihuaState();
				AudioPlayer.get().playBackMusic("audios/round5_music.wav");
				break;
		}
		tileSze = map.getTileSize();
		//add enemies
		int i = 0;
		AudioPlayer.get().setMusicVolume(0.7f);
		switch(round)
		{
			case 1: case 2: case 3: case 4: case 5:
				i = 2;
				enemyTime = 6-round;	
				break;
			case 6: case 7: case 8: case 9: case 10:
				i = 3;
				enemyTime = 11-round;
				break;
			case 11: case 12: case 13: case 14: case 15:
				i = 4;
				enemyTime = 16-round;
				break;
			case 16: case 17: case 18: case 19: case 20:
				i = 5;
				enemyTime = 21-round;
				break;
			default:
				i = 7;
				enemyTime = 28-round;
				break;
		}
		
		if(enemyTime < 1)
			enemyTime = 1;
		
		for(; i > 0; i--)
		{
			addEnemy();
			
		}
		
	}
	
	//esta funcion escoge aleatoriamente uno de 8 posibles spawn points para los enemigos
	public void setEnemySpawn()
	{
		
		int num = rand.nextInt(8)+1;
		switch(num)
		{
			case 1:
				enemySpawn[0] = 1;
				enemySpawn[1] = 1;
				break;
			case 2:
				enemySpawn[0] = 30;
				enemySpawn[1] = 1;
				break;
			case 3:
				enemySpawn[0] = 15;
				enemySpawn[1] = 1;
				break;
			case 4: 
				enemySpawn[0] = 15;
				enemySpawn[1] = 22;
				break;
			case 5:
				enemySpawn[0] = 1;
				enemySpawn[1] = 10;
				break;
			case 6:
				enemySpawn[0] = 30;
				enemySpawn[1] = 10;
				break;
			case 7:
				enemySpawn[0] = 1;
				enemySpawn[1] = 22;
				break;
			case 8:
				enemySpawn[0] = 30;
				enemySpawn[1] = 22;
				break;				
		}
	}
	
	public void nextRound()
	{
		if(roundTime == -3)
		{
			addScore(10*round);
			
			round++;
			objects.clear();
			createMap();
			if(round % 5 == 0 && player.getLives() < 3)
				player.setLives(player.getLives()+1);
			player.setX(player.getStartX());
			player.setY(player.getStartY());
			player.setMap(map);
			player.setDead(false);
			objects.add(player);
			roundTime = startTime;
		}
		
	}
	
	public void addScore(int val)
	{
		score += val;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public int getEnemyTime()
	{
		return enemyTime;
	}
	
	public int getRound()
	{
		return round;
	}
	
	public Timer getTimer()
	{
		return timer;
	}
	
	public void setTimePassed(int time)
	{
		roundTime -= time;
	}
	
	public int getTimePassed()
	{
		return roundTime;
	}
	
	public void addEnemy()
	{
		setEnemySpawn();
		objects.add(factory.createEnemy("esbelto", enemySpawn[0]*tileSze, enemySpawn[1]*tileSze, map));
	}
	
	public void update()
	{
		gsm.Update(this);
		
		//Music volume control
		counter++;
		if (counter % 45 == 0) {
			if (Input.get().isKeyPressed(KeyEvent.VK_1))
				AudioPlayer.get().setMusicVolume(AudioPlayer.get().getMusicVolume()-.1f);
			if (Input.get().isKeyPressed(KeyEvent.VK_2))
				AudioPlayer.get().setMusicVolume(AudioPlayer.get().getMusicVolume()+.1f);
		}
	}
	
	public void render(Graphics2D g)
	{
		gsm.render(g, this);
	}
	
	public Map getMap()
	{
		return map;
	}
	
	public void setMap(Map newMap)
	{
		map = newMap;
	}
	
	public ArrayList<GameObject> getObjects() {
		return objects;
	}

	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean val) {
		this.gameOver = val;
	}
	
	public int getTileSze() {
		return tileSze;
	}

	public void setTileSze(int tileSze) {
		this.tileSze = tileSze;
	}

	public GameState getGsm() {
		return gsm;
	}

	public void setGsm(GameState gsm) {
		this.gsm = gsm;
	}
	
	public boolean getGameOver()
	{
		return gameOver;
	}

}

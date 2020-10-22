package gameEngine;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer {
private static AudioPlayer instance;
	
	private Map<String, Clip> audios;
	private String currentMusic;
	private float musicVolume;
	private float effectsVolume;
	
	public static AudioPlayer get() {
		if (instance == null) {
			instance = new AudioPlayer();
		}
		return instance;
	}
	
	private AudioPlayer() {
		audios = new HashMap<>();
		
		musicVolume = 1.0f;
		effectsVolume = 1.0f;
		currentMusic = null;
	}
	
	public void playBackMusic(String audio) {
		
		Clip soundClip = getSoundClip(audio);
		soundClip.setFramePosition(0);
		setVolume(soundClip, musicVolume);
		
		if (currentMusic != null) {
			audios.get(currentMusic).stop();
		}
		
		currentMusic = audio;
		
		soundClip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void restartBackMusic() {
		Clip soundClip = getSoundClip(currentMusic);
		setVolume(soundClip, effectsVolume);
		soundClip.start();
	}
	
	public void pauseBackMusic()
	{
		audios.get(currentMusic).stop();
	}
	
	public void stopBackMusic() {
		
		if (currentMusic != null) {
			audios.get(currentMusic).stop();
			currentMusic = null;
		}
	}

	
	public void playEffectSound(String audio) {
		Clip soundClip = getSoundClip(audio);
		soundClip.setFramePosition(0);
		setVolume(soundClip, effectsVolume);
		
		soundClip.start();
	}
	
	private void setVolume(Clip soundClip, float volume) {
		FloatControl gainControl = (FloatControl)soundClip.getControl(FloatControl.Type.MASTER_GAIN);
		float range = gainControl.getMaximum() - gainControl.getMinimum();
		float gain = range*volume + gainControl.getMinimum();
		gainControl.setValue(gain);
	}
	
	public void setMusicVolume(float volume) {
		
		this.musicVolume = volume;
		
		if (this.musicVolume > 1.0f) this.musicVolume = 1.0f;
		if (this.musicVolume < 0f) this.musicVolume = 0f;
		
		if (currentMusic != null) {
			setVolume(audios.get(currentMusic), this.musicVolume);
		}
	}
	
	public void setEffectsVolume(float volume) {
		this.effectsVolume = volume;
	}
	
	public float getMusicVolume() {
		return this.musicVolume;
	}
	
	public float getEffectsVolume() {
		return this.effectsVolume;
	}
	
	public String getCurrent()
	{
		return currentMusic;
	}
	
	private Clip getSoundClip(String name) {
		if (audios.containsKey(name)) {
			return audios.get(name);
		}
		Clip clip = null;
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		AudioInputStream sample = null;
		try {
			sample = AudioSystem.getAudioInputStream(new File(name));
			//sample = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResource("./"+name));
			} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			clip.open(sample);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		audios.put(name, clip);
		
		
		return clip;
	}

}
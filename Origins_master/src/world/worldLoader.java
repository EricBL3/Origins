package world;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

public class worldLoader {
	public static String loadFileAsString(String path)
	{
		StringBuilder builder = new StringBuilder();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null)
				builder.append(line);
			br.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return builder.toString();
	}
	
	public static BufferedImage loadImage(String path)
	{
		try {
			//return ImageIO.read(worldLoader.class.getResource(path));
			return ImageIO.read(new FileInputStream(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}

}

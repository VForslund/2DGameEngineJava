package com.victor.game;

import com.sun.glass.events.KeyEvent;
import com.victor.engine.AbstractGame;
import com.victor.engine.GameContainer;
import com.victor.engine.Renderer;
import com.victor.engine.audio.SoundClip;
import com.victor.engine.gfx.Image;
import com.victor.engine.gfx.ImageTile;

public class GameManager extends AbstractGame{
	
	private ImageTile image;
	private Image myimage;
	private SoundClip clip;
	float temp = 0;
	
	 public GameManager() {
		image = new ImageTile("/explotionTile.png", 8 , 8);
		myimage = new Image("/test.png");
		clip = new SoundClip("/audio/applause_y.wav");
		clip.setVolume(-10);
	}

	@Override
	public void update(GameContainer gc, float dt) {
		if(gc.getInput().isKeyDown(KeyEvent.VK_A)) {
			clip.play();
		}
		temp += dt * 20;
		if(temp > 4) {
			temp = 0;
		}
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		
		r.drawImage(myimage, gc.getInput().getMouseX() - 16, gc.getInput().getMouseY() - 16);
		r.drawImageTile(image, gc.getInput().getMouseX() - 24, gc.getInput().getMouseY() - 24, (int)temp, 0);	
	}
	
	public static void main(String args[]) {
		
		GameContainer gc = new GameContainer(new GameManager());
		gc.start();
	}
}

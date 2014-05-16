package com.me;



import com.badlogic.gdx.Game;
import com.me.screens.GameScreen;
import com.me.screens.MenuScreen;

public class BeatBlaster extends Game {
	
	
	@Override
	public void create() {
		setScreen(new MenuScreen(this));
		//setScreen(new GameScreen(this));
	}
	
	public void dispose () {
		super.dispose();
		getScreen().dispose();
	}
	
}

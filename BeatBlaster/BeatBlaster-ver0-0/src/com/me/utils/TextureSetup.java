package com.me.utils;

import com.badlogic.gdx.tools.imagepacker.TexturePacker2;

public class TextureSetup {
	
	public static void main(String[] args) {
		//GameScreen textures
        TexturePacker2.process("/Users/SamaHell/ENSISA/Java-workspace/BeatBlaster/BeatBlaster-ver0-0-desktop/bin/data/textures",
        					   "/Users/SamaHell/ENSISA/Java-workspace/BeatBlaster/BeatBlaster-ver0-0-desktop/bin/data/textures",
        						"textures.pack");
        //MenuScreen textures
        TexturePacker2.process("/Users/SamaHell/ENSISA/Java-workspace/BeatBlaster/BeatBlaster-ver0-0-desktop/bin/Menu/textures",
				   "/Users/SamaHell/ENSISA/Java-workspace/BeatBlaster/BeatBlaster-ver0-0-desktop/bin/Menu/textures",
					"textures.pack");
        System.out.println("Done");
    }

}

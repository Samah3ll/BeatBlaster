package com.me.utils;

import com.badlogic.gdx.tools.imagepacker.TexturePacker2;

public class TextureSetup {
	
	public static void main(String[] args) {
		//GameScreen textures
		final String path = System.getProperty("user.dir");
        TexturePacker2.process(path + "-desktop/bin/data/textures",
        					   path + "-desktop/bin/data/textures",
        						"textures.pack");
        //MenuScreen textures
        TexturePacker2.process(path + "-desktop/bin/Menu/textures",
				    			path + "-desktop/bin/Menu/textures",
					"textures.pack");
        System.out.println("Done");
    }

}

package com.me.model;


import com.badlogic.gdx.math.Vector2;

/**
 * Plateforme de base, juste une classe impl�mentable du type Plateform.
 * @author SamaHell
 *
 */
public class BasicPlateform extends Plateform {
	

	public BasicPlateform(int x, int y, int size) {
		super(x, y, size);
	}
	
	public BasicPlateform(Vector2 pos, int size) {
		super(pos, size);
		
	}
	
	

}

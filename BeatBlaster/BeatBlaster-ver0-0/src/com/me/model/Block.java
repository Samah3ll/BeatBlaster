package com.me.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * 
 * @author SamaHell
 * Classe abstraite qui d�finit le comportement de base d'un block.
 * La taille des block est fix�e (1f).
 * Un block a ue position (Vector2) et des bounds (Rectangle).
 */
public abstract class Block {
	
	static final float SIZE = 1f;
	
	Vector2 	position = new Vector2();
	Rectangle 	bounds = new Rectangle();
	
	/**
	 * Constructeur valu� qui prend en param�tre un Vector2.
	 * @param pos : la position du block (origine du rep�re en bas � quache) avec un Vector2.
	 */
	public Block(Vector2 pos) {
		this.position = pos;
		this.bounds.setX(pos.x);
		this.bounds.setY(pos.y);
		//a utiliser dans la classe concrete
		//this.bounds.width = SIZE;
		//this.bounds.height = SIZE;
	}
	
	/**
	 * Constructeur valu� qui prend en param�tre 2 int (utilise les int pour cr�er un Vector2).
	 * @param x : abscisse du block
	 * @param y : ordon�e du block
	 */
	public Block(int x, int y) {
		Vector2 pos = new Vector2(x, y);
		this.position = pos;
		this.bounds.setX(pos.x);
		this.bounds.setY(pos.y);
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public Vector2 getPosition() {
		return position;
	}
	
	public static float getSize() {
		return SIZE;
	}

}

package com.me.model;

import com.badlogic.gdx.math.Vector2;

/**
 * Block de base, premi�re classe impl�mentable du type block.
 * @author SamaHell
 *
 */
public class BasicBlock extends Block {
	

	public BasicBlock(Vector2 pos) {
		super(pos);
		this.bounds.width = SIZE;
		this.bounds.height = SIZE;
	}
	
	public BasicBlock(int x, int y) {
		super(x, y);
		this.bounds.width = SIZE;
		this.bounds.height = SIZE;
	}

}

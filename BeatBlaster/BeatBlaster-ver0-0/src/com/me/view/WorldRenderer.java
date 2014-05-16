package com.me.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.me.model.Block;
import com.me.model.Plateform;
import com.me.model.Runner;
import com.me.model.Runner.State;
import com.me.model.World;

public class WorldRenderer {
	
	private static final float CAMERA_WIDTH = 20f;
	private static final float CAMERA_HEIGHT = 14f;
	private static final float RUNNING_FRAME_DURATION = 0.06f;
	
	private FPSLogger fps;
	
	private World world;
	Runner runner;
	private OrthographicCamera cam;
	
	private SpriteBatch spriteBatch;
    private int width;
    private int height;
    private float ppuX;
    private float ppuY;
    
    //Block texture
    private TextureRegion blockTexture;
    
    
    //Runner textures
    private TextureRegion runnerIdleLeft;
    private TextureRegion runnerIdleRight;
    private TextureRegion runnerFrame;
    private TextureRegion runnerJumpLeft;
    private TextureRegion runnerFallLeft;
    private TextureRegion runnerJumpRight;
    private TextureRegion runnerFallRight;
    
    //Runner Animations
    private Animation walkLeftAnimation;
    private Animation walkRightAnimation;
    
	public WorldRenderer(World w) {
		this.world = w;
		this.runner =  world.getRunner();
		/*
		this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		this.cam.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
		this.cam.update();
		*/
		this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
	    this.cam.setToOrtho(false,CAMERA_WIDTH,CAMERA_HEIGHT);
	    this.cam.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
	    this.cam.update();
	    	    
		spriteBatch = new SpriteBatch();
		loadTextures();
		fps = new FPSLogger();
	}


	public void render() {
		moveCamera(runner.getPosition().x, CAMERA_HEIGHT / 2);
	    //spriteBatch.setProjectionMatrix(cam.combined);
		spriteBatch.begin();
        	drawBlocks();
        	drawplateforms();
        	drawRunner();
        spriteBatch.end();
        fps.log();
		
	}
	
	private void loadTextures() {
		TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("data/textures/textures.pack"));
		runnerIdleLeft = atlas.findRegion("Runner01");
		runnerIdleRight = new TextureRegion(runnerIdleLeft);
		runnerIdleRight.flip(true, false);
		blockTexture = atlas.findRegion("Block");
		TextureRegion[] walkLeftFrames = new TextureRegion[5];
		for (int i = 0; i < 5; i++) {
			walkLeftFrames[i] = atlas.findRegion("Runner0" + (i + 2));
		}
		walkLeftAnimation = new Animation(RUNNING_FRAME_DURATION, walkLeftFrames);

		TextureRegion[] walkRightFrames = new TextureRegion[5];

		for (int i = 0; i < 5; i++) {
			walkRightFrames[i] = new TextureRegion(walkLeftFrames[i]);
			walkRightFrames[i].flip(true, false);
		}
		walkRightAnimation = new Animation(RUNNING_FRAME_DURATION, walkRightFrames);
		
		runnerJumpLeft = atlas.findRegion("Runner01");
		runnerJumpRight = new TextureRegion(runnerJumpLeft);
		runnerJumpRight.flip(true, false);
		runnerFallLeft = atlas.findRegion("Runner04");
		runnerFallRight = new TextureRegion(runnerFallLeft);
		runnerFallRight.flip(true, false);
	}

	
	private void drawBlocks() {
		for (Block block : world.getLevel().getBlocks()) {
            spriteBatch.draw(blockTexture, block.getPosition().x * ppuX, block.getPosition().y * ppuY, Block.getSize() * ppuX, Block.getSize() * ppuY);
        }
		
	}
	
	private void drawplateforms() {
		for(Plateform plateform : world.getLevel().getPlateforms()) {
			for (int i = 0; i < plateform.getSize(); i++) {
				spriteBatch.draw(blockTexture, (plateform.getPosition().x + i) * ppuX, plateform.getPosition().y* ppuY, Block.getSize() * ppuX, Block.getSize() * ppuY);
	        }
		}
		
		
	}
	
	 private void drawRunner() {
			runnerFrame = runner.isFacingLeft() ? runnerIdleLeft : runnerIdleRight;
			if(runner.getState().equals(State.WALKING)) {
				runnerFrame = runner.isFacingLeft() ? walkLeftAnimation.getKeyFrame(runner.getStateTime(), true) : walkRightAnimation.getKeyFrame(runner.getStateTime(), true);
			} else if (runner.getState().equals(State.JUMPING)) {
				if (runner.getVelocity().y > 0) {
					runnerFrame = runner.isFacingLeft() ? runnerJumpLeft : runnerJumpRight;
				} else {
					runnerFrame = runner.isFacingLeft() ? runnerFallLeft : runnerFallRight;
				}
			}
			spriteBatch.draw(runnerFrame, runner.getPosition().x * ppuX, runner.getPosition().y * ppuY, Runner.getSize() * ppuX, Runner.getSize() * ppuY);
		}
	 
	 
	 public void moveCamera(float x,float y){
		 if ((runner.getPosition().x > CAMERA_WIDTH / 2)) {
			cam.position.set(x, y, 0);
	        cam.update();
	    }

	}


	public void setSize (int w, int h) {
        this.width = w;
        this.height = h;
        ppuX = (float)width / CAMERA_WIDTH;
        ppuY = (float)height / CAMERA_HEIGHT;
    }
	

}

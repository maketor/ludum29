package org.castelodelego.ld29;

import java.util.Random;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Pool;


/**
 * Contains all the statically accessible global variables.
 * 
 * @author caranha
 *
 */
public class Globals {

	public static final Random dice = new Random();
    public static final Pool<Prop> propPool = new Pool<Prop>() {
    @Override
    protected Prop newObject() {
        return new Prop();
    }
    };
	public static InputMultiplexer multiplexer;	
	
	public static Preferences scoreloader;
	public static LogOverlay log;
	public static AssetManager manager;
	public static AnimationManager animman;
	public static SpriteBatch batch;
	public static BitmapFont debugtext;
	
	public static GameContext gc;
	public static Level[] levellist;
	
	public static Music gamesong;
	
	static void init()
	{
		debugtext = new BitmapFont();		
		batch = new SpriteBatch();
		animman = new AnimationManager();
		manager = new AssetManager();
		log = new LogOverlay();
		multiplexer = new InputMultiplexer();
		
		
		// FIXME: Make level loading from text file
		gc = new GameContext(8);
		levellist = new Level[gc.getmaxlevel()];
		int i = 0;
		levellist[i++] = new Level("levels/tutorial1","levels/tutorial2",0,Color.WHITE);
		levellist[i++] = new Level("levels/city","levels/farm",4,Color.WHITE);
		levellist[i++] = new Level("levels/crone","levels/maiden",8,Color.WHITE);
		levellist[i++] = new Level("levels/presentation","levels/study",12,Color.WHITE);
		levellist[i++] = new Level("levels/iceberg1","levels/iceberg2",10,Color.WHITE);
		levellist[i++] = new Level("levels/tablet1","levels/tablet2",16,Color.WHITE);
		levellist[i++] = new Level("levels/science1","levels/science2",8,Color.WHITE);
		levellist[i++] = new Level("levels/thankyou1","levels/thankyou2",2,Color.WHITE);
	}		
	
	static void init_music()
	{
		if (dice.nextBoolean())
		{
			gamesong = manager.get("music/music1.ogg",Music.class);
		}
		else
		{
			gamesong = manager.get("music/music2.ogg",Music.class);
		}
	}	
}

package org.tetawex.tms.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.kotcrab.vis.ui.VisUI;
import org.tetawex.tms.util.MusicPlayer;

public class TMSGame extends Game
{
	private GameStateManager gameStateManager;
	private AnimationManager animationManager;
	private AssetManager assetManager;
	private TemplateManager templateManager;

    public MusicPlayer getMusicPlayer() {
        return musicPlayer;
    }

    private MusicPlayer musicPlayer;

	public TemplateManager getTemplateManager() {
		return templateManager;
	}
	public GameStateManager getGameStateManager()
	{
		return gameStateManager;
	}
	public AssetManager getAssetManager()
	{
		return assetManager;
	}
	public AnimationManager getAnimationManager(){ return animationManager ;}
	@Override
	public void create ()
	{
		assetManager=new AssetManager();
		assetManager.load("atlas.atlas", TextureAtlas.class);
		assetManager.load("font.fnt", BitmapFont.class);

		assetManager.load("sounds/anvil.ogg", Sound.class);
		assetManager.load("music/game_main.ogg", Sound.class);
		assetManager.finishLoading();

		VisUI.load();

		animationManager=new AnimationManager(this);
		templateManager=new TemplateManager(this);
		gameStateManager=new GameStateManager(this);
		musicPlayer=new MusicPlayer();

	}

	@Override
	public void render ()
	{
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gameStateManager.getCurrentScreen().render(Gdx.graphics.getDeltaTime()*50);
	}
	@Override
	public void resize(int width, int height) {
		gameStateManager.getCurrentScreen().resize(width,height);
	}
	@Override
	public void dispose ()
	{
		assetManager.dispose();
		VisUI.dispose();
	}
}

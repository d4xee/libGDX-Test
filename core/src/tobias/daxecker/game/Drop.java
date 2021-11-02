package tobias.daxecker.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Drop extends Game {

    public SpriteBatch batch;
    public BitmapFont font;

    public PersistentData data;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        data  = DataManager.getInstance().getData();
        this.setScreen(new MainMenuScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}

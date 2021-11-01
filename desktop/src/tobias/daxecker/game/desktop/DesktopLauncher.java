package tobias.daxecker.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import tobias.daxecker.game.Drop;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Drop";
		config.width = 800;
		config.height = 480;
		config.addIcon("drop_icon.png", Files.FileType.Internal);
		config.fullscreen = false;
		new LwjglApplication(new Drop(), config);
	}
}

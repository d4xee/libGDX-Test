package tobias.daxecker.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

import java.io.File;
import java.io.IOException;

public class DataManager {
    private static final DataManager INSTANCE = new DataManager();

    private final String name = "persistent.json";

    private final FileHandle file = Gdx.files.local(name);
    private final Json json = new Json();

    private DataManager() {}

    public static DataManager getInstance() {
        return INSTANCE;
    }

    public PersistentData getData() {
        if (!file.exists()) {
            createFile();
            writeData(new PersistentData());
        }

        return json.fromJson(PersistentData.class, file);
    }

    public void writeData(PersistentData data) {
        file.writeString(json.toJson(data), false);
    }

    private void createFile() {
        try {
            File file = new File(name);

            if (file.createNewFile()) {
                Gdx.app.log("DataManager", "Created " + name + "!");
            }
            else {
                Gdx.app.log("DataManager", "Failed to create " + name + "!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

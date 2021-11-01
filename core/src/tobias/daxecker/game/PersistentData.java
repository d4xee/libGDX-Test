package tobias.daxecker.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

import java.io.File;
import java.io.IOException;

public class PersistentData {
    int highscore;

    private static final FileHandle file = Gdx.files.local("persistent.json");
    private static final Json json = new Json();

    private PersistentData() {
    }

    private static void createFile() {
        try {
            File file = new File("persistent.json");
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static PersistentData readPersistentData() {
        String text = "{highscore:0}";

        if (!file.exists()) {
            createFile();
            file.writeString(text, false);
        }

        System.out.println(json.prettyPrint(file.readString()));

        return json.fromJson(PersistentData.class, file.readString());
    }

    public static PersistentData getPersistentData() {
        return readPersistentData();
    }

    public static void writePersistentData(PersistentData data) {
        file.writeString(json.toJson(data), false);
    }
}

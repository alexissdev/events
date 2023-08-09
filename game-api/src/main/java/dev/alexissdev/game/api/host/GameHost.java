package dev.alexissdev.game.api.host;

import java.util.Locale;
import team.unnamed.pixel.storage.model.Model;

public class GameHost
        implements Model {

    public static final GameHost CONSOLE_HOST = of("console", "console".toUpperCase(Locale.ROOT));

    protected final String id;
    protected final String displayName;

    protected GameHost(String id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    /**
     * Create a new GameHost object with the given id and displayName.
     *
     * @param id          The unique identifier for the game host.
     * @param displayName The name of the game host.
     * @return A new GameHost object.
     */
    public static GameHost of(
            String id,
            String displayName
    ) {
        return new GameHost(id, displayName);
    }

    @Override
    public String getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }
}

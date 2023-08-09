package dev.alexissdev.game.api.configuration;

import org.bson.Document;
import team.unnamed.pixel.storage.codec.ModelReader;
import team.unnamed.pixel.storage.codec.ModelWriter;
import team.unnamed.pixel.storage.mongo.codec.DocumentCodec;
import team.unnamed.pixel.storage.mongo.codec.DocumentWriter;

public class GameConfiguration implements DocumentCodec {

    protected int minPlayers;
    protected int maxPlayers;
    protected int waitingTime;

    protected GameConfiguration(int minPlayers, int maxPlayers, int waitingTime) {
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.waitingTime = waitingTime;
    }

    /**
     * Creates a new GameConfiguration object.
     * @param minPlayers the minimum amount of players required to start this game.
     * @param maxPlayers the maximum amount of players allowed in this game.
     * @param waitingTime the amount of time in seconds that players have to wait before the game starts.
     * @return a new GameConfiguration object.
     */

    public static GameConfiguration of(int minPlayers, int maxPlayers, int waitingTime) {
        return new GameConfiguration(minPlayers, maxPlayers, waitingTime);
    }

    /**
     * Creates a new GameConfiguration object.
     * @param minPlayers the minimum amount of players required to start this game.
     * @param maxPlayers the maximum amount of players allowed in this game.
     * @return a new GameConfiguration object.
     */

    public static GameConfiguration create(int minPlayers, int maxPlayers) {
        return new GameConfiguration(minPlayers, maxPlayers, 30);
    }

    public static GameConfiguration read(ModelReader<Document> reader) {
        return of(
                reader.readInt("min_players"),
                reader.readInt("max_players"),
                reader.readInt("waiting_time")
        );
    }


    /**
     * Get the minimum amount of players required to start this game.
     * @return the minimum amount of players required to start this game.
     */

    public int getMinPlayers() {
        return minPlayers;
    }

    /**
     * Set the minimum amount of players required to start this game.
     * @param minPlayers the minimum amount of players required to start this game.
     */

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    /**
     * Get the maximum amount of players allowed in this game.
     * @return the maximum amount of players allowed in this game.
     */

    public int getMaxPlayers() {
        return maxPlayers;
    }

    /**
     * Set the maximum amount of players allowed in this game.
     * @param maxPlayers the maximum amount of players allowed in this game.
     */

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    /**
     * Get the amount of time in seconds that players have to wait before the game starts.
     * @return the amount of time in seconds that players have to wait before the game starts.
     */

    public int getWaitingTime() {
        return waitingTime;
    }

    /**
     * Set the amount of time in seconds that players have to wait before the game starts.
     * @param waitingTime the amount of time in seconds that players have to wait before the game starts.
     */

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    /**
     * Serialize this object into a Document.
     * @return a Document containing the serialized data.
     */

    protected ModelWriter<Document> template() {
        return DocumentWriter.create()
                .write("min_players", minPlayers)
                .write("max_players", maxPlayers)
                .write("waiting_time", waitingTime);
    }


    @Override
    public Document serialize() {
        return template()
                .end();
    }
}

package dev.alexissdev.game.api;

import dev.alexissdev.game.api.configuration.GameConfiguration;
import dev.alexissdev.game.api.host.GameHost;
import dev.alexissdev.game.api.status.GameStatus;
import org.jetbrains.annotations.NotNull;
import team.unnamed.pixel.storage.model.Model;
import team.unnamed.pixel.storage.mongo.codec.DocumentCodec;

public interface GameTemplate extends Model, DocumentCodec {

    /**
     * Get the configuration of the game
     * @return The configuration of the game
     */
    
    GameConfiguration getConfiguration();

    /**
     * Get the host of the game
     * @return The host of the game
     */

    GameHost getHost();

    /**
     * Set the host of the game
     * @param host The host of the game
     */

    void setHost(@NotNull GameHost host);

    /**
     * Get the status of the game
     * @return The status of the game
     */
    
    GameStatus getStatus();

    /**
     * Set the status of the game
     * @param status The status of the game
     */
    
    void setStatus(@NotNull GameStatus status);

}

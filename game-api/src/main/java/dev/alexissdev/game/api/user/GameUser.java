package dev.alexissdev.game.api.user;

import dev.alexissdev.events.api.user.backup.UserBackup;
import dev.alexissdev.game.api.user.status.UserStatus;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import team.unnamed.pixel.storage.model.Model;

public class GameUser implements Model {

    protected final String id;
    protected final UserBackup backup;
    protected UserStatus status;

    protected GameUser(String id, UserBackup backup, UserStatus status) {
        this.id = id;
        this.backup = backup;
        this.status = status;
    }

    /**
     * Create a new GameUser object with the given id and status.
     *
     * @param id     The user's id.
     * @param status The status of the user.
     * @return A new GameUser object.
     */
    public static GameUser create(
            String id,
            UserStatus status,
            UserBackup userBackup
    ) {
        return new GameUser(id, userBackup, status);
    }

    public static GameUser of(Player player) {
        return create(
                player.getUniqueId().toString(),
                UserStatus.ALIVE,
                UserBackup.create(player)
        );
    }

    @Override
    public String getId() {
        return id;
    }

    /**
     * This function returns the status of the user.
     *
     * @return The status of the user.
     */
    public @NotNull UserStatus getStatus() {
        return status;
    }

    /**
     * This function sets the status of the user to the status passed in.
     *
     * @param status The status of the user.
     */

    public void setStatus(@NotNull UserStatus status) {
        this.status = status;
    }

    /**
     * This function returns the userBackup.
     *
     * @return The userBackup object.
     */
    public UserBackup getUserBackup() {
        return backup;
    }

    /**
     * Converts a Player object to a Bukkit Player object.
     *
     * @return A Player object
     */
    public Player toBukkitPlayer() {
        return Bukkit.getPlayer(
                UUID.fromString(
                        id
                )
        );
    }

}

package dev.alexissdev.game.api.user.registry;

import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/**
 * This class is for keeping track of which game the player is currently in.
 *
 * @author AlexisDev
 */

public class UserRegistry {

    private static final Map<String, String> USER_REGISTRY_MAP
            = new HashMap<>();

    /**
     * Given a userId, return the gameId that the user is currently playing.
     *
     * @param userId The userId of the user who is trying to join the game.
     * @return The gameId associated with the userId
     */
    public static String getGameIdByUserId(@NotNull String userId) {
        return USER_REGISTRY_MAP.getOrDefault(userId, null);
    }

    /**
     * This function registers a user to a game.
     *
     * @param userId The user's unique identifier.
     * @param gameId The gameId of the game that the user is registering for.
     */
    public static void register(@NotNull String userId, @NotNull  String gameId) {
        USER_REGISTRY_MAP.put(userId, gameId);
    }

    /**
     * Remove the user from the registry.
     *
     * @param userId The userId of the user to invalidate.
     * @return The userId is being removed from the userRegistryMap.
     */
    public static String invalidate(@NotNull String userId) {
        return USER_REGISTRY_MAP.remove(userId);
    }

    /**
     * Clear the map of all users.
     */
    public static void invalidateAll() {
        USER_REGISTRY_MAP.clear();
    }
}
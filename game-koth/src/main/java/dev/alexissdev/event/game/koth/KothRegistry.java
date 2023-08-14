package dev.alexissdev.event.game.koth;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class KothRegistry {

  private static final Map<UUID, String> KOTH_ENTER_MAP = new HashMap<>();

  private String lastActiveKoth = null;


  /**
   * It returns the name of the KOTH that the player is currently in
   *
   * @param uuid The UUID of the player
   * @return The KOTH name that the player is entering.
   */
  public String getEnterKoth(@NotNull UUID uuid) {
    return KOTH_ENTER_MAP.get(uuid);
  }

  /**
   * "When a player enters a KOTH, store their UUID and the KOTH ID in a map."
   * <p>
   * Now, let's look at the `onPlayerMove` function
   *
   * @param playerId The UUID of the player who entered the KOTH
   * @param kothId   The id of the koth.
   */
  public void registerEnterKoth(@NotNull UUID playerId, @NotNull String kothId) {
    KOTH_ENTER_MAP.put(playerId, kothId);
  }

  /**
   * Removes the player from the KOTH enter map.
   *
   * @param playerId The UUID of the player who is trying to enter the KOTH.
   */
  public void invalidateKothEnter(@NotNull UUID playerId) {
    KOTH_ENTER_MAP.remove(playerId);
  }

  /**
   * If the player hasn't registered for a KOTH, register them for the KOTH
   *
   * @param playerId The UUID of the player
   * @param kothId   The id of the koth.
   */
  public boolean registerIfNotExistsEnterKoth(@NotNull UUID playerId, @NotNull String kothId) {
    if (!KOTH_ENTER_MAP.containsKey(playerId)) {
      registerEnterKoth(playerId, kothId);

      return true;
    }

    return false;
  }

  /**
   * Get the last active KOTH
   *
   * @return The last active KOTH
   */

  public @Nullable String getLastActiveKoth() {
    return this.lastActiveKoth;
  }

  /**
   * Set the last active KOTH
   *
   * @param koth The last active KOTH
   */

  public void setLastActiveKoth(@Nullable String koth) {
    this.lastActiveKoth = koth;
  }

}
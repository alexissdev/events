package dev.alexissdev.game.api.region.wand;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

public class RegionWandRegistry {

  private static final Map<UUID, RegionWandContainer> WAND_REGISTRY_MAP
      = new HashMap<>();

  /**
   * It takes a player's UUID, a location, and a wand location, and then it either creates a new
   * wand container for the player or it updates the player's existing wand container with the new
   * location
   *
   * @param playerId     The UUID of the player who is using the wand.
   * @param location     The location of the block that the player clicked on.
   * @param wandLocation This is the location of the wand.
   */
  public static void registry(
      @NotNull UUID playerId,
      @NotNull Location location,
      @NotNull WandLocation wandLocation
  ) {
    RegionWandContainer wandContainer = WAND_REGISTRY_MAP.get(playerId);
    if (wandContainer == null) {
      wandContainer = RegionWandContainer.create();
    }

    switch (wandLocation) {
      case ONE:
        wandContainer.setOneLocation(location);
        break;
      case SECOND:
        wandContainer.setSecondLocation(location);
        break;
    }

    WAND_REGISTRY_MAP.put(playerId, wandContainer);
  }

  /**
   * Get the RegionWandContainer for the player with the given UUID.
   *
   * @param playerId The UUID of the player who owns the wand.
   * @return The RegionWandContainer object that is associated with the playerId.
   */
  public static RegionWandContainer getWandContainer(@NotNull UUID playerId) {
    return WAND_REGISTRY_MAP.getOrDefault(playerId, null);
  }

  /**
   * It removes the player's wand from the registry
   *
   * @param playerId The UUID of the player to invalidate.
   */
  public static void invalidate(@NotNull UUID playerId) {
    WAND_REGISTRY_MAP.remove(playerId);
  }

  public enum WandLocation {
    ONE,
    SECOND
  }
}

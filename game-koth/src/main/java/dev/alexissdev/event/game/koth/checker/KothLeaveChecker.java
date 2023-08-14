package dev.alexissdev.event.game.koth.checker;

import dev.alexissdev.event.game.koth.game.GameKoth;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface KothLeaveChecker {

  /**
   * Check if the player left the koth
   *
   * @param player the player
   * @param koth   the koth
   */

  void check(
      @NotNull Player player,
      @NotNull GameKoth koth
  );

}

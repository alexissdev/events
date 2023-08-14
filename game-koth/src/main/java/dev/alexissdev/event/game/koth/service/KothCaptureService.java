package dev.alexissdev.event.game.koth.service;

import dev.alexissdev.event.game.koth.game.GameKoth;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface KothCaptureService {

  /**
   * Capture the koth
   *
   * @param player the player who capture the koth
   * @param koth   the koth
   */

  void capture(
      @NotNull Player player,
      @NotNull GameKoth koth
  );

}

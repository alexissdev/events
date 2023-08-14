package dev.alexissdev.event.game.koth.service;

import dev.alexissdev.event.game.koth.game.GameKoth;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface KothUnCaptureService {

  /**
   * Uncapture the koth
   *
   * @param player the player who uncapture the koth
   * @param koth   the koth
   */

  void unCapture(
      @NotNull Player player,
      @NotNull GameKoth koth
  );
}

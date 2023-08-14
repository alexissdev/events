package dev.alexissdev.event.game.koth.notifier;

import dev.alexissdev.event.game.koth.game.GameKoth;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface KothUnCaptureNotifier {


  /**
   * Notify the player that he uncapture the koth
   *
   * @param player the player who uncapture the koth
   * @param koth   the koth
   */

  void notify(
      @NotNull Player player,
      @NotNull GameKoth koth
  );

}

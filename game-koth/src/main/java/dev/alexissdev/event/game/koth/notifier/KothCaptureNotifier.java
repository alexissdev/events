package dev.alexissdev.event.game.koth.notifier;

import dev.alexissdev.event.game.koth.game.GameKoth;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface KothCaptureNotifier {

  /**
   * Notifies the player that he has captured the koth
   *
   * @param player the player
   * @param koth   the koth
   */

  void notify(
      @NotNull Player player,
      @NotNull GameKoth koth
  );
}

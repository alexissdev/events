package dev.alexissdev.event.game.koth.notifier;

import dev.alexissdev.event.game.koth.game.GameKoth;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface KothWinnerNotifier {

  /**
   * Notify the winner of a koth
   *
   * @param koth   the koth
   * @param winner the winner
   */

  void notify(
      @NotNull GameKoth koth,
      @NotNull Player winner
  );

}

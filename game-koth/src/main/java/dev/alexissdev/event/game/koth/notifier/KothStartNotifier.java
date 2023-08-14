package dev.alexissdev.event.game.koth.notifier;

import dev.alexissdev.event.game.koth.game.GameKoth;
import org.jetbrains.annotations.NotNull;

public interface KothStartNotifier {

  /**
   * Notifies the start of a koth
   *
   * @param koth the koth.
   */

  void notify(
      @NotNull GameKoth koth
  );

}

package dev.alexissdev.event.game.koth.notifier;

import dev.alexissdev.event.game.koth.game.GameKoth;
import org.jetbrains.annotations.NotNull;

public interface KothStopNotifier {


  /**
   * Notifies the koth stop
   *
   * @param koth the koth
   */

  void notify(
      @NotNull GameKoth koth
  );

}

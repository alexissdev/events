package dev.alexissdev.event.game.koth.service;

import org.jetbrains.annotations.NotNull;

public interface KothFinishService {

  /**
   * Finish a koth
   *
   * @param kothId the koth id
   */

  void finish(
      @NotNull String kothId
  );

}

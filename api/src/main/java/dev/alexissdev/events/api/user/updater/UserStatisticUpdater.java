package dev.alexissdev.events.api.user.updater;

import org.jetbrains.annotations.NotNull;

public interface UserStatisticUpdater {

  enum Action {
    ADD,
    REMOVE,
    SET
  }

  enum Type {
    KILLS,
    DEATHS,
    WINS,
    LOSSES,
    PLAYED_GAMES,
    CAPTURED_KOTHS
  }

  /**
   * Updates the statistic of a user
   *
   * @param userId The user id
   * @param action The action to perform
   * @param type   The type of statistic
   * @param amount The amount to add/remove/set
   */

  void updateStatistic(
      @NotNull String userId,
      @NotNull Action action,
      @NotNull Type type,
      int amount
  );

}

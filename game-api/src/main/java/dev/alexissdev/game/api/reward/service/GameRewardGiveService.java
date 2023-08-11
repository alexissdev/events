package dev.alexissdev.game.api.reward.service;

import dev.alexissdev.game.api.reward.GameReward;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface GameRewardGiveService {

  /**
   * Give a reward to a player
   *
   * @param player Player to give the reward to
   * @param reward Reward to give
   */

  void give(
      @NotNull Player player,
      @NotNull GameReward reward
  );

}

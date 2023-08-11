package dev.alexissdev.game.api.reward.service;

import dev.alexissdev.game.api.reward.GameReward;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public interface GameRewardEditService {

  /**
   * Edits the reward data of a {@link GameReward}
   *
   * @param sender     the sender of the command
   * @param reward     the reward to edit
   * @param rewardData the new reward data
   * @param <R>        the type of the reward data
   * @return the edited reward
   */

  <R> GameReward editReward(
      @NotNull CommandSender sender,
      @NotNull GameReward reward,
      @NotNull Type rewardType,
      @NotNull R rewardData
  );

  enum Type {
    COMMAND,
    ITEM
  }

}

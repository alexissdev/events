package dev.alexissdev.game.api.reward.service;

import dev.alexissdev.game.api.reward.GameReward;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public interface GameDeleteCommandRewardService {

  /**
   * Deletes a command reward from the database
   *
   * @param sender           the sender of the command
   * @param reward           the reward to delete
   * @param commandReference the command reference
   * @return the deleted reward
   */

  GameReward delete(
      @NotNull CommandSender sender,
      @NotNull GameReward reward,
      @NotNull String commandReference
  );

}

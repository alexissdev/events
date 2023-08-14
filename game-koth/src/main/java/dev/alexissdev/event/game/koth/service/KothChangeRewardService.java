package dev.alexissdev.event.game.koth.service;

import dev.alexissdev.game.api.reward.service.GameRewardEditService;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public interface KothChangeRewardService {

  /**
   * Change the reward of a KOTH
   *
   * @param sender     The sender of the command
   * @param kothId     The id of the KOTH
   * @param rewardType The type of the reward
   * @param rewardData The data of the reward
   * @param <R>        The type of the reward
   */

  <R> void changeReward(
      @NotNull CommandSender sender,
      @NotNull String kothId,
      @NotNull GameRewardEditService.Type rewardType,
      @NotNull R rewardData
  );

}

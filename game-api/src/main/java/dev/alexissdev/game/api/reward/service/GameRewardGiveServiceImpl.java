package dev.alexissdev.game.api.reward.service;

import dev.alexissdev.game.api.reward.GameReward;
import javax.inject.Inject;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class GameRewardGiveServiceImpl
    implements GameRewardGiveService {

  @Inject
  private Plugin plugin;

  @Override
  public void give(@NotNull Player player, @NotNull GameReward reward) {
    if (!reward.hasReward()) {
      return;
    }

    reward.getRewardItemSet().forEach(item -> player.getInventory().addItem(item.toItemStack()));
    reward.getCommandRewardSet().forEach(serializedCommand -> {
      if (serializedCommand.getId().trim().isEmpty()) {
        return;
      }

      plugin.getServer().dispatchCommand(
          plugin.getServer().getConsoleSender(),
          serializedCommand.getId().replace("%player_name%", player.getName())
      );
    });
  }
}

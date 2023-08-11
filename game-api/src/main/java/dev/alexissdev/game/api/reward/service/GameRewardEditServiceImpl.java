package dev.alexissdev.game.api.reward.service;

import dev.alexissdev.commons.storage.bukkit.item.SerializableItem;
import dev.alexissdev.commons.storage.bukkit.text.SerializableString;
import dev.alexissdev.game.api.reward.GameReward;
import javax.inject.Inject;
import me.yushust.message.MessageHandler;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GameRewardEditServiceImpl
    implements GameRewardEditService {

  @Inject
  private MessageHandler messageHandler;


  @Override
  public <R> GameReward editReward(@NotNull CommandSender sender, @NotNull GameReward reward,
      @NotNull Type rewardType, @NotNull R rewardData) {
    if (rewardType == Type.COMMAND) {
      String command = (String) rewardData;
      reward.getCommandRewardSet().add(SerializableString.of(
          (command.startsWith("/")) ? command.substring(1) : command
      ));

      messageHandler.send(sender, "game-api.reward.add-command");
      return reward;
    }
    ItemStack rewardItem = (ItemStack) rewardData;
    reward.getRewardItemSet().add(SerializableItem.of(rewardItem, -1));

    messageHandler.send(sender, "game-api.reward.add-item");
    return reward;
  }
}

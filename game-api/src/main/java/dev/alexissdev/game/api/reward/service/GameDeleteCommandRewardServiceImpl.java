package dev.alexissdev.game.api.reward.service;

import dev.alexissdev.commons.storage.bukkit.text.SerializableString;
import dev.alexissdev.game.api.reward.GameReward;
import javax.inject.Inject;
import me.yushust.message.MessageHandler;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class GameDeleteCommandRewardServiceImpl
    implements GameDeleteCommandRewardService {

  @Inject
  private MessageHandler messageHandler;

  @Override
  public GameReward delete(@NotNull CommandSender sender, @NotNull GameReward reward,
      @NotNull String commandReference) {

    for (SerializableString serializableCommand : reward.getCommandRewardSet()) {
      String command = serializableCommand.getId();
      if (commandReference.startsWith("/")) {
        commandReference = commandReference.substring(1);
      }

      if (!command.equalsIgnoreCase(commandReference) || !command.startsWith(commandReference)) {
        continue;
      }

      reward.getCommandRewardSet().remove(serializableCommand);
      messageHandler.sendReplacing(sender, "game-api.reward.delete-command", "%command%", command);
    }

    return reward;
  }
}

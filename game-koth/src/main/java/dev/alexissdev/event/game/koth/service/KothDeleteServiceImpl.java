package dev.alexissdev.event.game.koth.service;

import dev.alexissdev.event.game.koth.game.GameKoth;
import dev.alexissdev.game.api.status.GameStatus;
import javax.inject.Inject;
import me.yushust.message.MessageHandler;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import team.unnamed.pixel.storage.dist.CachedRemoteModelService;

public class KothDeleteServiceImpl
    implements KothDeleteService {

  @Inject
  private CachedRemoteModelService<GameKoth> kothModelService;
  @Inject
  private MessageHandler messageHandler;


  @Override
  public void delete(@NotNull CommandSender sender, @NotNull String kothId) {
    GameKoth possibleKoth = kothModelService.getSync(kothId);
    if (possibleKoth == null) {
      messageHandler.sendReplacing(sender, "koth.not-exists", "%koth_id%", kothId);
      return;
    }

    if (possibleKoth.getStatus() != GameStatus.OFFLINE) {
      messageHandler.send(sender, "koth.not-offline", possibleKoth);
      return;
    }

    kothModelService.delete(possibleKoth);
    messageHandler.send(sender, "koth.delete", possibleKoth);
  }
}

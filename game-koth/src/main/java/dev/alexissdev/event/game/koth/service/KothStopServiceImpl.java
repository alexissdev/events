package dev.alexissdev.event.game.koth.service;

import dev.alexissdev.event.game.koth.game.GameKoth;
import dev.alexissdev.event.game.koth.notifier.KothStopNotifier;
import dev.alexissdev.game.api.status.GameStatus;
import javax.inject.Inject;
import me.yushust.message.MessageHandler;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import team.unnamed.pixel.storage.dist.CachedRemoteModelService;

public class KothStopServiceImpl
    implements KothStopService {

  @Inject
  private CachedRemoteModelService<GameKoth> kothModelService;
  @Inject
  private MessageHandler messageHandler;
  @Inject
  private KothStopNotifier kothStopNotifier;

  @Override
  public void stop(@NotNull CommandSender sender, @NotNull String kothId) {
    GameKoth koth = kothModelService.getSync(kothId);
    if (koth == null) {
      messageHandler.sendReplacing(sender, "koth.not-exists", "%koth_id%", kothId);
      return;
    }

    if (koth.getStatus() == GameStatus.OFFLINE) {
      messageHandler.send(sender, "koth.already-stopped");
      return;
    }

    koth.setStatus(GameStatus.OFFLINE);
    kothModelService.saveSync(koth);

    kothStopNotifier.notify(koth);
  }
}

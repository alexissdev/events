package dev.alexissdev.event.game.koth.service;

import dev.alexissdev.event.game.koth.game.GameKoth;
import dev.alexissdev.event.game.koth.notifier.KothStartNotifier;
import dev.alexissdev.game.api.host.GameHost;
import dev.alexissdev.game.api.status.GameStatus;
import javax.inject.Inject;
import me.yushust.message.MessageHandler;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import team.unnamed.pixel.storage.dist.CachedRemoteModelService;

public class KothStartServiceImpl
    implements KothStartService {

  @Inject
  private CachedRemoteModelService<GameKoth> kothModelService;
  @Inject
  private MessageHandler messageHandler;
  @Inject
  private KothStartNotifier kothStartNotifier;


  @Override
  public void start(@NotNull CommandSender sender, @NotNull String kothId) {
    GameKoth koth = kothModelService.getSync(kothId);
    if (koth == null) {
      messageHandler.sendReplacing(sender, "koth.not-exists", "%koth_id%", kothId);
      return;
    }

    if (koth.getStatus() != GameStatus.OFFLINE) {
      messageHandler.send(sender, "koth.already-started", koth);
      return;
    }

    if (koth.getConfiguration().getKothRegion() == null) {
      messageHandler.send(sender, "koth.no-region", koth);
      return;
    }

    if (sender instanceof Player) {
      Player host = (Player) sender;
      koth.setHost(GameHost.of(host.getUniqueId().toString(), host.getDisplayName()));
    }

    koth.setStatus(GameStatus.IN_GAME);

    kothStartNotifier.notify(koth);
    kothModelService.saveInCache(koth);
  }
}

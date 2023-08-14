package dev.alexissdev.event.game.koth.service;

import dev.alexissdev.event.game.koth.game.GameKoth;
import dev.alexissdev.event.game.koth.game.KothConfiguration;
import javax.inject.Inject;
import me.yushust.message.MessageHandler;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import team.unnamed.pixel.storage.dist.CachedRemoteModelService;

public class KothCreateServiceImpl
    implements KothCreateService {

  @Inject
  private CachedRemoteModelService<GameKoth> kothModelService;
  @Inject
  private MessageHandler messageHandler;


  @Override
  public void create(@NotNull CommandSender sender, @NotNull String kothId, int captureTime) {
    GameKoth possibleKoth = kothModelService.getSync(kothId);
    if (possibleKoth != null) {
      messageHandler.send(sender, "koth.already-exists", possibleKoth);
      return;
    }

    GameKoth koth = GameKoth.create(kothId, KothConfiguration.create(null, captureTime));
    kothModelService.saveSync(koth);

    messageHandler.send(sender, "koth.create", koth);
  }
}

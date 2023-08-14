package dev.alexissdev.event.game.koth.service;

import dev.alexissdev.event.game.koth.event.KothWinnerEvent;
import dev.alexissdev.event.game.koth.game.GameKoth;
import dev.alexissdev.event.game.koth.notifier.KothWinnerNotifier;
import dev.alexissdev.events.api.user.updater.UserStatisticUpdater;
import dev.alexissdev.events.api.user.updater.UserStatisticUpdater.Action;
import dev.alexissdev.events.api.user.updater.UserStatisticUpdater.Type;
import dev.alexissdev.game.api.reward.service.GameRewardGiveService;
import javax.inject.Inject;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import team.unnamed.pixel.storage.dist.CachedRemoteModelService;

public class KothFinishServiceImpl
    implements KothFinishService {

  @Inject
  private CachedRemoteModelService<GameKoth> kothModelService;
  @Inject
  private KothStopService kothStopService;
  @Inject
  private KothWinnerNotifier kothWinnerNotifier;
  @Inject
  private UserStatisticUpdater userStatisticUpdater;
  @Inject
  private Plugin plugin;
  @Inject
  private GameRewardGiveService gameRewardGiveService;


  @Override
  public void finish(@NotNull String kothId) {
    GameKoth koth = kothModelService.getSync(kothId);
    if (koth == null) {
      return;
    }

    Player bukkitPlayer = plugin.getServer().getPlayer(koth.getKothCapturer().getCapturerId());
    kothWinnerNotifier.notify(koth, bukkitPlayer);

    userStatisticUpdater.updateStatistic(
        bukkitPlayer.getUniqueId().toString(),
        Action.ADD,
        Type.CAPTURED_KOTHS,
        1
    );
    gameRewardGiveService.give(bukkitPlayer, koth.getReward());

    plugin.getServer().getPluginManager().callEvent(new KothWinnerEvent(koth, bukkitPlayer));
    kothStopService.stop(plugin.getServer().getConsoleSender(), koth.getId());
  }
}

package dev.alexissdev.event.game.koth.checker;

import dev.alexissdev.event.game.koth.KothRegistry;
import dev.alexissdev.event.game.koth.event.KothEnterEvent;
import dev.alexissdev.event.game.koth.game.GameKoth;
import dev.alexissdev.event.game.koth.notifier.KothEnterNotifier;
import dev.alexissdev.event.game.koth.service.KothCaptureService;
import dev.alexissdev.game.api.region.GameRegion;
import javax.inject.Inject;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import team.unnamed.pixel.storage.dist.CachedRemoteModelService;

public class KothEnterCheckerImpl
    implements KothEnterChecker {

  @Inject
  private CachedRemoteModelService<GameKoth> kothModelService;
  @Inject
  private KothRegistry kothRegistry;
  @Inject
  private Plugin plugin;
  @Inject
  private KothEnterNotifier kothEnterNotifier;
  @Inject
  private KothLeaveChecker kothLeaveChecker;
  @Inject
  private KothCaptureService kothCaptureService;

  @Override
  public void check(@NotNull Player player) {
    for (GameKoth koth : kothModelService.getAllSync()) {
      GameRegion kothRegion = koth.getConfiguration().getKothRegion();
      if (player.getGameMode() == GameMode.SPECTATOR) {
        return;
      }

      if (!kothRegion.in(player.getLocation())) {
        kothLeaveChecker.check(player, koth);
        return;
      }

      if (!kothRegistry.registerIfNotExistsEnterKoth(player.getUniqueId(), koth.getId())) {
        return;
      }

      KothEnterEvent kothEnterEvent = new KothEnterEvent(koth, player);
      plugin.getServer().getPluginManager().callEvent(kothEnterEvent);
      if (!kothEnterEvent.isCancelled()) {
        kothEnterNotifier.notify(player, koth);
      }

      kothCaptureService.capture(player, koth);
    }
  }
}

package dev.alexissdev.event.game.koth.checker;

import dev.alexissdev.event.game.koth.KothRegistry;
import dev.alexissdev.event.game.koth.event.KothLeaveEvent;
import dev.alexissdev.event.game.koth.game.GameKoth;
import dev.alexissdev.event.game.koth.notifier.KothLeaveNotifier;
import dev.alexissdev.event.game.koth.service.KothUnCaptureService;
import java.util.UUID;
import javax.inject.Inject;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class KothLeaveCheckerImpl
    implements KothLeaveChecker {

  @Inject
  private KothLeaveNotifier kothLeaveNotifier;
  @Inject
  private KothRegistry kothRegistry;
  @Inject
  private Plugin plugin;
  @Inject
  private KothUnCaptureService kothUnCaptureService;

  @Override
  public void check(@NotNull Player player, @NotNull GameKoth koth) {
    String kothEnter = kothRegistry.getEnterKoth(player.getUniqueId());
    if (kothEnter == null || !kothEnter.equalsIgnoreCase(koth.getId())) {
      return;
    }
    kothRegistry.invalidateKothEnter(player.getUniqueId());

    KothLeaveEvent kothLeaveEvent = new KothLeaveEvent(koth, player);
    plugin.getServer().getPluginManager().callEvent(kothLeaveEvent);
    if (!kothLeaveEvent.isCancelled()) {
      kothLeaveNotifier.notify(player, koth);
    }

    UUID userCapturedKothId = koth.getKothCapturer().getCapturerId();
    if (userCapturedKothId != null && player.getUniqueId().equals(userCapturedKothId)) {
      kothUnCaptureService.unCapture(player, koth);
    }
  }
}

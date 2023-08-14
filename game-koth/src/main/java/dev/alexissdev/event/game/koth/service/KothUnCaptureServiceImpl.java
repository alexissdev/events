package dev.alexissdev.event.game.koth.service;

import dev.alexissdev.event.game.koth.KothKeys;
import dev.alexissdev.event.game.koth.event.KothUnCapturedEvent;
import dev.alexissdev.event.game.koth.game.GameKoth;
import dev.alexissdev.event.game.koth.game.KothCapturer;
import dev.alexissdev.event.game.koth.notifier.KothUnCaptureNotifier;
import dev.alexissdev.events.api.timestamp.TimeStamp;
import javax.inject.Inject;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import team.unnamed.pixel.storage.ModelService;

public class KothUnCaptureServiceImpl
    implements KothUnCaptureService {

  @Inject
  private Plugin plugin;
  @Inject
  private KothUnCaptureNotifier kothUnCaptureNotifier;
  @Inject
  private ModelService<TimeStamp> timeStampModelService;


  @Override
  public void unCapture(@NotNull Player player, @NotNull GameKoth koth) {
    KothUnCapturedEvent kothUnCapturedEvent = new KothUnCapturedEvent(koth, player);
    player.getServer().getPluginManager().callEvent(kothUnCapturedEvent);

    if (kothUnCapturedEvent.isCancelled()) {
      return;
    }

    koth.setKothCapturer(KothCapturer.EMPTY);

    timeStampModelService.deleteSync(String.format(KothKeys.CAPTURED_KOTH, koth.getId()));
    kothUnCaptureNotifier.notify(player, koth);
  }
}

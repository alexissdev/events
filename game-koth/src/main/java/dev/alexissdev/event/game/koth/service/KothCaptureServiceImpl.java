package dev.alexissdev.event.game.koth.service;

import static dev.alexissdev.event.game.koth.KothKeys.CAPTURED_KOTH;

import dev.alexissdev.event.game.koth.event.KothCapturedEvent;
import dev.alexissdev.event.game.koth.game.GameKoth;
import dev.alexissdev.event.game.koth.game.KothCapturer;
import dev.alexissdev.event.game.koth.notifier.KothCaptureNotifier;
import dev.alexissdev.events.api.timestamp.TimeStamp;
import dev.alexissdev.game.api.status.GameStatus;
import javax.inject.Inject;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import team.unnamed.pixel.storage.ModelService;

public class KothCaptureServiceImpl
    implements KothCaptureService {

  @Inject
  private Plugin plugin;
  @Inject
  private ModelService<TimeStamp> timeStampModelService;
  @Inject
  private KothCaptureNotifier kothCaptureNotifier;

  @Override
  public void capture(@NotNull Player player, @NotNull GameKoth koth) {
    if (koth.getStatus() != GameStatus.IN_GAME || koth.getKothCapturer().getCapturerId() != null) {
      return;
    }

    String coolDownId = String.format(CAPTURED_KOTH, koth.getId());
    koth.setKothCapturer(KothCapturer.of(player.getUniqueId(), player.getName()));

    KothCapturedEvent kothCapturedEvent = new KothCapturedEvent(koth, player);
    plugin.getServer().getPluginManager().callEvent(kothCapturedEvent);
    if (!kothCapturedEvent.isCancelled()) {
      kothCaptureNotifier.notify(player, koth);
    }

    timeStampModelService.saveSync(TimeStamp.create(coolDownId, koth.getConfiguration()
        .getCaptureTime()));
  }
}

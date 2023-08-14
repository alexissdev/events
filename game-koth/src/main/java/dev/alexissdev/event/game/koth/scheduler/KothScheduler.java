package dev.alexissdev.event.game.koth.scheduler;

import dev.alexissdev.event.game.koth.KothKeys;
import dev.alexissdev.event.game.koth.service.KothFinishService;
import dev.alexissdev.events.api.scheduler.SchedulerTemplate;
import dev.alexissdev.events.api.timestamp.TimeStamp;
import javax.inject.Inject;
import org.bukkit.plugin.Plugin;
import team.unnamed.pixel.storage.ModelService;

public class KothScheduler
    extends SchedulerTemplate {

  private final ModelService<TimeStamp> timeStampModelService;
  private final KothFinishService kothFinishService;

  public @Inject KothScheduler(Plugin plugin, ModelService<TimeStamp> timeStampModelService,
      KothFinishService kothFinishService) {
    super(plugin);
    this.timeStampModelService = timeStampModelService;
    this.kothFinishService = kothFinishService;
  }

  @Override
  public void run() {
    for (TimeStamp timeStamp : timeStampModelService.findAllSync()) {
      if (!timeStamp.getId().startsWith(String.format(KothKeys.CAPTURED_KOTH, ""))
          || !timeStamp.isExpired()) {
        continue;
      }

      kothFinishService.finish(timeStamp.getId().split("/")[2]);
      timeStampModelService.deleteSync(timeStamp.getId());
    }
  }
}

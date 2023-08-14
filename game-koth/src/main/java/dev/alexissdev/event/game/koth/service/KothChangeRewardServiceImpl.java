package dev.alexissdev.event.game.koth.service;

import dev.alexissdev.event.game.koth.game.GameKoth;
import dev.alexissdev.game.api.reward.service.GameRewardEditService;
import javax.inject.Inject;
import me.yushust.message.MessageHandler;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import team.unnamed.pixel.storage.dist.CachedRemoteModelService;

public class KothChangeRewardServiceImpl
    implements KothChangeRewardService {

  @Inject
  private CachedRemoteModelService<GameKoth> kothModelService;
  @Inject
  private GameRewardEditService gameRewardEditService;
  @Inject
  private MessageHandler messageHandler;

  @Override
  public <R> void changeReward(@NotNull CommandSender sender, @NotNull String kothId,
      @NotNull GameRewardEditService.Type rewardType, @NotNull R rewardData) {
    GameKoth koth = kothModelService.getSync(kothId);
    if (koth == null) {
      messageHandler.sendReplacing(sender, "koth.not-exists", "%koth_id%", kothId);
      return;
    }

    koth.setReward(
        gameRewardEditService.editReward(sender, koth.getReward(), rewardType, rewardData));
    kothModelService.saveInCache(koth);
  }
}

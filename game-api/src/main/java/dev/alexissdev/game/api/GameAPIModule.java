package dev.alexissdev.game.api;

import dev.alexissdev.events.api.GeneralAPIModule;
import dev.alexissdev.game.api.reward.service.GameDeleteCommandRewardService;
import dev.alexissdev.game.api.reward.service.GameRewardEditService;
import dev.alexissdev.game.api.reward.service.GameRewardGiveService;
import team.unnamed.inject.AbstractModule;

public class GameAPIModule
    extends AbstractModule {

  @Override
  protected void configure() {
    install(new GeneralAPIModule());

    bind(GameRewardEditService.class).to(GameRewardEditService.class).singleton();
    bind(GameRewardGiveService.class).to(GameRewardGiveService.class).singleton();
    bind(GameDeleteCommandRewardService.class).to(GameDeleteCommandRewardService.class).singleton();
  }
}

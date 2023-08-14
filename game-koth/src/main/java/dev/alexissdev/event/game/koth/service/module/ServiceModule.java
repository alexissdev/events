package dev.alexissdev.event.game.koth.service.module;

import dev.alexissdev.event.game.koth.service.KothCaptureService;
import dev.alexissdev.event.game.koth.service.KothCaptureServiceImpl;
import dev.alexissdev.event.game.koth.service.KothChangeRewardService;
import dev.alexissdev.event.game.koth.service.KothCreateService;
import dev.alexissdev.event.game.koth.service.KothCreateServiceImpl;
import dev.alexissdev.event.game.koth.service.KothDeleteService;
import dev.alexissdev.event.game.koth.service.KothDeleteServiceImpl;
import dev.alexissdev.event.game.koth.service.KothFinishService;
import dev.alexissdev.event.game.koth.service.KothStartService;
import dev.alexissdev.event.game.koth.service.KothStartServiceImpl;
import dev.alexissdev.event.game.koth.service.KothStopService;
import dev.alexissdev.event.game.koth.service.KothStopServiceImpl;
import team.unnamed.inject.AbstractModule;

public class ServiceModule
    extends AbstractModule {

  @Override
  protected void configure() {
    bind(KothCreateService.class).to(KothCreateServiceImpl.class).singleton();
    bind(KothDeleteService.class).to(KothDeleteServiceImpl.class).singleton();
    bind(KothFinishService.class).to(KothFinishService.class).singleton();
    bind(KothStartService.class).to(KothStartServiceImpl.class).singleton();
    bind(KothStopService.class).to(KothStopServiceImpl.class).singleton();
    bind(KothCaptureService.class).to(KothCaptureServiceImpl.class).singleton();
    bind(KothChangeRewardService.class).to(KothChangeRewardService.class).singleton();
  }
}

package dev.alexissdev.events.api.timestamp.module;

import dev.alexissdev.events.api.model.ConcurrentLocalModelService;
import dev.alexissdev.events.api.timestamp.TimeStamp;
import javax.inject.Singleton;
import team.unnamed.inject.AbstractModule;
import team.unnamed.inject.Provides;
import team.unnamed.pixel.storage.ModelService;

public class TimeStampModule
    extends AbstractModule {

  @Provides
  @Singleton
  public ModelService<TimeStamp> provideModelService() {
    return ConcurrentLocalModelService.create();
  }

}

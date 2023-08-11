package dev.alexissdev.events.api;

import dev.alexissdev.events.api.timestamp.module.TimeStampModule;
import team.unnamed.inject.AbstractModule;

public class GeneralAPIModule
    extends AbstractModule {

  @Override
  protected void configure() {
    install(new TimeStampModule());
    install(new TimeStampModule());
  }
}

package dev.alexissdev.events.api;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.inject.Singleton;
import team.unnamed.inject.AbstractModule;
import team.unnamed.inject.Provides;

public class ExecutorModule
    extends AbstractModule {

  @Provides
  @Singleton
  public Executor proivdeExecutor() {
    return Executors.newCachedThreadPool();
  }

}

package dev.alexissdev.event.game.koth;

import dev.alexissdev.event.game.koth.checker.module.CheckerModule;
import dev.alexissdev.event.game.koth.notifier.module.NotifierModule;
import dev.alexissdev.event.game.koth.service.module.ServiceModule;
import team.unnamed.inject.AbstractModule;

public class GameKothModule extends AbstractModule {

  @Override
  protected void configure() {
    install(new NotifierModule());
    install(new CheckerModule());
    install(new ServiceModule());
  }


  /**
   * Create a new instance of {@link GameKothModule}
   *
   * @return a new instance of {@link GameKothModule}
   */

  public static GameKothModule create() {
    return new GameKothModule();
  }
}

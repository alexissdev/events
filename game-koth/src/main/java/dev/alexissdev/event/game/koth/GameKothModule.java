package dev.alexissdev.event.game.koth;

import team.unnamed.inject.AbstractModule;

public class GameKothModule extends AbstractModule {

  @Override
  protected void configure() {

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

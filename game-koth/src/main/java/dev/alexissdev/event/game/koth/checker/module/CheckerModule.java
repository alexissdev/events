package dev.alexissdev.event.game.koth.checker.module;

import dev.alexissdev.event.game.koth.checker.KothEnterChecker;
import dev.alexissdev.event.game.koth.checker.KothEnterCheckerImpl;
import dev.alexissdev.event.game.koth.checker.KothLeaveChecker;
import dev.alexissdev.event.game.koth.checker.KothLeaveCheckerImpl;
import team.unnamed.inject.AbstractModule;

public class CheckerModule
    extends AbstractModule {

  @Override
  protected void configure() {
    bind(KothEnterChecker.class).to(KothEnterCheckerImpl.class).singleton();
    bind(KothLeaveChecker.class).to(KothLeaveCheckerImpl.class).singleton();
  }
}

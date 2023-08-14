package dev.alexissdev.event.game.koth.notifier.module;

import dev.alexissdev.event.game.koth.notifier.KothCaptureNotifier;
import dev.alexissdev.event.game.koth.notifier.KothEnterNotifier;
import dev.alexissdev.event.game.koth.notifier.KothEnterNotifierImpl;
import dev.alexissdev.event.game.koth.notifier.KothLeaveNotifier;
import dev.alexissdev.event.game.koth.notifier.KothStartNotifier;
import dev.alexissdev.event.game.koth.notifier.KothStartNotifierImpl;
import dev.alexissdev.event.game.koth.notifier.KothStopNotifier;
import dev.alexissdev.event.game.koth.notifier.KothStopNotifierImpl;
import dev.alexissdev.event.game.koth.notifier.KothUnCaptureNotifier;
import dev.alexissdev.event.game.koth.notifier.KothUnCaptureNotifierImpl;
import dev.alexissdev.event.game.koth.notifier.KothWinnerNotifier;
import dev.alexissdev.event.game.koth.notifier.KothWinnerNotifierImpl;
import team.unnamed.inject.AbstractModule;

public class NotifierModule
    extends AbstractModule {

  @Override
  protected void configure() {
    bind(KothStartNotifier.class).to(KothStartNotifierImpl.class).singleton();
    bind(KothStopNotifier.class).to(KothStopNotifierImpl.class).singleton();
    bind(KothEnterNotifier.class).to(KothEnterNotifierImpl.class).singleton();
    bind(KothLeaveNotifier.class).to(KothLeaveNotifier.class).singleton();
    bind(KothCaptureNotifier.class).to(KothCaptureNotifier.class).singleton();
    bind(KothUnCaptureNotifier.class).to(KothUnCaptureNotifierImpl.class).singleton();
    bind(KothWinnerNotifier.class).to(KothWinnerNotifierImpl.class).singleton();
  }
}

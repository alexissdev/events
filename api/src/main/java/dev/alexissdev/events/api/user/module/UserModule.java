package dev.alexissdev.events.api.user.module;

import dev.alexissdev.events.api.user.backup.applier.UserBackupApplier;
import dev.alexissdev.events.api.user.backup.applier.UserBackupApplierImpl;
import dev.alexissdev.events.api.user.service.UserLoadService;
import dev.alexissdev.events.api.user.service.UserLoadServiceImpl;
import dev.alexissdev.events.api.user.service.UserUploadService;
import dev.alexissdev.events.api.user.service.UserUploadServiceImpl;
import dev.alexissdev.events.api.user.updater.UserStatisticUpdater;
import dev.alexissdev.events.api.user.updater.UserStatisticUpdaterImpl;
import team.unnamed.inject.AbstractModule;

public class UserModule
    extends AbstractModule {

  @Override
  protected void configure() {
    bind(UserBackupApplier.class).to(UserBackupApplierImpl.class).singleton();
    bind(UserStatisticUpdater.class).to(UserStatisticUpdaterImpl.class).singleton();

    bind(UserLoadService.class).to(UserLoadServiceImpl.class).singleton();
    bind(UserUploadService.class).to(UserUploadServiceImpl.class).singleton();
  }
}

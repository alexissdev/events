package dev.alexissdev.events.api.user.module;

import com.mongodb.client.MongoDatabase;
import dev.alexissdev.events.api.user.User;
import dev.alexissdev.events.api.user.backup.applier.UserBackupApplier;
import dev.alexissdev.events.api.user.backup.applier.UserBackupApplierImpl;
import dev.alexissdev.events.api.user.service.UserLoadService;
import dev.alexissdev.events.api.user.service.UserLoadServiceImpl;
import dev.alexissdev.events.api.user.service.UserUploadService;
import dev.alexissdev.events.api.user.service.UserUploadServiceImpl;
import dev.alexissdev.events.api.user.updater.UserStatisticUpdater;
import dev.alexissdev.events.api.user.updater.UserStatisticUpdaterImpl;
import java.util.concurrent.Executor;
import javax.inject.Singleton;
import team.unnamed.inject.AbstractModule;
import team.unnamed.inject.Provides;
import team.unnamed.pixel.storage.dist.CachedRemoteModelService;
import team.unnamed.pixel.storage.mongo.MongoModelService;

public class UserModule
    extends AbstractModule {

  @Override
  protected void configure() {
    bind(UserBackupApplier.class).to(UserBackupApplierImpl.class).singleton();
    bind(UserStatisticUpdater.class).to(UserStatisticUpdaterImpl.class).singleton();

    bind(UserLoadService.class).to(UserLoadServiceImpl.class).singleton();
    bind(UserUploadService.class).to(UserUploadServiceImpl.class).singleton();
  }

  @Provides
  @Singleton
  public CachedRemoteModelService<User> provideModelService(MongoDatabase database,
      Executor executor) {
    return (CachedRemoteModelService<User>) MongoModelService.builder(User.class)
        .database(database)
        .modelParser(User::read)
        .executor(executor)
        .collection("users")
        .build();
  }
}

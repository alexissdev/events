package dev.alexissdev.events.api.user.service;

import dev.alexissdev.events.api.user.User;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.jetbrains.annotations.NotNull;
import team.unnamed.pixel.storage.dist.CachedRemoteModelService;

public class UserUploadServiceImpl
    implements UserUploadService {

  @Inject
  private CachedRemoteModelService<User> userModelService;
  @Inject
  private Logger logger;

  @Override
  public void upload(@NotNull String userId) {
    User cachedUser = userModelService.getSync(userId);
    if (cachedUser == null) {
      logger.info("User " + userId + " not found in cache.");
      return;
    }

    userModelService.upload(cachedUser);
  }
}

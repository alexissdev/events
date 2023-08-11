package dev.alexissdev.events.api.user.service;

import dev.alexissdev.events.api.user.User;
import dev.alexissdev.events.api.user.UserStatistic;
import java.util.UUID;
import javax.inject.Inject;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;
import team.unnamed.pixel.storage.dist.CachedRemoteModelService;

public class UserLoadServiceImpl
    implements UserLoadService {

  @Inject
  private CachedRemoteModelService<User> userModelService;


  @Override
  public void load(@NotNull String userId) {
    userModelService.find(userId).whenComplete((user, throwable) -> {
      if (throwable != null) {
        throwable.printStackTrace(System.err);
        return;
      }
      if (user == null) {
        user = User.create(userId,
            Bukkit.getServer().getOfflinePlayer(UUID.fromString(userId)).getName(),
            UserStatistic.create(), "en");

        userModelService.saveInCache(user);
      }
    });
  }
}

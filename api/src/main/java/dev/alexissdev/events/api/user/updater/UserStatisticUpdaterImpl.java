package dev.alexissdev.events.api.user.updater;

import dev.alexissdev.events.api.user.User;
import dev.alexissdev.events.api.user.UserStatistic;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.jetbrains.annotations.NotNull;
import team.unnamed.pixel.storage.dist.CachedRemoteModelService;

public class UserStatisticUpdaterImpl
    implements UserStatisticUpdater {

  @Inject
  private CachedRemoteModelService<User> userModelService;
  @Inject
  private Logger logger;


  @Override
  public void updateStatistic(@NotNull String userId, @NotNull Action action, @NotNull Type type,
      int amount) {
    User user = userModelService.getSync(userId);
    if (user == null) {
      logger.warning("User with id " + userId + " not found");
      return;
    }

    UserStatistic userStatistic = user.getUserStatistic();

    switch (type) {
      case WINS: {
        switch (action) {
          case ADD: {
            user.getUserStatistic().getWinsStatistic()
                .setValue(userStatistic.getWinsStatistic().getValue() + amount);
            break;
          }
          case REMOVE: {
            user.getUserStatistic().getWinsStatistic()
                .setValue(userStatistic.getWinsStatistic().getValue() - amount);
            break;
          }
          case SET: {
            user.getUserStatistic().getWinsStatistic().setValue(amount);
            break;
          }
        }
      }

      case LOSSES: {
        switch (action) {
          case ADD: {
            user.getUserStatistic().getLossesStatistic()
                .setValue(userStatistic.getLossesStatistic().getValue() + amount);
            break;
          }
          case REMOVE: {
            user.getUserStatistic().getLossesStatistic()
                .setValue(userStatistic.getLossesStatistic().getValue() - amount);
            break;
          }
          case SET: {
            user.getUserStatistic().getLossesStatistic().setValue(amount);
            break;
          }
        }
      }

      case KILLS: {
        switch (action) {
          case ADD: {
            user.getUserStatistic().getKillsStatistic()
                .setValue(userStatistic.getWinsStatistic().getValue() + amount);
            break;
          }
          case REMOVE: {
            user.getUserStatistic().getKillsStatistic()
                .setValue(userStatistic.getKillsStatistic().getValue() - amount);
            break;
          }
          case SET: {
            user.getUserStatistic().getKillsStatistic().setValue(amount);
            break;
          }
        }
      }

      case DEATHS: {
        switch (action) {
          case ADD: {
            user.getUserStatistic().getDeathsStatistic()
                .setValue(userStatistic.getDeathsStatistic().getValue() + amount);
            break;
          }
          case REMOVE: {
            user.getUserStatistic().getDeathsStatistic()
                .setValue(userStatistic.getDeathsStatistic().getValue() - amount);
            break;
          }
          case SET: {
            user.getUserStatistic().getDeathsStatistic().setValue(amount);
            break;
          }
        }
      }

      case PLAYED_GAMES: {
        switch (action) {
          case ADD: {
            user.getUserStatistic().getGamesPlayedStatistic()
                .setValue(userStatistic.getGamesPlayedStatistic().getValue() + amount);
            break;
          }
          case REMOVE: {
            user.getUserStatistic().getGamesPlayedStatistic()
                .setValue(userStatistic.getGamesPlayedStatistic().getValue() - amount);
            break;
          }
          case SET: {
            user.getUserStatistic().getGamesPlayedStatistic().setValue(amount);
            break;
          }
        }
      }

      case CAPTURED_KOTHS: {
        switch (action) {
          case ADD: {
            user.getUserStatistic().getCapturedKothsStatistic()
                .setValue(userStatistic.getCapturedKothsStatistic().getValue() + amount);
            break;
          }
          case REMOVE: {
            user.getUserStatistic().getCapturedKothsStatistic()
                .setValue(userStatistic.getCapturedKothsStatistic().getValue() - amount);
            break;
          }
          case SET: {
            user.getUserStatistic().getCapturedKothsStatistic().setValue(amount);
            break;
          }
        }
      }
    }

    userModelService.saveInCache(user);
  }
}

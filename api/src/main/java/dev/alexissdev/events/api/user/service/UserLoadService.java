package dev.alexissdev.events.api.user.service;

import org.jetbrains.annotations.NotNull;

public interface UserLoadService {

  /**
   * Load a user from the database
   *
   * @param userId the user id
   */

  void load(
      @NotNull String userId
  );

}

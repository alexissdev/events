package dev.alexissdev.events.api.user.service;

import org.jetbrains.annotations.NotNull;

public interface UserUploadService {

  /**
   * Uploads the user to the database
   *
   * @param userId the user id
   */

  void upload(
      @NotNull String userId
  );

}

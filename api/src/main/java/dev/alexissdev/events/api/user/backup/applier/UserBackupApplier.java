package dev.alexissdev.events.api.user.backup.applier;

import dev.alexissdev.events.api.user.backup.UserBackup;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface UserBackupApplier {

  /**
   * Applies the backup to the player
   *
   * @param player     the player to apply the backup to
   * @param userBackup the backup to apply
   */

  void apply(
      @NotNull Player player,
      @NotNull UserBackup userBackup
  );
}

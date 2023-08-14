package dev.alexissdev.event.game.koth.service;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public interface KothDeleteService {

  /**
   * Deleting a KOTH.
   * @param sender The sender has been deleted the KOTH.
   * @param kothId the KOTH id.
   */

  void delete(
      @NotNull CommandSender sender,
      @NotNull String kothId
  );

}

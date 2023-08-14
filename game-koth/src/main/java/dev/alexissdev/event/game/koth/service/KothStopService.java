package dev.alexissdev.event.game.koth.service;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public interface KothStopService {

  /**
   * Stop a koth
   *
   * @param sender the sender
   * @param kothId the koth id
   */

  void stop(
      @NotNull CommandSender sender,
      @NotNull String kothId
  );

}

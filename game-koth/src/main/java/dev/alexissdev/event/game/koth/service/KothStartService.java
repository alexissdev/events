package dev.alexissdev.event.game.koth.service;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public interface KothStartService {

  /**
   * Start a koth
   *
   * @param sender the sender of the command
   * @param kothId the id of the koth
   */

  void start(
      @NotNull CommandSender sender,
      @NotNull String kothId
  );

}

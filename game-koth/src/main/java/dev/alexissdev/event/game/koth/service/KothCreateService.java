package dev.alexissdev.event.game.koth.service;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public interface KothCreateService {

  /**
   * Creating a new KOTH.
   *
   * @param sender      The creator of the KOTH.
   * @param kothId      the KOTH id.
   * @param captureTime the KOTH capture time.
   */

  void create(
      @NotNull CommandSender sender,
      @NotNull String kothId,
      int captureTime
  );

}

package dev.alexissdev.event.game.koth.checker;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface KothEnterChecker {

  void check(
      @NotNull Player player
  );

}

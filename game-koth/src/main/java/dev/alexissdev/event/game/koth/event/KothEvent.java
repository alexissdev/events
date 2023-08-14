package dev.alexissdev.event.game.koth.event;

import dev.alexissdev.event.game.koth.game.GameKoth;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.player.PlayerEvent;

public abstract class KothEvent
    extends PlayerEvent
    implements Cancellable {

  protected final GameKoth gameKoth;
  private boolean cancelled;

  public KothEvent(GameKoth koth, Player player) {
    super(player);
    this.gameKoth = koth;
    this.cancelled = false;
  }

  public GameKoth getGameKoth() {
    return gameKoth;
  }

  @Override
  public boolean isCancelled() {
    return cancelled;
  }

  @Override
  public void setCancelled(boolean cancelled) {
    this.cancelled = cancelled;
  }
}

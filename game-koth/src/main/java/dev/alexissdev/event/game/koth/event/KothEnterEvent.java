package dev.alexissdev.event.game.koth.event;

import dev.alexissdev.event.game.koth.game.GameKoth;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public class KothEnterEvent
    extends KothEvent {

  private final static HandlerList HANDLER_LIST = new HandlerList();

  public KothEnterEvent(GameKoth koth,
      Player player) {
    super(koth, player);
  }

  @Override
  public HandlerList getHandlers() {
    return HANDLER_LIST;
  }

  public static HandlerList getHandlerList() {
    return HANDLER_LIST;
  }
}

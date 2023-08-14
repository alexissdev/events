package dev.alexissdev.event.game.koth.notifier;

import dev.alexissdev.event.game.koth.game.GameKoth;
import javax.inject.Inject;
import me.yushust.message.MessageHandler;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class KothLeaveNotifierImpl
    implements KothLeaveNotifier {

  @Inject
  private MessageHandler messageHandler;

  @Override
  public void notify(@NotNull Player player, @NotNull GameKoth koth) {
    messageHandler.send(player, "koth.leave", koth);
  }
}

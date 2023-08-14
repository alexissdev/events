package dev.alexissdev.event.game.koth.notifier;

import dev.alexissdev.event.game.koth.game.GameKoth;
import javax.inject.Inject;
import me.yushust.message.MessageHandler;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class KothStartNotifierImpl
    implements KothStartNotifier {

  @Inject
  private MessageHandler messageHandler;
  @Inject
  private Plugin plugin;

  @Override
  public void notify(@NotNull GameKoth koth) {
    for (Player onlinePlayer : plugin.getServer().getOnlinePlayers()) {
      messageHandler.send(onlinePlayer, "koth.start", koth);
    }
  }
}

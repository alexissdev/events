package dev.alexissdev.events.api.scheduler;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class SchedulerTemplate
    extends BukkitRunnable {

  protected final Plugin plugin;

  protected SchedulerTemplate(Plugin plugin) {
    this.plugin = plugin;
  }

  public void start() {
    runTaskTimerAsynchronously(plugin, 0L, 20L);
  }
}

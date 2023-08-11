package dev.alexissdev.events.api.user.backup.applier;

import dev.alexissdev.events.api.user.backup.UserBackup;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class UserBackupApplierImpl
    implements UserBackupApplier {

  @Override
  public void apply(@NotNull Player player, @NotNull UserBackup userBackup) {
    player.getInventory().setContents(userBackup.getInventoryContents());
    player.getInventory().setArmorContents(userBackup.getArmorContents());

    player.setGameMode(userBackup.getGameMode());
    player.setAllowFlight(userBackup.getAllowFlight());

    player.setHealth((userBackup.getHealth() > 20) ? 20 : userBackup.getHealth());
    player.setFoodLevel(userBackup.getFood());

    player.getActivePotionEffects()
        .forEach(potionEffect -> player.removePotionEffect(potionEffect.getType()));
    player.addPotionEffects(userBackup.getPotionEffects());

    player.setFlySpeed(userBackup.getFlySpeed());
    player.setWalkSpeed(userBackup.getWalkSpeed());
    player.setLevel(userBackup.getLevel());
    player.setExp(userBackup.getExp());

    player.teleport(userBackup.getLocation());
  }
}

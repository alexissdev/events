package dev.alexissdev.game.api.region.wand;

import dev.alexissdev.game.api.util.NBTUtil;
import java.util.List;
import me.yushust.message.MessageHandler;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class RegionWandProivder {

  public static final String NBT_KEY = "region_wand_creator";

  private RegionWandProivder() {
    throw new UnsupportedOperationException("This class cannot be instantiated");
  }

  /**
   * Provides a wand to the player
   *
   * @param player         The player to provide the wand to.
   * @param messageHandler The message handler to get the messages from.
   */

  public static void provideWand(@NotNull Player player, @NotNull MessageHandler messageHandler) {
    List<String> lore = messageHandler.getMany(player, "region.wand.description");

    ItemStack rawItem = new ItemStack(Material.WOOD_AXE, 1);
    ItemMeta itemMeta = rawItem.getItemMeta();
    itemMeta.setDisplayName(messageHandler.get(player, "region.wand.name"));
    itemMeta.setLore(lore);
    rawItem.setItemMeta(itemMeta);

    ItemStack wandItemStack = NBTUtil.addString(rawItem, NBT_KEY);
    player.getInventory().addItem(wandItemStack);

    messageHandler.send(player, "region.wand.provider");
  }

}

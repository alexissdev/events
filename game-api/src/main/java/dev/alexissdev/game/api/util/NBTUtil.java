package dev.alexissdev.game.api.util;

import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class NBTUtil {

  /**
   * Adds a string to an item stack
   *
   * @param itemStack The item stack you want to add the string to.
   * @param value     The value to be added to the item.
   * @return An ItemStack
   */
  public static ItemStack addString(ItemStack itemStack, String value) {
    return addString(itemStack, value, value);
  }

  /**
   * It adds a string to an item
   *
   * @param itemStack The item stack you want to add the string to.
   * @param key       The key of the string you want to add.
   * @param value     The value to add to the item.
   * @return The itemStack with the new NBT tag.
   */
  public static ItemStack addString(ItemStack itemStack, String key, String value) {
    NBTItem nbtItem = new NBTItem(itemStack);

    nbtItem.setString(key, value);

    return nbtItem.getItem();
  }

  /**
   * It returns a list of all the keys in the NBT tag of the given item
   *
   * @param itemStack The item stack to get the keys from.
   * @return A list of all the keys in the NBT tag.
   */
  public static List<String> getKeys(ItemStack itemStack) {
    NBTItem nbtItem= new NBTItem(itemStack);

    return new ArrayList<>(nbtItem.getKeys());
  }


  /**
   * It gets a string from an item stack
   *
   * @param itemStack The item stack you want to get the NBT tag from.
   * @param key       The key of the value you want to get.
   * @return A string
   */
  public static String getString(ItemStack itemStack, String key) {
    NBTItem nbtItem = new NBTItem(itemStack);
    String nbtString = nbtItem.getString(key);

    if (nbtString == null || nbtString.trim().isEmpty()) {
      return null;
    }

    return nbtString;
  }
}

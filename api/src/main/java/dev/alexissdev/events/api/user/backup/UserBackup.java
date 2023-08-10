package dev.alexissdev.events.api.user.backup;

import dev.alexissdev.commons.validate.Validate;
import java.util.Collection;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class UserBackup {

    private final ItemStack[] inventoryContents;
    private final ItemStack[] armorContents;
    private final GameMode gameMode;
    private final boolean allowFlight;
    private final double health;
    private final int food;
    private final float flySpeed;
    private final float walkSpeed;
    private final Collection<PotionEffect> potionEffects;
    private final Location location;
    private final int level;
    private final float xp;

    private UserBackup(
            ItemStack[] inventoryContents, ItemStack[] armorContents,
            GameMode gameMode,
            boolean allowFlight, double health,
            int food,
            float flySpeed,
            float walkSpeed,
            Collection<PotionEffect> potionEffects,
            Location location,
            int level,
            float xp
    ) {
        this.inventoryContents = inventoryContents;
        this.armorContents = armorContents;
        this.gameMode = gameMode;
        this.allowFlight = allowFlight;
        this.health = health;
        this.food = food;
        this.flySpeed = flySpeed;
        this.walkSpeed = walkSpeed;
        this.potionEffects = potionEffects;
        this.location = location;
        this.level = level;
        this.xp = xp;
    }

    /**
     * It creates a new UserBackup object with the player's inventory, armor, gamemode, flight, health, food, fly speed,
     * walk speed, and potion effects
     *
     * @param player The player to create a backup for.
     * @return A new UserBackup object.
     */
    public static UserBackup create(Player player) {
        Validate.notNull(player, "player");

        return new UserBackup(
                player.getInventory().getContents(),
                player.getInventory().getArmorContents(),
                player.getGameMode(),
                player.getAllowFlight(),
                player.getHealth(),
                player.getFoodLevel(),
                player.getFlySpeed(),
                player.getWalkSpeed(),
                player.getActivePotionEffects(),
                player.getLocation(),
                player.getLevel(),
                player.getExp()
        );
    }

    /**
     * It returns the contents of the inventory
     *
     * @return The inventory contents of the player.
     */
    public ItemStack[] getInventoryContents() {
        return inventoryContents;
    }

    /**
     * It returns the armor contents of the player
     *
     * @return The armor contents of the player.
     */
    public ItemStack[] getArmorContents() {
        return armorContents;
    }

    /**
     * This function returns the game mode of the player.
     *
     * @return The game mode of the player.
     */
    public GameMode getGameMode() {
        return gameMode;
    }

    /**
     * Returns true if the player is allowed to fly.
     *
     * @return The boolean value of allowFlight.
     */
    public boolean getAllowFlight() {
        return allowFlight;
    }

    /**
     * This function returns the health of the player.
     *
     * @return The health of the player.
     */
    public double getHealth() {
        return health;
    }

    /**
     * This function returns the value of the food variable.
     *
     * @return The value of the food variable.
     */
    public int getFood() {
        return food;
    }

    /**
     * It returns a collection of potion effects
     *
     * @return A collection of potion effects.
     */
    public Collection<PotionEffect> getPotionEffects() {
        return potionEffects;
    }

    /**
     * This function returns the fly speed of the player.
     *
     * @return The flySpeed variable is being returned.
     */
    public float getFlySpeed() {
        return flySpeed;
    }

    /**
     * Returns the speed at which a player walks.
     *
     * @return The walkSpeed variable is being returned.
     */
    public float getWalkSpeed() {
        return walkSpeed;
    }

    /**
     * This function returns the location of the current object.
     *
     * @return The location of the object.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * This function returns the level of the player.
     *
     * @return The level of the player.
     */
    public int getLevel() {
        return level;
    }

    /**
     * This function returns the experience of the player.
     *
     * @return The experience of the player.
     */
    public float getExp() {
        return xp;
    }
}
package dev.alexissdev.game.api.region.wand;

import org.bukkit.Location;
import org.jetbrains.annotations.Nullable;

public class RegionWandContainer {

  private Location oneLocation;
  private Location secondLocation;

  private RegionWandContainer() {
    this.oneLocation = null;
    this.secondLocation = null;
  }

  /**
   * It creates a new RegionWandContainer object with the given locations
   *
   * @return A new instance of the RegionWandContainer class.
   */
  public static RegionWandContainer create() {
    return new RegionWandContainer();
  }

  /**
   * This function returns the value of the oneLocation variable.
   *
   * @return The location of the oneLocation variable.
   */
  public @Nullable Location getOneLocation() {
    return oneLocation;
  }

  /**
   * This function sets the value of the oneLocation variable to the value of the oneLocation
   * parameter.
   *
   * @param oneLocation The location of the first point.
   */
  public void setOneLocation(Location oneLocation) {
    this.oneLocation = oneLocation;
  }

  /**
   * This function returns the second location variable.
   *
   * @return The location of the second point.
   */
  public @Nullable Location getSecondLocation() {
    return secondLocation;
  }

  /**
   * This function sets the value of the second location variable to the value of the second location
   * parameter
   *
   * @param secondLocation The location of the second player.
   */
  public void setSecondLocation(Location secondLocation) {
    this.secondLocation = secondLocation;
  }

}

package dev.alexissdev.game.api.region;

import dev.alexissdev.commons.validate.Validate;
import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import team.unnamed.pixel.storage.codec.ModelReader;
import team.unnamed.pixel.storage.model.Model;
import team.unnamed.pixel.storage.mongo.codec.DocumentCodec;
import team.unnamed.pixel.storage.mongo.codec.DocumentWriter;

public class GameRegion
    implements Model,
    DocumentCodec {

  protected final String id;
  protected final int x1;
  protected final int x2;
  protected final int y1;
  protected final int y2;
  protected final int z1;
  protected final int z2;
  protected final String worldName;

  private GameRegion(@NotNull String id, @NotNull Location minimum, @NotNull Location maximum) {
    this(
        id,
        minimum.getBlockX(),
        maximum.getBlockX(),
        minimum.getBlockY(),
        maximum.getBlockY(),
        minimum.getBlockZ(),
        maximum.getBlockZ(),
        minimum.getWorld().getName()
    );
  }

  protected GameRegion(@NotNull String id, int x1, int x2, int y1, int y2, int z1, int z2,
      @NotNull String worldName) {
    this.id = id;
    this.worldName = worldName;
    this.x1 = x1;
    this.x2 = x2;
    this.y1 = y1;
    this.y2 = y2;
    this.z1 = z1;
    this.z2 = z2;
  }

  /**
   * Create a new region from two locations.
   *
   * @param oneLocation The first location of the region.
   * @param twoLocation The second location of the region.
   * @return A new instance of the Region class.
   */
  public static GameRegion of(String id, Location oneLocation, Location twoLocation) {
    return new GameRegion(
        Validate.notNull(id, "id"),
        Validate.notNull(oneLocation, "oneLocation"),
        Validate.notNull(twoLocation, "twoLocation")
    );
  }

  /**
   * It reads a region from a ModelReader
   *
   * @param reader The ModelReader object that is used to read the data from the database.
   * @return A new Region object.
   */
  public static GameRegion read(ModelReader<Document> reader) {
    return new GameRegion(
        reader.readString("_id"),
        reader.readInt("x1"),
        reader.readInt("x2"),
        reader.readInt("y1"),
        reader.readInt("y2"),
        reader.readInt("z1"),
        reader.readInt("z2"),
        reader.readString("world_name")
    );
  }

  @Override
  public String getId() {
    return id;
  }

  /**
   * This function returns the name of the world.
   *
   * @return The worldName variable.
   */
  public @NotNull String getWorldName() {
    return worldName;
  }

  /**
   * If the location is not null, and the location's world name is equal to the region's world name,
   * and the location's vector is in the region's axis-aligned bounding box, then return true.
   *
   * @param location The location to check
   * @return A boolean value.
   */
  public boolean in(@Nullable Location location) {
    return location != null
        && location.getWorld().getName().equalsIgnoreCase(this.worldName)
        && isInAABB(location);
  }

  /**
   * Returns true if the given point is within the AABB.
   *
   * @param point The point to check
   * @return A boolean value.
   */
  private boolean isInAABB(@NotNull Location point) {
    return point.getBlockX() >= x1
        && point.getBlockZ() >= z1
        && point.getBlockX() <= x2
        && point.getBlockZ() <= z2;
  }

  /**
   * Returns the center location of the region.
   *
   * @return A new {@link Location} object.
   */

  public Location getCenter() {
    return new Location(
        Bukkit.getWorld(worldName), x1 + (x2 - x1) / 2.0D, y1 + (y2 - y1) / 2.0D,
        z1 + (z2 - z1) / 2.0D);
  }

  @Override
  public Document serialize() {
    return DocumentWriter.create()
        .write("_id", id)
        .write("x1", x1)
        .write("x2", x2)
        .write("y1", y1)
        .write("y2", y2)
        .write("z1", z1)
        .write("z2", z2)
        .write("world_name", getWorldName())
        .end();
  }
}
package dev.alexissdev.event.game.koth.game;

import dev.alexissdev.game.api.configuration.GameConfiguration;
import dev.alexissdev.game.api.region.GameRegion;
import org.bson.Document;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import team.unnamed.pixel.storage.codec.ModelReader;

public class KothConfiguration
    extends GameConfiguration {

  private final GameRegion kothRegion;
  private int captureTime;

  private KothConfiguration(int minPlayers, int maxPlayers, int waitingTime,
      GameRegion kothRegion, int captureTime) {
    super(minPlayers, maxPlayers, waitingTime);
    this.kothRegion = kothRegion;
    this.captureTime = captureTime;
  }

  /**
   * Creating a new KOTH configuration.
   *
   * @param kothRegion the captured zone region of KOTH.
   * @return the new KOTH configuration.
   */

  @Contract("_, _,  -> new")
  public static @NotNull KothConfiguration create(@Nullable GameRegion kothRegion,
      int captureTime) {
    return new KothConfiguration(-1, -1, -1, kothRegion, captureTime);
  }

  /**
   * Reading a KOTH configuration from a {@link ModelReader}.
   *
   * @param reader the model reader.
   * @return the KOTH configuration.
   */

  @Contract("_ -> new")
  public static @NotNull KothConfiguration read(@NotNull ModelReader<Document> reader) {
    return new KothConfiguration(reader.readInt("minPlayers"),
        reader.readInt("maxPlayers"),
        reader.readInt("waitingTime"),
        reader.readChild("kothRegion", GameRegion::read),
        reader.readInt("capture_time"));
  }

  /**
   * Getting the captured zone region of KOTH.
   *
   * @return the captured zone region of KOTH.
   */

  public GameRegion getKothRegion() {
    return kothRegion;
  }

  public int getCaptureTime() {
    return captureTime;
  }

  public void setCaptureTime(int captureTime) {
    this.captureTime = captureTime;
  }

  @Override
  public Document serialize() {
    return template()
        .write("region", kothRegion)
        .write("capture_time", captureTime)
        .end();
  }
}

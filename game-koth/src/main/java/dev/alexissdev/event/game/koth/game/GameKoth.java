package dev.alexissdev.event.game.koth.game;

import dev.alexissdev.game.api.BasicGame;
import dev.alexissdev.game.api.host.GameHost;
import dev.alexissdev.game.api.reward.GameReward;
import dev.alexissdev.game.api.status.GameStatus;
import java.util.HashSet;
import java.util.Objects;
import org.bson.Document;
import org.jetbrains.annotations.NotNull;
import team.unnamed.pixel.storage.codec.ModelReader;

public class GameKoth extends BasicGame {

  private final KothConfiguration gameConfiguration;
  private KothCapturer kothCapturer;

  private GameKoth(@NotNull String gameId,
      @NotNull KothConfiguration gameConfiguration, @NotNull GameReward gameReward) {
    super(gameId, gameConfiguration, GameHost.CONSOLE_HOST, GameStatus.OFFLINE, gameReward);
    this.gameConfiguration = gameConfiguration;
    this.kothCapturer = null;
  }

  public static GameKoth create(@NotNull String gameId,
      @NotNull KothConfiguration gameConfiguration) {
    return new GameKoth(gameId, gameConfiguration,
        GameReward.create(new HashSet<>(), new HashSet<>()));
  }

  public static GameKoth read(@NotNull ModelReader<Document> reader) {
    return new GameKoth(reader.readString("_id"),
        Objects.requireNonNull(reader.readChild("configuration", KothConfiguration::read)),
        Objects.requireNonNull(reader.readChild("reward", GameReward::read)));
  }

  /**
   * Get the game configuration
   *
   * @return the game configuration
   */

  public KothConfiguration getConfiguration() {
    return gameConfiguration;
  }

  /**
   * Get the koth capturer
   *
   * @return the koth capturer
   */

  public KothCapturer getKothCapturer() {
    return kothCapturer;
  }

  /**
   * Set the koth capturer
   *
   * @param kothCapturer the koth capturer
   */

  public void setKothCapturer(KothCapturer kothCapturer) {
    this.kothCapturer = kothCapturer;
  }
}

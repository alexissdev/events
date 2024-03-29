package dev.alexissdev.game.api;

import dev.alexissdev.game.api.configuration.GameConfiguration;
import dev.alexissdev.game.api.host.GameHost;
import dev.alexissdev.game.api.reward.GameReward;
import dev.alexissdev.game.api.status.GameStatus;
import java.util.HashSet;
import org.bson.Document;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import team.unnamed.pixel.storage.codec.ModelWriter;
import team.unnamed.pixel.storage.mongo.codec.DocumentWriter;

public class BasicGame
    implements GameTemplate {

  protected final String gameId;
  protected final GameConfiguration gameConfiguration;
  protected GameHost gameHost;
  protected GameStatus gameStatus;
  protected GameReward gameReward;

  protected BasicGame(@NotNull String gameId, @NotNull GameConfiguration gameConfiguration,
      @NotNull GameHost gameHost, @NotNull GameStatus status,
      GameReward gameReward) {
    this.gameId = gameId;
    this.gameConfiguration = gameConfiguration;
    this.gameHost = gameHost;
    this.gameStatus = status;
    this.gameReward = gameReward;
  }

  /**
   * Creates a new {@link BasicGame} instance
   *
   * @param gameId            the game id
   * @param gameConfiguration the game configuration
   * @param gameHost          the game host
   * @param status            the game status
   * @return a new {@link BasicGame} instance
   */

  @Contract(value = "_, _, _, _ -> new", pure = true)
  public static @NotNull BasicGame of(@NotNull String gameId,
      @NotNull GameConfiguration gameConfiguration, @NotNull GameHost gameHost,
      @NotNull GameStatus status) {
    return new BasicGame(gameId, gameConfiguration, gameHost, status,
        GameReward.create(new HashSet<>(), new HashSet<>()));
  }

  /**
   * Creates a new {@link BasicGame} instance
   *
   * @param gameId the game id
   * @return a new {@link BasicGame} instance
   */

  @Contract(value = "_, _, _ -> new", pure = true)
  public static @NotNull BasicGame create(@NotNull String gameId,
      @NotNull GameConfiguration configuration, @NotNull GameReward gameReward) {
    return new BasicGame(gameId, configuration, GameHost.CONSOLE_HOST, GameStatus.OFFLINE,
        gameReward);
  }

  @Override
  public String getId() {
    return gameId;
  }

  @Override
  public GameConfiguration getConfiguration() {
    return gameConfiguration;
  }

  @Override
  public GameHost getHost() {
    return gameHost;
  }

  @Override
  public void setHost(@NotNull GameHost host) {
    this.gameHost = host;
  }

  @Override
  public GameStatus getStatus() {
    return gameStatus;
  }

  @Override
  public void setStatus(@NotNull GameStatus status) {
    this.gameStatus = status;
  }

  @Override
  public GameReward getReward() {
    return gameReward;
  }

  @Override
  public void setReward(@NotNull GameReward reward) {
    this.gameReward = reward;
  }

  protected ModelWriter<Document> template() {
    return DocumentWriter.create()
        .write("_id", gameId)
        .write("configuration", gameConfiguration)
        .write("reward", gameReward);
  }

  @Override
  public Document serialize() {
    return template().end();
  }

}

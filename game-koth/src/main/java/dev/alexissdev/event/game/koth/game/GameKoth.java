package dev.alexissdev.event.game.koth.game;

import dev.alexissdev.game.api.BasicGame;
import dev.alexissdev.game.api.configuration.GameConfiguration;
import dev.alexissdev.game.api.host.GameHost;
import dev.alexissdev.game.api.status.GameStatus;
import java.util.Objects;
import org.bson.Document;
import org.jetbrains.annotations.NotNull;
import team.unnamed.pixel.storage.codec.ModelReader;

public class GameKoth extends BasicGame {

  private GameKoth(@NotNull String gameId,
      @NotNull GameConfiguration gameConfiguration,
      @NotNull GameHost gameHost,
      @NotNull GameStatus status) {
    super(gameId, gameConfiguration, gameHost, status);
  }

  public static GameKoth create(@NotNull String gameId,
      @NotNull GameConfiguration gameConfiguration,
      @NotNull GameHost gameHost,
      @NotNull GameStatus status) {
    return new GameKoth(gameId, gameConfiguration, gameHost, status);
  }

  public static GameKoth read(@NotNull ModelReader<Document> reader) {
    return new GameKoth(reader.readString("_id"),
        Objects.requireNonNull(reader.readChild("configuration", GameConfiguration::read)),
        GameHost.CONSOLE_HOST, GameStatus.OFFLINE);
  }
}

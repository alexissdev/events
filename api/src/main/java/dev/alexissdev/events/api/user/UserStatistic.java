package dev.alexissdev.events.api.user;

import dev.alexissdev.events.api.statistic.Statistic;
import java.util.Objects;
import org.bson.Document;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import team.unnamed.pixel.storage.codec.ModelReader;
import team.unnamed.pixel.storage.mongo.codec.DocumentCodec;
import team.unnamed.pixel.storage.mongo.codec.DocumentWriter;

public class UserStatistic implements DocumentCodec {

  private final Statistic winsStatistic;
  private final Statistic lossesStatistic;
  private final Statistic killsStatistic;
  private final Statistic deathsStatistic;
  private final Statistic gamesPlayedStatistic;
  private final Statistic capturedKothsStatistic;

  public UserStatistic(@NotNull Statistic winsStatistic, @NotNull Statistic lossesStatistic,
      @NotNull Statistic killsStatistic, @NotNull Statistic deathsStatistic,
      @NotNull Statistic gamesPlayedStatistic, Statistic capturedKothsStatistic) {
    this.winsStatistic = winsStatistic;
    this.lossesStatistic = lossesStatistic;
    this.killsStatistic = killsStatistic;
    this.deathsStatistic = deathsStatistic;
    this.gamesPlayedStatistic = gamesPlayedStatistic;
    this.capturedKothsStatistic = capturedKothsStatistic;
  }

  /**
   * Creates a new {@link UserStatistic} with the given statistics
   *
   * @param winsStatistic          the wins statistic
   * @param lossesStatistic        the losses statistic
   * @param killsStatistic         the kills statistic
   * @param deathsStatistic        the deaths statistic
   * @param gamesPlayedStatistic   the games played statistic
   * @param capturedKothsStatistic the captured koths statistic
   * @return the user statistic
   */

  @Contract(value = "_, _, _, _, _, _ -> new", pure = true)
  public static @NotNull UserStatistic of(@NotNull Statistic winsStatistic,
      @NotNull Statistic lossesStatistic,
      @NotNull Statistic killsStatistic, @NotNull Statistic deathsStatistic,
      @NotNull Statistic gamesPlayedStatistic,
      @NotNull Statistic capturedKothsStatistic
  ) {
    return new UserStatistic(winsStatistic, lossesStatistic, killsStatistic, deathsStatistic,
        gamesPlayedStatistic, capturedKothsStatistic);
  }

  /**
   * Creates a new {@link UserStatistic} with all the statistics set to 0
   *
   * @return the user statistic
   */

  @Contract(" -> new")
  public static @NotNull UserStatistic create() {
    return new UserStatistic(Statistic.of(0), Statistic.of(0), Statistic.of(0), Statistic.of(0),
        Statistic.of(0), Statistic.of(0));
  }

  /**
   * Reads a {@link UserStatistic} from a {@link ModelReader}
   *
   * @param reader the reader
   * @return the user statistic
   */

  @Contract("_ -> new")
  public static @NotNull UserStatistic read(@NotNull ModelReader<Document> reader) {
    return of(Objects.requireNonNull(reader.readChild("wins", Statistic::read)),
        Objects.requireNonNull(reader.readChild("losses", Statistic::read)),
        Objects.requireNonNull(reader.readChild("kills", Statistic::read)),
        Objects.requireNonNull(reader.readChild("deaths", Statistic::read)),
        Objects.requireNonNull(reader.readChild("games_played", Statistic::read)),
        Objects.requireNonNull(reader.readChild("captured_koths", Statistic::read))
    );
  }

  public Statistic getWinsStatistic() {
    return winsStatistic;
  }

  public Statistic getLossesStatistic() {
    return lossesStatistic;
  }

  public Statistic getKillsStatistic() {
    return killsStatistic;
  }

  public Statistic getDeathsStatistic() {
    return deathsStatistic;
  }

  public Statistic getGamesPlayedStatistic() {
    return gamesPlayedStatistic;
  }

  public Statistic getCapturedKothsStatistic() {
    return capturedKothsStatistic;
  }

  @Override
  public Document serialize() {
    return DocumentWriter.create()
        .write("wins", winsStatistic)
        .write("losses", lossesStatistic)
        .write("kills", killsStatistic)
        .write("deaths", deathsStatistic)
        .write("games_played", gamesPlayedStatistic)
        .write("captured_koths", capturedKothsStatistic)
        .end();
  }
}

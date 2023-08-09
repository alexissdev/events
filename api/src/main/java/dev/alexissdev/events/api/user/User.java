package dev.alexissdev.events.api.user;

import java.util.Objects;
import org.bson.Document;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import team.unnamed.pixel.storage.codec.ModelReader;
import team.unnamed.pixel.storage.model.Model;
import team.unnamed.pixel.storage.mongo.codec.DocumentCodec;
import team.unnamed.pixel.storage.mongo.codec.DocumentWriter;

public class User implements Model, DocumentCodec {

  private final String id;
  private final String displayName;
  private final UserStatistic userStatistic;
  private String language;

  private User(String id, String displayName, UserStatistic userStatistic, String language) {
    this.id = id;
    this.displayName = displayName;
    this.userStatistic = userStatistic;
    this.language = language;
  }

  @Contract(value = "_, _, _, _ -> new", pure = true)
  public static @NotNull User create(@NotNull String id, @NotNull String displayName,
      @NotNull UserStatistic userStatistic, @NotNull String language) {
    return new User(id, displayName, userStatistic, language);
  }

  @Contract("_ -> new")
  public static @NotNull User read(@NotNull ModelReader<Document> reader) {
    return create(reader.readString("_id"), reader.readString("display_name"),
        Objects.requireNonNull(reader.readChild("user_statistic", UserStatistic::read)),
        reader.readString("language"));
  }


  @Override
  public String getId() {
    return id;
  }

  public String getDisplayName() {
    return displayName;
  }

  public UserStatistic getUserStatistic() {
    return userStatistic;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  @Override
  public Document serialize() {
    return DocumentWriter.create()
        .write("_id", id)
        .write("display_name", displayName)
        .write("language", language)
        .write("user_statistic", userStatistic)
        .end();
  }
}

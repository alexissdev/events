package dev.alexissdev.events.api.statistic;

import org.bson.Document;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import team.unnamed.pixel.storage.codec.ModelReader;
import team.unnamed.pixel.storage.mongo.codec.DocumentCodec;
import team.unnamed.pixel.storage.mongo.codec.DocumentWriter;

public class Statistic
        implements DocumentCodec {

    private int value;

    private Statistic(int value) {
        this.value = value;
    }

    /**
     * Creates a new statistic with the given value
     * @param value the value of the statistic
     * @return the new statistic
     */
    @Contract(value = "_ -> new", pure = true)
    public static @NotNull Statistic of(int value) {
        return new Statistic(value);
    }

    /**
     * Reads a statistic from a {@link ModelReader}
     * @param reader the reader
     * @return the statistic
     */

    public static @NotNull Statistic read(@NotNull ModelReader<Document> reader) {
        return Statistic.of(reader.readInt("value"));
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public Document serialize() {
        return DocumentWriter.create()
                .write("value", value)
                .end();
    }
}

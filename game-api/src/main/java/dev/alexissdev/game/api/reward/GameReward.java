package dev.alexissdev.game.api.reward;

import dev.alexissdev.commons.storage.bukkit.item.SerializableItem;
import dev.alexissdev.commons.storage.bukkit.text.SerializableString;
import java.util.LinkedHashSet;
import java.util.Set;
import org.bson.Document;
import team.unnamed.pixel.storage.codec.ModelReader;
import team.unnamed.pixel.storage.mongo.codec.DocumentCodec;
import team.unnamed.pixel.storage.mongo.codec.DocumentWriter;

public class GameReward
        implements DocumentCodec {

    protected Set<SerializableItem> rewardItemSet;
    protected Set<SerializableString> commandRewardSet;

    protected GameReward(Set<SerializableItem> rewardItemSet, Set<SerializableString> commandRewardSet) {
        this.rewardItemSet = new LinkedHashSet<>(rewardItemSet);
        this.commandRewardSet = new LinkedHashSet<>(commandRewardSet);
    }

    /**
     * "This function creates a new GameReward object with the given rewardItemSet and commandRewardSet."
     * <p>
     * The first line of the function is the function's signature. It tells us the function's name, the type of the
     * function's return value, and the types of the function's parameters
     *
     * @param rewardItemSet    A set of items that will be given to the player when they win the game.
     * @param commandRewardSet A set of commands that will be executed when the player wins the game.
     * @return A new GameReward object.
     */
    public static GameReward create(Set<SerializableItem> rewardItemSet, Set<SerializableString> commandRewardSet) {
        return new GameReward(rewardItemSet, commandRewardSet);
    }

    /**
     * "Reads a GameReward from a ModelReader."
     * <p>
     * The first line of the function is the return type. In this case, it's a GameReward
     *
     * @param reader The ModelReader object that is used to read the data from the file.
     * @return A GameReward object
     */
    public static GameReward read(ModelReader<Document> reader) {
        return create(
                reader.readChildren("item_set", SerializableItem::read),
                reader.readChildren("command_set", SerializableString::read)
        );
    }

    /**
     * This function returns the rewardItemSet.
     *
     * @return A set of SerializableItem objects.
     */
    public Set<SerializableItem> getRewardItemSet() {
        return rewardItemSet;
    }

    /**
     * > This function sets the rewardItemSet variable to the value of the rewardItemSet parameter
     *
     * @param rewardItemSet The set of items that will be given to the player when they complete the quest.
     */
    public void setRewardItemSet(Set<SerializableItem> rewardItemSet) {
        this.rewardItemSet = rewardItemSet;
    }

    /**
     * It returns a set of commands
     *
     * @return A set of commands.
     */
    public Set<SerializableString> getCommandRewardSet() {
        return commandRewardSet;
    }

    /**
     * This function sets the commandRewardSet variable to the commandRewardSet parameter
     *
     * @param commandRewardSet A set of CommandContainer objects.
     */
    public void setCommandRewardSet(Set<SerializableString> commandRewardSet) {
        this.commandRewardSet = commandRewardSet;
    }

    /**
     * Returns true if the quest has a reward.
     *
     * @return A boolean value.
     */
    public boolean hasReward() {
        return !rewardItemSet.isEmpty() || !commandRewardSet.isEmpty();
    }

    @Override
    public Document serialize() {
        return DocumentWriter.create()
                .write("item_set", rewardItemSet)
                .write("command_set", commandRewardSet)
                .end();
    }
}
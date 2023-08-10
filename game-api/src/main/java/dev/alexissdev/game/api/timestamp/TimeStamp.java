package dev.alexissdev.game.api.timestamp;

import dev.alexissdev.commons.validate.Validate;
import java.util.concurrent.TimeUnit;
import team.unnamed.pixel.storage.model.Model;

public class TimeStamp
    implements Model {

  protected final String id;
  protected final long endAt;
  protected final int duration;

  protected TimeStamp(String id, int duration) {
    this.id = Validate.notNull(id, "id");
    this.duration = duration;
    this.endAt = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(duration);
  }

  protected TimeStamp(String id, long duration) {
    this.id = Validate.notNull(id, "id");
    this.duration = (int) TimeUnit.MILLISECONDS.toSeconds(duration);
    this.endAt = System.currentTimeMillis() + duration;
  }

  /**
   * Create a new CoolDown object with the given id and duration.
   *
   * @param id       The id of the cooldown.
   * @param duration The duration of the cooldown in seconds.
   * @return A new instance of the CoolDown class.
   */
  public static TimeStamp create(String id, int duration) {
    return new TimeStamp(id, duration);
  }

  @Override
  public String getId() {
    return id;
  }


  /**
   * Convert the difference between the endAt and current time to seconds.
   *
   * @return The time left in seconds.
   */
  public long getTimeLeft() {
    return TimeUnit.MILLISECONDS.toSeconds(endAt - System.currentTimeMillis());
  }

  /**
   * If the current time is greater than the endAt time, then the token is expired
   *
   * @return The difference between the current time and the endAt time.
   */
  public boolean isExpired() {
    return getTimeLeft() <= 0;
  }

  /**
   * Returns the percentage of time left in the timer.
   *
   * @return The percentage of time left in the timer.
   */
  public double toPercentage() {
    double left = getTimeLeft() / (duration + 0.0);
    if (left > 1.0) {
      return 1.0;
    }

    return Math.max(left, 0.0);
  }

}
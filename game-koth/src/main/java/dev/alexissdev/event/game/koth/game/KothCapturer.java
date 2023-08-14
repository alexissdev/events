package dev.alexissdev.event.game.koth.game;

import java.util.UUID;

public class KothCapturer {

  public static final KothCapturer EMPTY = KothCapturer.of(null, null);

  private final UUID capturerId;
  private final String capturerName;

  private KothCapturer(UUID capturerId, String capturerName) {
    this.capturerId = capturerId;
    this.capturerName = capturerName;
  }

  /**
   * Create a new {@link KothCapturer}
   *
   * @param capturerId   the capturer id
   * @param capturerName the capturer name
   * @return the koth capturer
   */

  public static KothCapturer of(UUID capturerId, String capturerName) {
    return new KothCapturer(capturerId, capturerName);
  }

  public UUID getCapturerId() {
    return capturerId;
  }

  public String getCapturerName() {
    return capturerName;
  }
}

package bowling.domain.turn;

import java.util.Objects;

public class BallRelease {
  private final Pins pins;

  public BallRelease(Pins pins) {
    this.pins = pins;
  }

  public boolean checkAddable(Pins pins) {
    return this.pins.checkAddable(pins);
  }

  public Pins fallenPins() {
    return pins;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BallRelease that = (BallRelease) o;
    return Objects.equals(pins, that.pins);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pins);
  }

  public boolean isStrike() {
    return pins.isStrike();
  }
}

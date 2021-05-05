package bowling.domain.turn;

import bowling.error.InvalidFallenPinsException;

import java.util.Objects;

public class Pins {
  private static final int MIN_PINS = 0;
  private static final int MAX_PINS = 10;

  private final int pins;

  public Pins(int pins) {
    checkPins(pins);
    this.pins = pins;
  }

  public void checkPins(int pins) {
    if (pins < MIN_PINS || pins > MAX_PINS) {
      throw new InvalidFallenPinsException();
    }
  }

  public int pins() {
    return pins;
  }

  public boolean checkAddable(Pins pins) {
    int totalFallenPins = this.pins + pins.pins;

    checkPins(totalFallenPins);
    return true;
  }

  public boolean isStrike() {
    return pins == MAX_PINS;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pins pins1 = (Pins) o;
    return pins == pins1.pins;
  }

  @Override
  public int hashCode() {
    return Objects.hash(pins);
  }

  @Override
  public String toString() {
    return "FallenPins{" +
      "pins=" + pins +
      '}';
  }
}
